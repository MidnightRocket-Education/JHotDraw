package org.jhotdraw.gui.fontchooser.BDDFonts;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.gui.JFontChooser;

import javax.swing.*;
import java.awt.*;

import static org.testng.AssertJUnit.assertEquals;

public class ThenFontApplied extends Stage<ThenFontApplied> {

    @ProvidedScenarioState
    Font mockFont = new Font("Times New Roman",Font.BOLD,12);

    @ProvidedScenarioState
    JTextArea textArea;

    @ProvidedScenarioState
    JFontChooser fontChooser;

    public ThenFontApplied font_is_applied(String mockFontName) {
        mockFont = fontChooser.getSelectedFont();
        textArea.setFont(mockFont);
        assertEquals(textArea.getFont().getName(), mockFont);
        return self();
    }
}
