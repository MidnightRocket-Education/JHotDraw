package org.jhotdraw.gui.fontchooser.listenernodes;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class NodesChangedInserted implements TreeModelListener {
    private final TreeModelListener handler;

    public NodesChangedInserted(TreeModelListener handler) {
        this.handler = handler;
    }

    @Override
    public void treeNodesChanged(TreeModelEvent e) {
        handler.treeNodesChanged(e);
    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {
        handler.treeNodesInserted(e);
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {
        handler.treeNodesRemoved(e);
    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {
        handler.treeStructureChanged(e);
    }
}
