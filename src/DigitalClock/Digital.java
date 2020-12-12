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
        int padding = 10;
        int[] drawData = Default.drawText(g,this, center, padding, clockFont, time, Color.WHITE);
        int xPos = center.getX() - drawData[0]/2;
        int yPos = center.getY() + drawData[1]/2;
        int height = drawData[1]+drawData[2];
        g.drawRect(xPos-padding/2,center.getY()-height/2, drawData[0]+padding, height);
        g.drawString(time, xPos,yPos);
    }
}
