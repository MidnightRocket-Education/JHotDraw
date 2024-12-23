package org.jhotdraw.gui.fontchooser.BDDFonts;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.gui.JFontChooser;

import javax.swing.*;
import java.awt.*;

public class WhenFontSelected extends Stage<WhenFontSelected> {

    @ProvidedScenarioState
    JFontChooser fontChooser;

    public WhenFontSelected selectedFont(String mockFontName) {
        this.fontChooser.setSelectedFont(new Font(mockFontName, Font.PLAIN, 12));
        return self();
    }
}
