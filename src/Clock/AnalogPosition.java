package Clock;

public class AnalogPosition {
    private int radius;

    public AnalogPosition(int radius){
        this.radius = radius;
    }

    public double[] getAngles(double hour, double minute, double second ) {
        double[] values = new double[3];
        values[0]=-1*(hour+minute/60)*Math.PI/6+Math.PI/2;
        values[1]=-1*(minute+second/60)*Math.PI/30+Math.PI/2;
        values[2]=-1*(second)*Math.PI/30+Math.PI/2;
        return values;
    }
}
