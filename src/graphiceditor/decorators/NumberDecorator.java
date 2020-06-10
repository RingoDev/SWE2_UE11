package graphiceditor.decorators;

import graphiceditor.objects.GraphicObject;

import java.awt.*;

public class NumberDecorator extends Decorator {

    private static Integer counter = 1;
    private final Integer number;

    public NumberDecorator(GraphicObject object) {
        super(object);
        number = counter;
        counter++;
    }

    @Override
    public void paint(Graphics g) {
        object.paint(g);
        Color old = g.getColor();
        drawCenteredString(g, number.toString());
        g.setColor(old);
    }

    @Override
    public GraphicObject copy(int x, int y) {
        return new NumberDecorator(object.copy(x, y));
    }

    public void drawCenteredString(Graphics g, String text) {
        g.setColor(getContrastColor(g.getColor()));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = object.getX() - (metrics.stringWidth(text) / 2);
        int y = object.getY() + (-metrics.getHeight() / 2) + metrics.getAscent();
        g.drawString(text, x, y);
    }
}
