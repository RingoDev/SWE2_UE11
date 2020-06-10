package graphiceditor.objects;

import graphiceditor.visitors.Visitor;

import java.awt.*;

/**
 * Circular graphical object.
 */
public class Pentagon extends GraphicObject {

    private final int r;

    /**
     * Constructor initializing center and radius
     *
     * @param x the x-coordinate of the pentagon
     * @param y the y-coordinate of the pentagon
     * @param r the radius of the pentagon
     */
    public Pentagon(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    /**
     * Paints the pentagon on the graphics context
     *
     * @param g the graphics context
     */
    @Override
    public void paint(Graphics g) {

        int[] xArr = new int[5];
        int[] yArr = new int[5];

        for (int i = 0; i < 5; i++) {
            xArr[i] = x + (int) (r * Math.cos(Math.toRadians(90 + (360 / 5.0) * i)));
            yArr[i] = y + (int) (r * Math.sin(Math.toRadians(90 + (360 / 5.0) * i)));
        }
        g.fillPolygon(xArr, yArr, 5);
    }

    /**
     * Returns a string representation.
     */
    @Override
    public String toString() {
        return "Pentagon[" + r + "]";
    }

    /**
     * Gets the width of this object
     *
     * @return the width
     */
    @Override
    public int getWidth() {
        return 2 * r;
    }

    /**
     * Gets the height of this object
     *
     * @return the height
     */
    @Override
    public int getHeight() {
        return getWidth();
    }

    @Override
    public GraphicObject copy(int x, int y) {
        return new Pentagon(this.x + x, this.y + y, this.r);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPentagon(this);
    }

}
