package Main;

import AnalogClock.Analog;
import AnalogClock.Default;
import Date.DatePanel;
import DigitalClock.Digital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockGUI {
    private JFrame frame;
    private Digital dClock;
    private Analog aClock;
    private DatePanel datePanel;
    private ChoicePanel choicePanel;
    public ClockGUI(){
        this.frame=new JFrame();
        this.frame.setTitle("Clock");
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d= tk.getScreenSize();
        this.frame.setSize(d.width/2, d.height/2);// setting the screen size as half of the width and height of the screen size
        this.frame.setLocation((d.width-frame.getWidth())/2,(d.height-frame.getHeight())/2);
        this.frame.setBackground(Default.backGroundColor);//setting the background colour for the window
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Setting the default close operation
        this.frame.setLayout(new BorderLayout());
        this.dClock = new Digital();
        this.aClock = new Analog();
        this.datePanel = new DatePanel();
        this.datePanel.setPreferredSize(new Dimension(this.frame.getWidth(), this.frame.getHeight()/5));
        this.choicePanel = new ChoicePanel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jbt = (JButton)e.getSource();
                if(jbt.equals(choicePanel.getButton()) && choicePanel.getChoice()==true){
                    choicePanel.setChoice(false);
                    choicePanel.getButton().setText(ChoicePanel.getAfterPressing());
                    frame.remove(aClock);
                    frame.add(dClock,BorderLayout.CENTER);
                } else if (jbt.equals(choicePanel.getButton()) && choicePanel.getChoice()==false){
                    choicePanel.setChoice(true);
                    choicePanel.getButton().setText(ChoicePanel.getBeforePressing());
                    frame.remove(dClock);
                    frame.add(aClock,BorderLayout.CENTER);
                }
            }
        });
        this.frame.setVisible(true);
    }

    public void start(){
        frame.add(aClock,BorderLayout.CENTER);
        frame.add(datePanel,BorderLayout.SOUTH);
        frame.add(choicePanel,BorderLayout.NORTH);
        int interval=650;//the interval of the timer is set to 1ms.
        ActionListener clockTime=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                aClock.repaint();
                dClock.repaint();
                datePanel.repaint();
            }
        };
        Timer t=new Timer(interval,clockTime);
        t.start();
    }

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        new ClockGUI().start();
    }
}
