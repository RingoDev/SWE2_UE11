package graphiceditor.objects;

import graphiceditor.visitors.Visitor;

import java.awt.Graphics;

/**
 * Circular graphical object.
 */
public class Circle extends GraphicObject {

    private final int r;

    /**
     * Constructor initializing center and radius
     *
     * @param x the x-coordinate of the circle
     * @param y the y-coordinate of the circle
     * @param r the radius of the circle
     */
    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    /**
     * Paints the circle on the graphics context
     *
     * @param g the graphics context
     */
    @Override
    public void paint(Graphics g) {
        g.fillOval(x - r, y - r, r * 2, r * 2);
    }

    /**
     * Returns a string representation.
     */
    @Override
    public String toString() {
        return "Circle[" + r + "]";
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

    public GraphicObject copy(int x, int y) {
        return new Circle(this.x + x, this.y + y, this.r);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }
}
