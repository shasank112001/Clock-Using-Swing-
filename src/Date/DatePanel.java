package Date;

import AnalogClock.Default;
import AnalogClock.Point;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DatePanel extends JPanel {

    public String getMonthName(int month){
        String monthName = "INCORRECT";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] monthNames = dfs.getMonths();
        if(month>=0 && month<12)
            return monthNames[month];
        return monthName;
    }
    public String getDate(){
        Calendar cal = Calendar.getInstance();
        StringBuilder time = new StringBuilder();
        time.append(cal.get(Calendar.DATE)+" ");
        time.append(this.getMonthName(cal.get(Calendar.MONTH)) + " ");
        time.append(cal.get(Calendar.YEAR));
        System.out.println(time);
        return time.toString();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Default.backGroundColor);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        String date = getDate();
        AnalogClock.Point center = new Point(this.getWidth()/2, this.getHeight()/2);
        Font dateFont = new Font(Default.font.getName(), Default.font.getStyle(), this.getHeight()/2);
        int padding = 10;
        Default.drawText(g,this, center, padding, dateFont, date, Color.WHITE);
    }
}
