package org.jhotdraw.gui.fontchooser.listenernodes;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class NodesChangedRemoved implements TreeModelListener {
    private final TreeModelListener eventHandlerListener;

    public NodesChangedRemoved(TreeModelListener eventHandlerListener) {
        this.eventHandlerListener = eventHandlerListener;
    }
    @Override
    public void treeNodesChanged(TreeModelEvent e) {
        eventHandlerListener.treeNodesChanged(e);
    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {
        eventHandlerListener.treeNodesInserted(e);
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {
        eventHandlerListener.treeNodesRemoved(e);
    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {
        eventHandlerListener.treeStructureChanged(e);
    }
}
