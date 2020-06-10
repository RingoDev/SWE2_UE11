package graphiceditor.visitors;

import graphiceditor.objects.Circle;
import graphiceditor.objects.Pentagon;
import graphiceditor.objects.Rectangle;

public class BackwardVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        circle.setX(circle.getX() + 4);
    }

    @Override
    public void visitPentagon(Pentagon pentagon) {
        pentagon.setX(pentagon.getX() - 4);
        pentagon.setY(pentagon.getY() - 4);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        rectangle.setY(rectangle.getY() + 4);
    }
}
