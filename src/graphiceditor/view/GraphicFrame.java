package graphiceditor.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import graphiceditor.Main;
import graphiceditor.decorators.FrameDecorator;
import graphiceditor.decorators.NumberDecorator;
import graphiceditor.model.GraphicModel;
import graphiceditor.objects.*;
import graphiceditor.visitors.BackwardVisitor;
import graphiceditor.visitors.ForwardVisitor;

/**
 * Frame class for the graphical objects.
 */
public class GraphicFrame extends JFrame {

    private static final long serialVersionUID = -2329212433155597042L;
    private final GraphicModel model;
    private final GraphicView view;
    private GraphicObject selectedPrototype;

    /**
     * Constructs the frame with the model.
     *
     * @param model the graphical model
     */
    public GraphicFrame(GraphicModel model, ArrayList<GraphicObject> prototypes) {
        super("Graphic Editor");

        this.model = model;

        this.getContentPane().setLayout(new BorderLayout());
        view = new GraphicView();
        this.getContentPane().add(view, BorderLayout.CENTER);
        view.setBackground(Color.WHITE);

        final JToolBar toolBar = new JToolBar();
        this.getContentPane().add(toolBar, BorderLayout.PAGE_START);
        final ButtonGroup buttons = new ButtonGroup();

        for (GraphicObject prototype : prototypes) {
            JToggleButton button = new JToggleButton(prototype.toString());
            button.addActionListener(l -> selectedPrototype = prototype);
            buttons.add(button);
            toolBar.add(button);
        }
    }

    /**
     * Generates a random color
     *
     * @return a randomly generated color
     */
    private static Color getRandomColor() {
        int x = (int) (Math.random() * Integer.MAX_VALUE);
        return new Color(x, false);
    }

    /**
     * The view class for drawing the graphical objects.
     */
    @SuppressWarnings("serial")
    private class GraphicView extends JComponent {

        /**
         * Constructor for the graphical view.
         * Adds listener for mouse events and key events and a
         * listener to the model for repainting the view upon model changes.
         */
        public GraphicView() {
            super();
            setPreferredSize(new Dimension(600, 400));

            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    requestFocusInWindow();

                    int x = e.getX();
                    int y = e.getY();
                    GraphicObject graphicObject;


                    if (selectedPrototype == null) {
                        return;
                    }

                    graphicObject = selectedPrototype.copy(x, y);
                    graphicObject = new NumberDecorator(graphicObject);

                    if (e.isControlDown()) graphicObject = new FrameDecorator(graphicObject);

                    graphicObject.setColor(getRandomColor());

                    model.add(graphicObject);
                }
            });


            this.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                        model.accept(new ForwardVisitor());

                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                        model.accept(new BackwardVisitor());

                    }
                }

            });

            model.addGraphicChangedListener(ce -> repaint());

        }

        /**
         * Paints the graphical object of the model.
         *
         * @param g the graphics context
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            for (GraphicObject o : model.getGraphicObjects()) {
                g.setColor(o.getColor());
                o.paint(g);
            }
        }

    }

}
