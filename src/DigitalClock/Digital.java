package DigitalClock;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import AnalogClock.Default;
import AnalogClock.Point;

public class Digital extends JPanel {

    public String getTime(){
        Calendar cal = Calendar.getInstance();
        StringBuilder time = new StringBuilder();
        time.append(String.format("%2d",cal.get(Calendar.HOUR_OF_DAY)).replace(" ","0")+" : ");
        time.append(String.format("%2d",cal.get(Calendar.MINUTE)).replace(" ","0")+" : ");
        time.append(String.format("%2d",cal.get(Calendar.SECOND)).replace(" ","0"));
        return time.toString();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Default.backGroundColor);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        String time = getTime();
        Point center = new Point(this.getWidth()/2, this.getHeight()/2);
        Font clockFont = new Font("Times New Roman", Font.BOLD , this.getHeight()/5);
        FontMetrics clockMetrics = this.getFontMetrics(clockFont);
        g.setFont( clockFont );
        g.setColor(Color.WHITE);
        int padding = 10;
        System.out.println(center.toString());
        int xPos = center.getX() - clockMetrics.stringWidth(time)/2;
        int yPos = center.getY() + clockMetrics.getAscent()/2;
        int height = clockMetrics.getAscent()+clockMetrics.getDescent();
        g.drawRect(xPos-padding/2,center.getY()-height/2, clockMetrics.stringWidth(time)+padding, height);
        g.drawString(time, xPos,yPos);
    }
}
