package org.jhotdraw.gui.fontchooser.BDDFonts;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.gui.JFontChooser;
import org.testng.annotations.Test;

import javax.swing.*;

public class BDDJFontChooser extends ScenarioTest<GivenFont,WhenFontSelected,ThenFontApplied> {
    /**
     * This is the main class for BDDJFontChooser and defines our scenarios.
     * @link1 https://www.youtube.com/watch?v=x-6bT_0dTWI&t=1118s
     * @link2 https://jgiven.org/userguide/
     * The inspiration for creating the test is taking from the following paragraphs in link1.
     * 3.1 - 3.3 which is the Getting Started Chapter
     * 5.7 which tells about the ProvidedScenario States.
     * The rest has been followed as introductory instructions by Jan Schäfer in link2.
     */

    @Test
    public void bddJFontChooser() {
        GivenFont givenFont = new GivenFont();
        WhenFontSelected whenFontSelected = new WhenFontSelected();
        ThenFontApplied thenFontApplied = new ThenFontApplied();

        givenFont.having_a_writingframe(new JLabel(),new JTextArea(), new JFontChooser());
        whenFontSelected.selectedFont("Times New Roman");
        thenFontApplied.font_is_applied("Times New Roman");
    }

}
