package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.junit.Test;

import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BDDScenarioTest extends ScenarioTest<
        BDDScenarioTest.GivenCanvasWithSelectedFigures,
        BDDScenarioTest.WhenAlignmentOptionChosen,
        BDDScenarioTest.ThenFiguresAreAligned> {

    @Test
    public void testAlignmentOfFiguresNorth() {
        // Create mock figures
        Figure figure1 = new RectangleFigure(10,20,5,5);
        Figure figure2 = new RectangleFigure(20,30,5,5);

        // Mock alignment action
        DrawingEditor drawingEditor = new DefaultDrawingEditor();
        AlignAction northAlignAction = new AlignAction.North(drawingEditor);

        // test
        given().selectedFiguresOnCanvas(figure1, figure2);
        when().alignmentOptionIsChosen(northAlignAction);
        then().allFiguresAreAlignedTo(20);
    }

    public static class GivenCanvasWithSelectedFigures extends Stage<GivenCanvasWithSelectedFigures> {
        @ProvidedScenarioState
        List<Figure> selectedFigures;

        public GivenCanvasWithSelectedFigures selectedFiguresOnCanvas(Figure... figures) {
            selectedFigures = Arrays.asList(figures);
            return self();
        }
    }

    public static class WhenAlignmentOptionChosen extends Stage<WhenAlignmentOptionChosen> {
        @ExpectedScenarioState
        List<Figure> selectedFigures;

        @ProvidedScenarioState
        AlignAction alignmentAction;

        public WhenAlignmentOptionChosen alignmentOptionIsChosen(AlignAction alignAction) {
            DrawingView view = new DefaultDrawingView();

            Rectangle2D.Double selectionBound = new Rectangle2D.Double();

            alignAction.alignFigures(selectedFigures, selectionBound);

            return self();
        }
    }

    public static class ThenFiguresAreAligned extends Stage<ThenFiguresAreAligned> {
        public ThenFiguresAreAligned allFiguresAreAlignedTo(double expectedY) {

            return self();
        }
    }
}