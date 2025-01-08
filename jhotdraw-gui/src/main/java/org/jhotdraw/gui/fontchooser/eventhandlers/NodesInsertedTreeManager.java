package org.jhotdraw.gui.fontchooser.eventhandlers;

import javax.swing.event.TreeModelEvent;

public class NodesInsertedTreeManager implements TreeEventNotifier{
    /**
     * This class notifies the insertion in tree structure.
     * @param event This triggers change of event in tree model to notify tree model.
     */
    @Override
    public void treeevent(TreeModelEvent event) {
        try{
            System.out.println("NodeInsertedTreeManager worked: " + event);
        }catch (Exception e){
            System.out.println("NodeInsertedTreeManager has NOT worked: " + event);
        }
    }
}
