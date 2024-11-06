/**
 * @(#)FontChooserHandler.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.gui.action;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPopupMenu;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.TextHolderFigure;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.gui.JFontChooser;

/**
 * FontChooserHandler.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class FontChooserHandler extends AbstractSelectedAction
        implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    protected AttributeKey<Font> fontAttributeKey;
    protected JFontChooser fontChooser;
    protected JPopupMenu popupMenu;
    protected int isUpdating;

    //protected Map<AttributeKey, Object> attributes;
    /**
     * Creates a new instance.
     */
    public FontChooserHandler(DrawingEditor editor, AttributeKey<Font> fontAttributeKey, JFontChooser fontChooser, JPopupMenu popupMenu) {
        super(editor);
        this.fontAttributeKey = fontAttributeKey;
        this.fontChooser = fontChooser;
        this.popupMenu = popupMenu;
        fontChooser.addActionListener(this);
        fontChooser.addPropertyChangeListener(this);
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        String selectionEvent = evt.getActionCommand();
        if (selectionEvent != null && selectionEvent.equals(JFontChooser.APPROVE_SELECTION)) {
            applySelectedFontToFigures();
        }
        popupMenu.setVisible(false);
    }

    protected void applySelectedFontToFigures() {
        final ArrayList<Figure> selectedFigures = new ArrayList<>(getView().getSelectedFigures());
        final ArrayList<Object> figureRestoreData = new ArrayList<>(selectedFigures.size());
        for (Figure figure : selectedFigures) {
            figureRestoreData.add(figure.getAttributesRestoreData());
            figure.willChange();
            figure.set(fontAttributeKey, fontChooser.getSelectedFont());
            figure.changed();
        }
        getEditor().setDefaultAttribute(fontAttributeKey, fontChooser.getSelectedFont());
        final Font undoValue = fontChooser.getSelectedFont();
        UndoableEdit edit = new AbstractUndoableEdit() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getPresentationName() {
                return AttributeKeys.FONT_FACE.getPresentationName();
                /*
            String name = (String) getValue(Actions.UNDO_PRESENTATION_NAME_KEY);
            if (name == null) {
            name = (String) getValue(AbstractAction.NAME);
            }
            if (name == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            name = labels.getString("attribute.text");
            }
            return name;*/
            }

            @Override
            public void undo() {
                super.undo();
                Iterator<Object> iRestore = figureRestoreData.iterator();
                for (Figure figure : selectedFigures) {
                    figure.willChange();
                    figure.restoreAttributesTo(iRestore.next());
                    figure.changed();
                }
            }

            @Override
            public void redo() {
                super.redo();
                for (Figure figure : selectedFigures) {
                    //figureRestoreData.add(figure.getAttributesRestoreData());
                    figure.willChange();
                    figure.set(fontAttributeKey, undoValue);
                    figure.changed();
                }
            }
        };
        fireUndoableEditHappened(edit);
    }

    @Override
    protected void updateEnabledState() {
        setEnabled(getEditor().isEnabled());
        if (getView() != null && fontChooser != null && popupMenu != null) {
            fontChooser.setEnabled(getView().getSelectionCount() > 0);
            popupMenu.setEnabled(getView().getSelectionCount() > 0);
            isUpdating++;
            if (getView().getSelectionCount() > 0 /*&& fontChooser.isShowing()*/) {
                for (Figure f : getView().getSelectedFigures()) {
                    if (f instanceof TextHolderFigure) {
                        TextHolderFigure textHolderFigure = (TextHolderFigure) f;
                        fontChooser.setSelectedFont(textHolderFigure.getFont());
                        break;
                    }
                }
            }
            isUpdating--;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String selectionEvent = evt.getPropertyName();
        if (isUpdating++ == 0){
            if (selectionEvent != null && selectionEvent.equals(JFontChooser.SELECTED_FONT_PROPERTY)) {
                applySelectedFontToFigures();
            }
        }else{
            isUpdating--;
        }
    }
}