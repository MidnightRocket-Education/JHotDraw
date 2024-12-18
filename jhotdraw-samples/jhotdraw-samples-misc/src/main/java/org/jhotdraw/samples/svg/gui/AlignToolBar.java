/*
 * @(#)AlignToolBar.java
 *
 * Copyright (c) 2007-2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.event.SelectionComponentDisplayer;
import org.jhotdraw.util.*;

/**
 * AlignToolBar.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class AlignToolBar extends AbstractToolBar {

    private static final long serialVersionUID = 1L;
    private transient SelectionComponentDisplayer displayer;

    /**
     * Creates new instance.
     */
    public AlignToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
            displayer.setMinSelectionCount(2);
            displayer.setVisibleIfCreationTool(false);
        }
    }

    private static class AlignActionButtonData {
        final AbstractSelectedAction action;
        final int gridx;
        final int gridy;
        final Insets insets;

        AlignActionButtonData(AbstractSelectedAction action, int gridx, int gridy, Insets insets) {
            this.action = action;
            this.gridx = gridx;
            this.gridy = gridy;
            this.insets = insets;
        }
    }

    @Override
    protected JComponent createDisclosedComponent(int state) {
        JPanel panel = null;
        if (state == 1) return panel;
        // Define the panel
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(5, 5, 5, 8));
        // Abort if no editor is set
        if (editor == null) return panel;

        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        GridBagConstraints gbc;
        gbc = new GridBagConstraints();

        // list of align actions and their grid positions
        List<AlignActionButtonData> alignButtonsData = new ArrayList<>();
        alignButtonsData.add(new AlignActionButtonData(new AlignAction.West(editor, labels), 0, 0, new Insets(0, 0, 0, 0)));
        alignButtonsData.add(new AlignActionButtonData(new AlignAction.East(editor, labels), 1, 0, new Insets(0, 3, 0, 0)));
        alignButtonsData.add(new AlignActionButtonData(new AlignAction.North(editor, labels), 0, 1, new Insets(3, 0, 0, 0)));
        alignButtonsData.add(new AlignActionButtonData(new AlignAction.South(editor, labels), 1, 1, new Insets(3, 3, 0, 0)));
        alignButtonsData.add(new AlignActionButtonData(new AlignAction.Horizontal(editor, labels), 0, 2, new Insets(3, 0, 0, 0)));
        alignButtonsData.add(new AlignActionButtonData(new AlignAction.Vertical(editor, labels), 1, 2, new Insets(3, 3, 0, 0)));

        // add an align button for each align action
        for (AlignActionButtonData alignButtonData : alignButtonsData) {
            addAlignActionButton(panel, gbc, alignButtonData);
        }
        return panel;
    }

    private void addAlignActionButton(JPanel panel, GridBagConstraints gbc, AlignActionButtonData alignButtonData) {
        // Grid
        gbc.gridx = alignButtonData.gridx;
        gbc.gridy = alignButtonData.gridy;
        gbc.insets = alignButtonData.insets;
        // Button
        AbstractButton btn = new JButton(alignButtonData.action);
        disposables.add(alignButtonData.action);

        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("hideActionText", Boolean.TRUE);
        btn.setText(null);
        // Add grid and button to panel
        panel.add(btn, gbc);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected String getID() {
        return "align";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
