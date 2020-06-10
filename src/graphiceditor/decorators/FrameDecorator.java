package graphiceditor.decorators;

import graphiceditor.objects.GraphicObject;


import java.awt.*;

public class FrameDecorator extends Decorator {

    public FrameDecorator(GraphicObject object) {
        super(object);
    }

    @Override
    public void paint(Graphics g) {
        object.paint(g);
        int frameWidth = (int) (object.getWidth() * 1.2);
        int frameHeight = (int) (object.getHeight() * 1.2);
        g.drawRect(object.getX() - frameHeight / 2, object.getY() - frameWidth / 2, frameWidth, frameHeight);
    }

    @Override
    public GraphicObject copy(int x, int y) {
        return new FrameDecorator(object.copy(x, y));
    }

}
