package AnalogClock;

public class AnalogClock {

    private int radius;
    private static final int padding=10;
    private Point center;
    private int panelLength;
    private AnalogPosition position;
    private int lenSecondHand, lenMinuteHand, lenHoursHand;

    public AnalogClock(int height, int width){
        this.panelLength= (height>width)?width:height;
        this.center = new Point(width/2,height/2);
        this.radius = (this.panelLength-padding)/2;
        this.position = new AnalogPosition(this.radius);
        this.lenSecondHand=(int)(0.9*radius);
        this.lenMinuteHand=(int)(0.8*radius);
        this.lenHoursHand=(int)(0.6*radius);
    }

    public int getRadius() {
        return radius;
    }

    public static int getPadding() {
        return padding;
    }

    public Point getCenter() {
        return center;
    }

    public int getPanelLength() {
        return panelLength;
    }

    public AnalogPosition getPosition() {
        return position;
    }

    public int getLenSecondHand() {
        return lenSecondHand;
    }

    public int getLenMinuteHand() {
        return lenMinuteHand;
    }

    public int getLenHoursHand() {
        return lenHoursHand;
    }

}
