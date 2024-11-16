package org.jhotdraw.gui.fontchooser.eventhandlers;

import org.jhotdraw.gui.fontchooser.listenernodes.NodesChangedStructure;

import javax.swing.event.TreeModelEvent;

public class NodesStructureTreeManager implements TreeEventNotifier{
    @Override
    public void treeevent(TreeModelEvent event) {
        try{
            System.out.println("NodeStructureTreeManager worked: " + event);
        }catch (Exception e){
            System.out.println("NodeStructureTreeManager has NOT worked: " + event);
        }
    }
}
