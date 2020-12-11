package Clock;

public class AnalogPosition {
    private int radius;
    private double hourAngle;
    private double minuteAngle;
    private double secondAngle;
    public AnalogPosition(int radius){
        this.radius = radius;
    }

    public void setAngles(double hour, double minute, double second ) {
        double[] values = new double[3];
        hourAngle=-1*(hour+minute/60)*Math.PI/6+Math.PI/2;
        minuteAngle=-1*(minute+second/60)*Math.PI/30+Math.PI/2;
        secondAngle=-1*(second)*Math.PI/30+Math.PI/2;
    }

    public double getHourAngle() {
        return hourAngle;
    }

    public double getMinuteAngle() {
        return minuteAngle;
    }

    public double getSecondAngle() {
        return secondAngle;
    }
}
