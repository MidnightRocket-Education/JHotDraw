package org.jhotdraw.gui.fontchooser;

import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.*;

import static org.junit.Assert.*;

public class ExperimentDefaultChooserModelTest {

    ExperimentDefaultChooserModel defaultChooserModel;
    DefaultMutableTreeNode root;

    @Before
    public void setUp() throws Exception {
        defaultChooserModel = new ExperimentDefaultChooserModel();
        root = new DefaultMutableTreeNode("root");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void collectFamiliesNamed() {

    }

    @Test
    public void setFonts() {

    }



}