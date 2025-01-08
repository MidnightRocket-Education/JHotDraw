package org.jhotdraw.gui.fontchooser.BDDFonts;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.gui.JFontChooser;

import javax.swing.*;

/**
 * This class defines then Given Font, where it defines the label and textArea where the font-chooser
 * can apply fonts to it.
 * @link https://jgiven.org/userguide/
 * The inspiration for creating this class has been taken from 5.7 State Sharing, from the link.
 */
public class GivenFont extends Stage<GivenFont> {
    @ProvidedScenarioState
    JLabel label;

    @ProvidedScenarioState
    JTextArea textArea;

    @ProvidedScenarioState
    JFontChooser fontChooser;

    public void having_a_writingframe(JLabel label, JTextArea textArea, JFontChooser fontChooser) {
        this.label = label;
        this.textArea = textArea;
        this.fontChooser = fontChooser;
        self();
    }
}
