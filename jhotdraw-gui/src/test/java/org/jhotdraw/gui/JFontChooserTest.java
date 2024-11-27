package org.jhotdraw.gui;

import org.jhotdraw.gui.fontchooser.ExperimentDefaultChooserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class JFontChooserTest {
    JFontChooser fontChooser;
    ExperimentDefaultChooserModel defaultChooserModel;

    @Before
    public void setUp() throws Exception {
        fontChooser = new JFontChooser();
        defaultChooserModel = new ExperimentDefaultChooserModel();
        System.out.println("Setup is executed");
    }

    @Test
    public void test_if_font_selection() {
        Font fontSelection = fontChooser.getSelectedFont();
        if(fontSelection == null){
            fontChooser.setSelectedFont(null);
        } else if (fontSelection != null){
            fontChooser.setSelectedFont(Font.getFont(fontSelection.getName()));
        }
    }

    @Test
    public void test_if_font_are_same(){
        Font oldvalue = fontChooser.getFont();
        Font newvalue = fontChooser.getFont();
        if(oldvalue.equals(newvalue)){
            assertEquals("These are the same fonts", oldvalue.getFontName(), newvalue.getFontName());
        }else {
            assertNotEquals("These are two different fonts", oldvalue.getFontName(), newvalue.getFontName());
        }
    }

}