package Clock;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Analog extends JPanel {
    private AnalogClock clock;
    public Analog(){
       super();
    }

    public void drawCircle(Graphics g){
        int cornerX= (this.clock.getCenter().getX()-this.clock.getRadius());
        int cornerY= (this.clock.getCenter().getY()-this.clock.getRadius());
        g.setColor(new Color(0,0,0));// setting the color to black
        g.fillOval(cornerX,cornerY, this.clock.getRadius()*2,this.clock.getRadius()*2);
        g.setColor(Color.WHITE);
        g.fillOval(cornerX+AnalogClock.getPadding()/2, cornerY+AnalogClock.getPadding()/2,(this.clock.getRadius()-AnalogClock.getPadding()/2)*2,(this.clock.getRadius()-AnalogClock.getPadding()/2)*2);
    }

    public void drawHands(Graphics g,int hours,int minutes, int seconds){
        this.clock.getPosition().setAngles(hours, minutes, seconds);
        int xPos,yPos;//these are the coordinates of the other end of the hands.
        g.setColor(Color.BLACK);
//        drawing the seconds hand
        xPos = (int)(this.clock.getCenter().getX()+this.clock.getLenSecondHand()*Math.cos(this.clock.getPosition().getSecondAngle()));
        yPos = (int)(this.clock.getCenter().getY()-this.clock.getLenSecondHand()*Math.sin(this.clock.getPosition().getSecondAngle()));
        g.drawLine(this.clock.getCenter().getX(), this.clock.getCenter().getY(), xPos, yPos);
//        drawing the minutes hand
        xPos = (int)(this.clock.getCenter().getX()+this.clock.getLenMinuteHand()*Math.cos(this.clock.getPosition().getMinuteAngle()));
        yPos = (int)(this.clock.getCenter().getY()-this.clock.getLenMinuteHand()*Math.sin(this.clock.getPosition().getMinuteAngle()));
        g.drawLine(this.clock.getCenter().getX(), this.clock.getCenter().getY(), xPos, yPos);
//        drawing the hours hand
        xPos = (int)(this.clock.getCenter().getX()+this.clock.getLenHoursHand()*Math.cos(this.clock.getPosition().getHourAngle()));
        yPos = (int)(this.clock.getCenter().getY()-this.clock.getLenHoursHand()*Math.sin(this.clock.getPosition().getHourAngle()));
        g.setColor(Color.RED);
        g.drawLine(this.clock.getCenter().getX(), this.clock.getCenter().getY(), xPos, yPos);
    }
    public void drawMarkings(Graphics g){
        int r=0,radiusBig=this.clock.getRadius()/30, radiusSmall=this.clock.getRadius()/50;
        g.setColor(Color.BLACK);
        int distFromCenter=(int)(this.clock.getRadius()-0.1*this.clock.getRadius());//this refers to the distance of the centre of the markings from the centre of the clock
        double angle=0;
        //The value of x and y denotes the point where the markings will be made
        int x,y;
        for(int i=0;i<12;i++)
        {
            if(i%3==0)//deciding the this.clock.getRadius() of the markings
                r=radiusBig;
            else
                r=radiusSmall;
            x=this.clock.getCenter().getX();
            y=this.clock.getCenter().getY();
            y+=(int)(distFromCenter*Math.cos(angle));
            x+=(int)(distFromCenter*Math.sin(angle));
            angle+=Math.PI/6;
            g.fillOval(x-r/2, y-r/2, r, r);

        }
    }
    public void paintComponent(Graphics g)
    {
        this.clock = new AnalogClock(this.getHeight(),this.getWidth());
        this.drawCircle(g);
        this.drawMarkings(g);
        Calendar cal=Calendar.getInstance();
        drawHands(g,cal.get(Calendar.HOUR_OF_DAY)%12,cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
    }
}
