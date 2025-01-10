package org.jhotdraw.draw.action;

import junit.framework.TestCase;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;

public class AlignActionTest extends TestCase {

    private DefaultDrawingView drawingView;
    private DrawingEditor drawingEditor;
    private Collection<Figure> figures;
    private AlignAction alignAction;
    private Rectangle2D.Double selectionBounds;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        drawingView = new DefaultDrawingView();
        drawingEditor = new DefaultDrawingEditor();
        figures = new ArrayList<>();
        figures.add(new RectangleFigure(35, 40, 5, 5));
        figures.add(new RectangleFigure(120, 204, 5, 5));

        drawingView.setDrawing(new DefaultDrawing());
        drawingView.getDrawing().addAll(figures);
        drawingEditor.add(drawingView);
    }

    @Test
    public void testAlignFiguresNorth() {
        // Setup align action
        alignAction = new AlignAction.North(drawingEditor);
        alignAction.getView().addToSelection(figures);

        // Perform method
        selectionBounds = alignAction.getSelectionBounds();
        alignAction.alignFigures(figures, selectionBounds);

        // Check changes
        for (Figure figure : figures) {
            assertEquals(figure.getBounds().y, selectionBounds.getY());
        }
    }

    @Test
    public void testAlignFiguresWest() {
        // Setup align action
        alignAction = new AlignAction.West(drawingEditor);
        alignAction.getView().addToSelection(figures);

        // Perform method
        selectionBounds = alignAction.getSelectionBounds();
        alignAction.alignFigures(figures, selectionBounds);

        // Check changes
        for (Figure figure : figures) {
            assertEquals(figure.getBounds().x, selectionBounds.getX());
        }
    }

    // Boundary test
    @Test
    public void testAlingFiguresWithSingleFigure() {
        // Setup
        drawingView = new DefaultDrawingView();
        drawingEditor = new DefaultDrawingEditor();
        figures = new ArrayList<>();
        figures.add(new RectangleFigure(35, 40, 5, 5));


        drawingView.setDrawing(new DefaultDrawing());
        drawingView.getDrawing().addAll(figures);
        drawingEditor.add(drawingView);

        alignAction = new AlignAction.North(drawingEditor);
        alignAction.getView().addToSelection(figures);

        // Perform method
        selectionBounds = alignAction.getSelectionBounds();
        alignAction.alignFigures(figures, selectionBounds);

        // Check
        for (Figure figure : figures) {
            assertEquals(figure.getBounds().y, 40.0);
            assertEquals(figure.getBounds().x, 35.0);
        }
    }
}