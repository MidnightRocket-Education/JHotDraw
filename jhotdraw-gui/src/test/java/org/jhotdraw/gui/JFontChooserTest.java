package org.jhotdraw.gui;

import org.jhotdraw.gui.fontchooser.ExperimentDefaultChooserModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class JFontChooserTest {
    JFontChooser fontChooser;
    JLabel label;
    Font font;
    ExperimentDefaultChooserModel defaultChooserModel;

    @BeforeEach
    public void setUp() throws Exception {
        fontChooser = new JFontChooser();
        defaultChooserModel = new ExperimentDefaultChooserModel();
        fontChooser.setModel(defaultChooserModel);
        System.out.println("Setup is executed");
    }

    @BeforeAll
    public static void checkSetup() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    @Test
    public void test_if_font_selection() {
        Font fontSelection = fontChooser.getSelectedFont();
        if(fontSelection == null){
            fontChooser.setSelectedFont(null);
        } else {
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

    @Test
    public void test_if_fontselection_applied(){
        JLabel mockLabel = new JLabel("Hello World to MockLabel");
        Font mockFont = new Font("Times New Roman", Font.BOLD, 12);
        fontChooser.setSelectedFont(mockFont);
        if (fontChooser.getSelectedFont() != null){
            Font implementedFont = fontChooser.getSelectedFont();
            mockLabel.setFont(implementedFont);
            assertEquals("The Font is now applied to the label", mockFont.equals(mockLabel.getFont()));
        } else if ( fontChooser.getSelectedFont() == null) {
            assertNotEquals("The Font is not applied to the label", mockFont.equals(mockLabel.getFont()));
        }
    }

    @Test
    public void test_fontselection_in_display() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(fontChooser);
                frame.pack();
                frame.setVisible(true);
                assertNotNull(fontChooser);
            }
        });
    }

}
