/**
 * @(#)FontFaceNode.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.gui.fontchooser;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * A FontFaceNode is a MutableTreeNode which does not allow children.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class FontFaceNode extends FontNode implements Cloneable{
    private Font typeface;

    public FontFaceNode(Font typeface) {
        super(FontNameBeautifier.beautify(typeface.getPSName()));
        this.typeface = typeface;
    }

    public Font getFont(){
        return typeface;
    }

    @Override
    public Enumeration<TreeNode> children(){
        return Collections.emptyEnumeration();
    }

    @Override
    public FontFaceNode clone(){
        try{
            FontFaceNode clone = (FontFaceNode) super.clone();
            clone.parent = null;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone failed", e);
        }
    }
}
