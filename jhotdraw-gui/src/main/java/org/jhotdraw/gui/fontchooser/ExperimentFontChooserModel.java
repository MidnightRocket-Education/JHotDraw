package org.jhotdraw.gui.fontchooser;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.EventListener;

public abstract class ExperimentFontChooserModel implements FontChooserModel{
    protected EventListenerList eventListenerList = new EventListenerList();

    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) {
        eventListenerList.add(TreeModelListener.class, treeModelListener);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {
        eventListenerList.remove(TreeModelListener.class, treeModelListener);
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
//        for (TreeModelListener listeners : getTreeModelListeners()) {
//            switch (eventType) {
//                case nodesInserted:
//                    listeners.treeNodesChanged(e);
//                    break;
//                case nodesRemoved:
//                    listeners.treeNodesRemoved(e);
//                    break;
//                case nodesChanged:
//                    listeners.treeNodesChanged(e);
//                    break;
//                case changeStructure:
//                    listeners.treeStructureChanged(e);
//                    break;
//            }
//        }
//    }
//

    protected void fireTreeEventManager(Object source, Object[] path, int[] childIndices, Object[] children, eventListenerTypes eventListenerTypes){
        notifyListeners(source, path, childIndices, children);
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
