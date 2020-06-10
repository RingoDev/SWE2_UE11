package graphiceditor.objects;

import graphiceditor.visitors.Visitor;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Base class for graphical objects.
 */
public abstract class GraphicObject {

    protected int x;
    protected int y;
    private Color color;

    /**
     * Constructor initializing x- and y-coordinate
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    protected GraphicObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }


    /**
     * Gets the y-coordinate
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * Gets the color of this object
     *
     * @return the color
     */

    public Color getColor() {
        return color;
    }

    /**
     * Sets the x-coordinate
     *
     * @param x the x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate
     *
     * @param y the y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the color
     *
     * @param c the color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * Paints the graphical object on this graphic object
     *
     * @param g the graphics context
     */
    public abstract void paint(Graphics g);

    /**
     * Gets the width of this object
     *
     * @return the width
     */
    public abstract int getWidth();

    /**
     * Gets the height of this object
     *
     * @return the height
     */
    public abstract int getHeight();

    public abstract GraphicObject copy(int x, int y);

    public abstract void accept(Visitor visitor);

}
