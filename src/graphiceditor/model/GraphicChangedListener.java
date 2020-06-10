package graphiceditor.model;

import java.util.EventListener;

/**
 * Listener interface for changes in the graphical model.
 */
public interface GraphicChangedListener extends EventListener {

    /**
     * Signals a change event in the model.
     *
     * @param e the event object for the change event
     */
    void graphicChanged(GraphicChangedEvent e);

}
