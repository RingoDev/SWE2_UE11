package graphiceditor.decorators;

import graphiceditor.objects.GraphicObject;
import graphiceditor.visitors.Visitor;

import java.awt.*;

abstract class Decorator extends GraphicObject {

    protected final GraphicObject object;

    protected Decorator(GraphicObject object) {
        super(object.getX(), object.getY());
        this.object = object;
    }

    @Override
    public void paint(Graphics g) {
        this.object.paint(g);
    }

    @Override
    public int getWidth() {
        return object.getWidth();
    }

    @Override
    public int getHeight() {
        return object.getHeight();
    }

    @Override
    public abstract GraphicObject copy(int x, int y);

    @Override
    public int getX() {
        return object.getX();
    }

    @Override
    public int getY() {
        return object.getY();
    }

    public static Color getContrastColor(Color color) {
        int y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
        return y >= 128 ? Color.black : Color.white;
    }

    @Override
    public void accept(Visitor visitor) {
        this.object.accept(visitor);
    }
}
