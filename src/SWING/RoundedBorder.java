package SWING;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;

public class RoundedBorder implements Border {

    private int thickness;

    public RoundedBorder(int thickness) {
        this.thickness = thickness;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int borderThickness = thickness;
        g2d.setStroke(new BasicStroke(borderThickness));
        g.drawOval(x + thickness / 2, y + thickness / 2, width - borderThickness, height - borderThickness);
        g2d.dispose();
    }
}