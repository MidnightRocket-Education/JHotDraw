import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.geom.BezierPath;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class BezierFigureTest {

    @Test
    public void testBasicSetGet() {
        BezierFigure figure = new BezierFigure();
        figure.set(AttributeKeys.STROKE_COLOR, Color.RED);
        Assert.assertEquals(Color.RED, figure.get(AttributeKeys.STROKE_COLOR));
    }

    @Test
    public void testTransform() {
        BezierFigure figure = new BezierFigure();
        figure.addNode(new BezierPath.Node(0, 0));
        figure.addNode(new BezierPath.Node(10, 10));

        AffineTransform tx = new AffineTransform();
        tx.translate(5, 5);
        figure.transform(tx);

        Assert.assertEquals(new Point2D.Double(5, 5), figure.getNode(0).getControlPoint(0));
        Assert.assertEquals(new Point2D.Double(15, 15), figure.getNode(1).getControlPoint(0));
    }

    @Test
    public void testBounds() {
        BezierFigure figure = new BezierFigure();
        figure.addNode(new BezierPath.Node(0, 0));
        figure.addNode(new BezierPath.Node(10, 10));

        Rectangle bounds = figure.getBounds();
        Assert.assertEquals(0, bounds.x);
        Assert.assertEquals(0, bounds.y);
        Assert.assertEquals(10, bounds.width);
        Assert.assertEquals(10, bounds.height);
    }

    @Test
    public void testContains() {
        BezierFigure figure = new BezierFigure();
        figure.addNode(new BezierPath.Node(0, 0));
        figure.addNode(new BezierPath.Node(10, 10));

        Assert.assertTrue(figure.contains(new Point2D.Double(5, 5)));
        Assert.assertFalse(figure.contains(new Point2D.Double(15, 15)));
    }

    @Test
    public void testClone() {
        BezierFigure figure = new BezierFigure();
        figure.addNode(new BezierPath.Node(0, 0));
        figure.addNode(new BezierPath.Node(10, 10));

        BezierFigure clone = (BezierFigure) figure.clone();
        Assert.assertNotSame(figure, clone);
        Assert.assertEquals(figure.getNodeCount(), clone.getNodeCount());
    }
}