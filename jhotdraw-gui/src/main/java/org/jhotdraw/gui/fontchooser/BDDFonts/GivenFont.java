package org.jhotdraw.gui.fontchooser.BDDFonts;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.gui.JFontChooser;

import javax.swing.*;

public class GivenFont extends Stage<GivenFont> {
    @ProvidedScenarioState
    JLabel label;

    @ProvidedScenarioState
    JTextArea textArea;

    @ProvidedScenarioState
    JFontChooser fontChooser;

    public GivenFont having_a_writingframe(JLabel label, JTextArea textArea, JFontChooser fontChooser) {
        this.label = label;
        this.textArea = textArea;
        this.fontChooser = fontChooser;
        return self();
    }
}
