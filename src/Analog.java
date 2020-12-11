import Clock.AnalogPosition;
import Clock.Point;
import javax.swing.*;
import java.awt.*;

public class Analog extends JPanel {

    private int radius;
    private static final int padding=10;
    private Point center;
    private int panelLength;
    private AnalogPosition p;
    public Analog(){
       this.panelLength= (this.getHeight()>this.getWidth())?this.getWidth():this.getHeight();
       this.center = new Point(panelLength/2,panelLength/2);
       this.radius = this.panelLength/2-padding;
       this.p = new AnalogPosition(this.radius);
    }
    public void drawCircle(Graphics g){
        g.setColor(new Color(0,0,0));// setting the color to black
        g.drawOval(this.center.getX(),this.center.getY(),radius,radius);
        g.setColor(Color.WHITE);
        g.drawOval(this.center.getX(),this.center.getY(),radius-padding,radius-padding);
    }

    public void drawHands(Graphics g){

    }
}
