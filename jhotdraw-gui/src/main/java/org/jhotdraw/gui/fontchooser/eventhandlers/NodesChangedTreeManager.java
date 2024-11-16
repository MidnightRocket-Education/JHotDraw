package org.jhotdraw.gui.fontchooser.eventhandlers;

import javax.swing.event.TreeModelEvent;

public class NodesChangedTreeManager implements TreeEventNotifier{
    @Override
    public void treeevent(TreeModelEvent event) {
        try{
            System.out.println("NodeChangedTreeManager worked: " + event);
        }catch (Exception e){
            System.out.println("NodeChangedTreeManager has NOT worked: " + event);
        }
    }
}
