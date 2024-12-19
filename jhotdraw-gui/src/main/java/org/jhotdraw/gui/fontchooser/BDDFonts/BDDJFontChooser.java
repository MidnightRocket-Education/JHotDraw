package org.jhotdraw.gui.fontchooser.BDDFonts;
import com.tngtech.jgiven.junit.SimpleScenarioTest;
import org.jhotdraw.gui.JFontChooser;
import org.testng.annotations.Test;

import javax.swing.*;

public class BDDJFontChooser extends SimpleScenarioTest<GivenFont, WhenFontSelected, ThenFontApplied>{
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
