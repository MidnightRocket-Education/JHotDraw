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

    private enum eventListenerTypes {
        nodesChanged, nodesInserted, nodesRemoved, changeStructure, treeStructure
    }

    void notifyListeners(Object source, Object[] path, int[] childIndices, Object[] children){
        Object[] listeners = eventListenerList.getListenerList();
        TreeModelEvent event = null;
        for (int i = listeners.length - 2; i>=0; i=-2){
            TreeModelListener listener = (TreeModelListener) listeners[i];
            if(listeners[i] == TreeModelListener.class){
                if(event == null){
                    event = new TreeModelEvent(source, path, childIndices, children);
                }
                listener.notifyAll();
            }
        }
    }

//    private void notifyListeners(TreeModelEvent e, EventType eventType) {
//        for (TreeModelListener l : getTreeModelListeners()) {
//            switch (eventType) {
//                case nodesInserted:
//                    l.treeNodesChanged(e);
//                    break;
//                case nodesRemoved:
//                    l.treeNodesRemoved(e);
//                    break;
//                case nodesChanged:
//                    l.treeNodesChanged(e);
//                    break;
//                case changeStructure:
//                    l.treeStructureChanged(e);
//                    break;
//            }
//        }
//    }
//

    protected void fireTreeEventManager(Object sorce, Object[] path, int[] childIndices, Object[] children, eventListenerTypes eventListenerTypes){
        notifyListeners(sorce, path, childIndices, children);
    }

    protected void fireTreeNodesInserted(Object source, Object[] path, int[] childIndices, Object[] children){
        fireTreeEventManager(source, path, childIndices, children, eventListenerTypes.nodesInserted);
    }

    protected void fireTreeNodesRemoved(Object source, Object[] path, int[] childIndices, Object[] children){
        fireTreeEventManager(source, path, childIndices, children, eventListenerTypes.nodesRemoved);
    }

    protected void fireTreeNodesChanged(Object source, Object[] path, int[] childIndices, Object[] children){
        fireTreeEventManager(source, path, childIndices, children, eventListenerTypes.nodesChanged);
    }

    protected void fireTreeStructureChanged(Object source, Object[] path, int[] childIndices, Object[] children){
        fireTreeEventManager(source, path, childIndices, children, eventListenerTypes.treeStructure);
    }

    protected void fireTreeStructure(Object source, TreePath path){
        fireTreeEventManager(source, new Object[]{path}, null, null, eventListenerTypes.treeStructure);
    }

}
