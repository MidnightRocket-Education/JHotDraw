package org.jhotdraw.gui.fontchooser;

import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class ExperimentDefaultChooserModel extends ExperimentFontChooserModel {
    protected DefaultMutableTreeNode root;

    public void DefaultFontChooserModel(){
        root = new DefaultMutableTreeNode();
    }

    protected ArrayList<FontFamilyNode> collectFamiliesNamed(ArrayList<FontFamilyNode> families, String... names){
        ArrayList<FontFamilyNode> collection = new ArrayList<>();
        HashSet<String> nameSet = new HashSet<>();
        nameSet.addAll(Arrays.asList(names));
        for (FontFamilyNode family : families){
            String fName = family.getName();
            if(nameSet.contains(family.getName())){
                collection.add(family.clone());
            }
        }
        return collection;
    }

    public void setFonts(Font[] fonts){
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.gui.Labels");
        ArrayList<FontFamilyNode> families = new ArrayList<>();
        HashMap<String, FontFamilyNode> familyMap = new HashMap<>();
        for (Font f : fonts) {
            String familyName = f.getFamily();
            FontFamilyNode family;
            if (familyMap.containsKey(familyName)) {
                family = familyMap.get(familyName);
            } else {
                family = new FontFamilyNode(familyName);
                familyMap.put(familyName, family);
            }
            family.add(new FontFaceNode(f));
        }
        families.addAll(familyMap.values());
        Collections.sort(families);
        root.removeAllChildren();
        root.add(new FontCollectionNode(labels.getString("FontCollection.allFonts"), (ArrayList<FontFamilyNode>) families.clone()));
        root.add(new FontCollectionNode(labels.getString("FontCollection.web"), collectFamiliesNamed(families,
                "Arial", "Arial Black", "Comic Sans MS", "Georgia", "Impact", "Times New Roman", "Trebuchet MS", "Verdana", "Webdings")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.system"), collectFamiliesNamed(families,
                "Dialog","DialogInput","Monospaced","SansSerif","Serif")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.serif"), collectFamiliesNamed(families,
                "Times New Roman","Rockwell","Cambria","Georgia","Garamond")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.sanSerif"), collectFamiliesNamed(families,
                "Helvetica Neue","Lucida Sans","Trebuchet MS")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.script"),collectFamiliesNamed(families,
                "Lithos Pro", "Marker Felt","Blackadder ITC","Chiller","Informal Roman")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.monospaced"),collectFamiliesNamed(families,
                "Lucida Console", "Rod", "Consolas", "Menlo", "Monaco")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.decorative"),collectFamiliesNamed(families,
                "Colonna MT", "Cooper Std", "Didot", "Eurostile","Hobo Std")));
        root.add(new FontCollectionNode(labels.getString("FontCollection.symbols"),collectFamiliesNamed(families,
                "Apple Symbols", "Symbol", "Webdings", "Wingdings", "Bookshelf Symbol")));
    }

    @Override
    public boolean isEditable(MutableTreeNode node){
        boolean result = true;
        if (node instanceof FontFamilyNode){
            result &= ((FontFamilyNode) node).isEditable();
            node = (MutableTreeNode) node.getParent();
        }
        if (node instanceof DefaultMutableTreeNode){
            result &= ((FontFamilyNode) node).isEditable();
            node = (MutableTreeNode) node.getParent();
        }
        if (result && (node instanceof DefaultMutableTreeNode)){
            result &= ((FontCollectionNode) node).isEditable();
        }
        return result;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        return ((TreeNode) parent).getChildAt(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((TreeNode) parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((TreeNode) node).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((TreeNode) parent).getIndex((TreeNode) child);
    }
}
