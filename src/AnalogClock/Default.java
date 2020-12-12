package AnalogClock;

import javax.swing.*;
import java.awt.*;

public class Default {
    public static final Color backGroundColor = Color.BLACK;
    public static final Font font = new Font("Times New Roman", Font.BOLD, 25);
    public static int[] drawText(Graphics g, JPanel obj, Point center, int padding, Font font, String text, Color fontColor){
        FontMetrics metrics = obj.getFontMetrics(font);
        g.setFont( font );
        g.setColor(fontColor);
        int xPos = center.getX() - metrics.stringWidth(text)/2;
        int yPos = center.getY() + metrics.getAscent()/2;
        int height = metrics.getAscent()+metrics.getDescent();
        g.drawString(text, xPos,yPos);
        return new int[] {metrics.stringWidth(text), metrics.getAscent(), metrics.getDescent(), metrics.getLeading()};
    }

}
