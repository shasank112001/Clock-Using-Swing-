package Clock;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Analog extends JPanel {

    private int radius;
    private static final int padding=10;
    private Point center;
    private int panelLength;
    private AnalogPosition p;
    private int lenSecondHand, lenMinuteHand, lenHoursHand;
    public Analog(){
       super();
       this.panelLength= (this.getHeight()>this.getWidth())?this.getWidth():this.getHeight();
       this.center = new Point(panelLength/2,panelLength/2);
       this.radius = this.panelLength/2-padding;
       this.p = new AnalogPosition(this.radius);
       this.lenSecondHand=(int)(0.95*radius);
       this.lenMinuteHand=(int)(0.8*radius);
       this.lenHoursHand=(int)(0.6*radius);
    }
    public void drawCircle(Graphics g){
        g.setColor(new Color(0,0,0));// setting the color to black
        g.drawOval(this.center.getX(),this.center.getY(),radius,radius);
        g.setColor(Color.WHITE);
        g.drawOval(this.center.getX(),this.center.getY(),radius-padding,radius-padding);
    }

    public void drawHands(Graphics g,int hours,int minutes, int seconds){
        this.p.setAngles(hours, minutes, seconds);
        int xPos,yPos;//these are the coordinates of the other end of the hands.
        g.setColor(Color.BLACK);
//        drawing the seconds hand
        xPos = (int)(this.center.getX()+lenSecondHand*Math.cos(this.p.getSecondAngle()));
        yPos = (int)(this.center.getY()-lenSecondHand*Math.sin(this.p.getSecondAngle()));
        g.drawLine(this.center.getX(), this.center.getY(), xPos, yPos);
//        drawing the minutes hand
        xPos = (int)(this.center.getX()+lenMinuteHand*Math.cos(this.p.getMinuteAngle()));
        yPos = (int)(this.center.getY()-lenMinuteHand*Math.sin(this.p.getMinuteAngle()));
        g.drawLine(this.center.getX(), this.center.getY(), xPos, yPos);
//        drawing the hours hand
        xPos = (int)(this.center.getX()+lenHoursHand*Math.cos(this.p.getHourAngle()));
        yPos = (int)(this.center.getY()-lenHoursHand*Math.sin(this.p.getHourAngle()));
        g.setColor(Color.RED);
        g.drawLine(this.center.getX(), this.center.getY(), xPos, yPos);
    }
    public void drawMarkings(Graphics g){
        int r=0,radiusBig=this.radius/30, radiusSmall=this.radius/50;
        g.setColor(Color.BLACK);
        int distFromCenter=(int)(radius-0.1*radius);//this refers to the distance of the centre of the markings from the centre of the clock
        double angle=0;
        //The value of x and y denotes the point where the markings will be made
        int x,y;
        for(int i=0;i<12;i++)
        {
            if(i%3==0)//deciding the radius of the markings
                r=radiusBig;
            else
                r=radiusSmall;
            x=this.center.getX();
            y=this.center.getY();
            y+=(int)(distFromCenter*Math.cos(angle));
            x+=(int)(distFromCenter*Math.sin(angle));
            angle+=Math.PI/6;
            g.fillOval(x-r/2, y-r/2, r, r);

        }
    }
    public void paintComponent(Graphics g)
    {
        this.drawMarkings(g);
        Calendar cal=Calendar.getInstance();
        drawHands(g,cal.get(Calendar.HOUR_OF_DAY)%12,cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
    }
}
