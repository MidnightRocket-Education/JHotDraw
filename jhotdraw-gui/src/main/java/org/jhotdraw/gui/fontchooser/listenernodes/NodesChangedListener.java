package org.jhotdraw.gui.fontchooser.listenernodes;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class NodesChangedListener implements TreeModelListener {
    private final TreeModelListener listener;

    public NodesChangedListener(TreeModelListener listener) {
        this.listener = listener;
    }

    @Override
    public void treeNodesChanged(TreeModelEvent e) {
        listener.treeNodesChanged(e);
    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {
        listener.treeNodesInserted(e);
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {
        listener.treeNodesRemoved(e);
    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {
        listener.treeStructureChanged(e);

    }
}
