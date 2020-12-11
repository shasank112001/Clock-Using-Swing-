package test;

import Clock.Analog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


public class AnalogTest {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JFrame frame=new JFrame();
        frame.setTitle("Clock");
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d= tk.getScreenSize();
        frame.setSize(d.width/2, d.height/2);// setting the screen size as half of the width and height of the screen size
        frame.setLocation((d.width-frame.getWidth())/2,(d.height-frame.getHeight())/2);
        frame.setBackground(new Color(0,0,0));//setting the background colour for the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Setting the default close operation

        Analog clock = new Analog();
        frame.setLayout(new BorderLayout());
        frame.add(clock);
        int interval=650;//the interval of the timer is set to 1ms.
        ActionListener clockTime=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.repaint();
            }
        };
        Timer t=new Timer(interval,clockTime);
        t.start();

        frame.setVisible(true);
    }
}
