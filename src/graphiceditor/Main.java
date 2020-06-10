package graphiceditor;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import graphiceditor.model.GraphicModel;
import graphiceditor.objects.Circle;
import graphiceditor.objects.GraphicObject;
import graphiceditor.objects.Pentagon;
import graphiceditor.objects.Rectangle;
import graphiceditor.view.GraphicFrame;

/**
 * Main class for starting the application.
 */
public class Main {

    public static void main(final String[] args) throws IOException {

        final GraphicModel model = new GraphicModel();

        final ArrayList<GraphicObject> prototypes = new ArrayList<>();

        prototypes.add(new Circle(0, 0, 20));
        prototypes.add(new Rectangle(0, 0, 40, 40));
        prototypes.add(new Pentagon(0, 0, 20));

        final JFrame frame = new GraphicFrame(model, prototypes);
        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
        });
    }
}
