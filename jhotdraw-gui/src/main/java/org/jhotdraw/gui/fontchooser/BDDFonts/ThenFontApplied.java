package org.jhotdraw.gui.fontchooser.BDDFonts;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.gui.JFontChooser;

import javax.swing.*;
import java.awt.*;

import static org.testng.AssertJUnit.assertEquals;

/**
 * This class defines when the font is applied to the text, and whether there is difference.
 * @link https://jgiven.org/userguide/
 * The inspiration for creating this class has been taken from 5.7 State Sharing, from the link.
 *
 */
public class ThenFontApplied extends Stage<ThenFontApplied> {

    @ProvidedScenarioState
    Font mockFont = new Font("Times New Roman",Font.BOLD,12);

    @ProvidedScenarioState
    JTextArea textArea;

    @ProvidedScenarioState
    JFontChooser fontChooser;

    public void font_is_applied(String mockFontName) {
        mockFont = fontChooser.getSelectedFont();
        textArea.setFont(mockFont);
        assertEquals(textArea.getFont().getName(), mockFont);
        self();
    }
}
