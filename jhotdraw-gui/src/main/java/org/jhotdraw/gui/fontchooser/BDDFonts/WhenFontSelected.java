package org.jhotdraw.gui.fontchooser.BDDFonts;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.gui.JFontChooser;

import java.awt.*;

/**
 * This class defines when the font is selected by the user.
 * @link https://jgiven.org/userguide/
 * The inspiration for creating this class has been taken from 5.7 State Sharing, from the link.
 */
public class WhenFontSelected extends Stage<WhenFontSelected> {

    @ProvidedScenarioState
    JFontChooser fontChooser;

    public void selectedFont(String mockFontName) {
        this.fontChooser.setSelectedFont(new Font(mockFontName, Font.PLAIN, 12));
        self();
    }
}
