package graphiceditor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import graphiceditor.objects.GraphicObject;
import graphiceditor.visitors.Visitor;

/**
 * Model class for graphical editor application.
 */
public final class GraphicModel {

    private final List<GraphicObject> list = new ArrayList<GraphicObject>();
    private final List<GraphicChangedListener> listeners = new ArrayList<GraphicChangedListener>();

    /**
     * Gets the list of graphical objects.
     *
     * @return the graphical objects
     */
    public List<GraphicObject> getGraphicObjects() {
        return Collections.unmodifiableList(list);
    }

    /**
     * Adds a graphical object to the model.
     *
     * @param newObject the new graphical object
     */
    public void add(GraphicObject newObject) {
        list.add(newObject);
        fireGraphicChangedEvent();
    }

    /**
     * Adds a listener to this model.
     *
     * @param l the listener to add
     */
    public void addGraphicChangedListener(GraphicChangedListener l) {
        listeners.add(l);
    }

    /**
     * Removes a listener from this model.
     *
     * @param l the listener to remove
     */
    public void removeGraphicChangedListener(GraphicChangedListener l) {
        listeners.remove(l);
    }

    /**
     * Fires a change event.
     */
    private void fireGraphicChangedEvent() {
        GraphicChangedEvent e = new GraphicChangedEvent(this,
                list.toArray(new GraphicObject[0]));
        for (GraphicChangedListener l : listeners) {
            l.graphicChanged(e);
        }
    }

    public void accept(Visitor visitor) {
        for (GraphicObject object : list) {
            object.accept(visitor);
        }
        fireGraphicChangedEvent();
    }
}
