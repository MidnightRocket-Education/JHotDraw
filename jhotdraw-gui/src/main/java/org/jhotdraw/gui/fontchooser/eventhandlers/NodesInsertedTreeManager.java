package org.jhotdraw.gui.fontchooser.eventhandlers;

import javax.swing.event.TreeModelEvent;

public class NodesInsertedTreeManager implements TreeEventNotifier{
    @Override
    public void treeevent(TreeModelEvent event) {
        try{
            System.out.println("NodeInsertedTreeManager worked: " + event);
        }catch (Exception e){
            System.out.println("NodeInsertedTreeManager has NOT worked: " + event);
        }
    }
}
