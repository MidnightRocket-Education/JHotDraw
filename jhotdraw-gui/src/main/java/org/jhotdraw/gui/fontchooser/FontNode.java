package org.jhotdraw.gui.fontchooser;

import java.awt.Font;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

abstract class FontNode implements MutableTreeNode, Comparable<FontNode> {
    protected MutableTreeNode parent;
    protected String name;

    public FontNode(String name){
        this.name = name;
    }

    @Override
    public int compareTo(FontNode other){
        return Collator.getInstance().compare(this.name, other.name);
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void setParent(MutableTreeNode newParent){
        this.parent = newParent;
    }

    @Override
    public MutableTreeNode getParent(){
        return parent;
    }

    @Override
    public void setUserObject(Object object){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
