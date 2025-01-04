/*
 * @(#)StrokeToolBar.java
 *
 * Copyright (c) 2007-2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.gui.action.ButtonFactory;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.gui.plaf.palette.PaletteColorChooserUI;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.SliderUI;
import javax.swing.text.DefaultFormatterFactory;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.event.FigureAttributeEditorHandler;
import org.jhotdraw.draw.event.SelectionComponentDisplayer;
import org.jhotdraw.draw.event.SelectionComponentRepainter;
import org.jhotdraw.draw.gui.JAttributeSlider;
import org.jhotdraw.draw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.text.ColorFormatter;
import org.jhotdraw.formatter.JavaNumberFormatter;
import org.jhotdraw.util.*;

public class StrokeToolBarSlider {


    public StrokeToolBarSlider() {

    }

    @Override
    public void createStrokeJointSlider(editor, labels, disposables) {
        JAttributeTextField<Double> strokeWidthField = new JAttributeTextField<Double>();
        strokeWidthField.setColumns(2);
        strokeWidthField.setToolTipText(labels.getString("attribute.strokeWidth.toolTipText"));
        strokeWidthField.setHorizontalAlignment(JAttributeTextField.LEFT);
        strokeWidthField.putClientProperty(PALETTE_COMPONENT + ".segmentPosition", "first");
        strokeWidthField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(strokeWidthField));
    }
}
