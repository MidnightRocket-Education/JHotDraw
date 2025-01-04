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

public class StrokeToolBarButtons {


    public StrokeToolBarButtons() {

    }

    @Override
    public void createStrokeJointButton(editor, labels, disposables) {
        btn = ButtonFactory.createStrokeJoinButton(editor, labels, disposables);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 3, 0, 0);
        p.add(btn, gbc);
    }

    @Override
    public void createStroke(editor, labels, disposables) {
        btn = ButtonFactory.createStrokeCapButton(editor, labels, disposables);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 1;
        gbc.insets = new Insets(3, 3, 0, 0);
        p.add(btn, gbc);
    }

    @Override
    public void createStrokeCapButton(editor, labels, disposables) {
        btn = ButtonFactory.createStrokeDashesButton(editor, new double[][]{
                null,
                {4d, 4d},
                {2d, 2d},
                {4d, 2d},
                {2d, 4d},
                {8d, 2d},
                {6d, 2d, 2d, 2d}}, labels, disposables);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 3, 0, 0);
        p.add(btn, gbc);
    }

}
