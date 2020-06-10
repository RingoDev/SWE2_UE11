package graphiceditor.visitors;

import graphiceditor.objects.*;

public interface Visitor {

    void visitCircle(Circle circle);

    void visitPentagon(Pentagon pentagon);

    void visitRectangle(Rectangle rectangle);
}
