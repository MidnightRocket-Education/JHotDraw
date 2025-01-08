package org.jhotdraw.gui.fontchooser.eventhandlers;

import javax.swing.event.TreeModelEvent;

public class NodesRemovedTreeManager implements TreeEventNotifier{
    /**
     * This class notifies the removal in tree structure.
     * @param event This triggers change of event in tree model to notify tree model.
     */
    @Override
    public void treeevent(TreeModelEvent event) {
        try{
            System.out.println("NodeRemovedTreeManager worked: " + event);
        }catch (Exception e){
            System.out.println("NodeRemovedTreeManager has NOT worked: " + event);
        }
    }
}
