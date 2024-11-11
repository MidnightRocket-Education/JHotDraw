package org.jhotdraw.gui.fontchooser;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.EventListener;

public abstract class ExperimentFontChooserModel implements FontChooserModel{
    protected EventListenerList eventListenerList = new EventListenerList();

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        eventListenerList.add(TreeModelListener.class, l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        eventListenerList.remove(TreeModelListener.class, l);
    }

    public TreeModelListener[] getTreeModelListeners() {
        return eventListenerList.getListeners(TreeModelListener.class);
    }

    public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
        return eventListenerList.getListeners(listenerType);
    }

    private enum EventType {
        nodesChanged, nodesInserted, nodesRemoved, changeStructure, treeStructure
    }

    private void notifyListeners(TreeModelEvent e, EventType eventType) {
        for (TreeModelListener l : getTreeModelListeners()) {
            switch (eventType) {
                case nodesInserted:
                    l.treeNodesChanged(e);
                    break;
                case nodesRemoved:
                    l.treeNodesRemoved(e);
                    break;
                case nodesChanged:
                    l.treeNodesChanged(e);
                    break;
                case changeStructure:
                    l.treeStructureChanged(e);
                    break;
            }
        }
    }

    protected void fireTreeNodesInserted(Object source, Object[] path, int[] childIndices, Object[] children){
        notifyListeners(new TreeModelEvent(source, path, childIndices, children), EventType.nodesInserted);
    }

    protected void fireTreeNodesRemoved(Object source, Object[] path, int[] childIndices, Object[] children){
        notifyListeners(new TreeModelEvent(source, path, childIndices, children), EventType.nodesRemoved);
    }

    protected void fireTreeNodesChanged(Object source, Object[] path, int[] childIndices, Object[] children){
        notifyListeners(new TreeModelEvent(source, path, childIndices, children), EventType.nodesChanged);
    }

    protected void fireTreeStructureChanged(Object source, Object[] path, int[] childIndices, Object[] children){
        notifyListeners(new TreeModelEvent(source, path, childIndices, children), EventType.changeStructure);
    }

    protected void fireTreeStructure(Object source, TreePath path){
        notifyListeners(new TreeModelEvent(source, path), EventType.treeStructure);
    }

}
