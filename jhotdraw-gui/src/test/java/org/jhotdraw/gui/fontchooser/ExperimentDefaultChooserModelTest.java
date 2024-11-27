package org.jhotdraw.gui.fontchooser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.*;

public class ExperimentDefaultChooserModelTest {
    ExperimentDefaultChooserModel defaultChooserModel;
    DefaultMutableTreeNode root;
    Font font;

    @Before
    public void setUp() throws Exception {
        defaultChooserModel = new ExperimentDefaultChooserModel();
        root = new DefaultMutableTreeNode("root");
        font = Mockito.mock(Font.class);
    }


    @Test
    public void setFontsTest() {
        //Husk, at Font indeholder
        Font firstMockFont = new Font("Times New Roman", Font.PLAIN, 12);
        Font secondMockFont = new Font("Arial", Font.PLAIN, 12);
        Font thirdMockFont = new Font("Georgia", Font.PLAIN, 12);
        Font fourthMockFont = new Font("Helvetica", Font.PLAIN, 12);

        //Skal alle disse mocks samle sig sammen i en normal array som er allFontsLists eller ArrayList som er allFontsLists.allFontsLists.add(firstMockFont);
        Font[] allFontsArray = new Font[]{firstMockFont, secondMockFont, thirdMockFont, fourthMockFont};
        defaultChooserModel.setFonts(allFontsArray);

        String[] experimentFonts = {"Arial", "Times New Roman"};

        ArrayList<String> realFonts = new ArrayList<>();
        for(int i = 0; i < root.getChildCount(); i++) {
            FontCollectionNode child = (FontCollectionNode) root.getChildAt(i);
            for (int j = 0; j < child.getChildCount(); j++) {
                FontFamilyNode family = child.getChildAt(j);
                realFonts.add(family.getName());
            }
        }
        assertTrue(experimentFonts.length, realFonts.size());
        assertTrue(realFonts.contains(experimentFonts[0]));
        assertTrue(realFonts.contains(experimentFonts[1]));

    }



}