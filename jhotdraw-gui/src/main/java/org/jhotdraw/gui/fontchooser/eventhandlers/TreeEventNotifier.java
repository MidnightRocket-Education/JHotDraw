package org.jhotdraw.gui.fontchooser.eventhandlers;

import javax.swing.event.TreeModelEvent;

public interface TreeEventNotifier {
    /**
     * This class is an interface that notifies changes to object in child classes.
     * @param event This triggers change of event in tree model to notify tree model.
     */
    public void treeevent(TreeModelEvent event);


}
