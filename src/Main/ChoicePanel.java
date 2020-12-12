package Main;

import AnalogClock.Default;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoicePanel extends JPanel {

    private JButton choice;
    private Boolean choiceIsAnalog;
    private static final String beforePressing = "Go Digital";
    private static final String afterPressing = "Go Analog";

    public ChoicePanel(ActionListener asl){
        this.choice = new JButton (ChoicePanel.beforePressing);
        this.choiceIsAnalog = true;
        this.choice.addActionListener(asl);
        this.add(choice);
    }
    public boolean getChoice(){
        return choiceIsAnalog;
    }

    public void setChoice(Boolean choiceIsAnalog) {
        this.choiceIsAnalog = choiceIsAnalog;
    }

    public static String getBeforePressing() {
        return beforePressing;
    }

    public static String getAfterPressing() {
        return afterPressing;
    }
    public JButton getButton(){
        return choice;
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Default.backGroundColor);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
    }
}
