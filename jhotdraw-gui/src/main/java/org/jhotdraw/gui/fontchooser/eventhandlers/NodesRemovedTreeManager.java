package org.jhotdraw.gui.fontchooser.eventhandlers;

import javax.swing.event.TreeModelEvent;

public class NodesRemovedTreeManager implements TreeEventNotifier{
    @Override
    public void treeevent(TreeModelEvent event) {
        try{
            System.out.println("NodeRemovedTreeManager worked: " + event);
        }catch (Exception e){
            System.out.println("NodeRemovedTreeManager has NOT worked: " + event);
        }
    }
}
