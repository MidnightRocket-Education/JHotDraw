/**
 * @(#)FontCollectionNode.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.gui.fontchooser;

import java.text.Collator;
import java.util.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * A FontCollectionNode is a MutableTreeNode which only allows FontFamilyNode
 * as child nodes.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class FontCollectionNode extends FontNode {
    private final List<FontFamilyNode> children;
    private boolean isEditable;

    public FontCollectionNode(List<FontFamilyNode> children) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void add(FontFamilyNode child) {
        insert(child, getChildCount);
    }

    @Override
    public void insert(MutableTreeNode child, int index){
        if(!(child instanceof FontFamilyNode)){
            throw new IllegalArgumentException("Only FontFamilyNode allowed as children");
        }
        child.setParent(this);
        children.add(index, (FontFamilyNode) child);
    }

    @Override
    public void remove(int index){
        FontFamilyNode child = children.remove(index);
        child.setParent(null);
    }

    @Override
    public void remove(MutableTreeNode node) {

    }

    @Override
    public void removeFromParent() {

    }

    @Override
    public Enumeration<FontFamilyNode> children() {
        return Collections.enumeration(children);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean isLeaf(){
        return children.isEmpty();
    }

    public boolean isEditable(){
        return isEditable;
    }

    public void setEditable(boolean isEditable){
        this.isEditable = isEditable;
    }

}
