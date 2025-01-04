
public class LineColorScenarioTest.java
{
    @ScenarioStage
    private GivenStage given;

    @ScenarioStage
    private WhenStage when;

    @ScenarioStage
    private ThenStage then;

    @Test
    public void line_color_can_be_changed_from_black_to_red() {
        given.a_line_figure_with_color(Color.BLACK);
        when.the_user_selects_color_from_stroke_palette(Color.RED);
        then.the_line_color_should_be(Color.RED);
    }

    static class GivenStage extends Stage<GivenStage> {
        private LineFigure lineFigure;
        private DrawingEditor editor;

        public GivenStage a_line_figure_with_color(Color color) {
            lineFigure = new LineFigure();
            lineFigure.set(AttributeKeys.STROKE_COLOR, color);

            editor = new DefaultDrawingEditor();
            DrawingView view = editor.getActiveView();
            view.getDrawing().add(lineFigure);

            return self();
        }
    }

    static class WhenStage extends Stage<WhenStage> {
        public WhenStage the_user_selects_color_from_stroke_palette(Color color) {
            AttributeAction action = new AttributeAction(editor, AttributeKeys.STROKE_COLOR, color);
            action.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

            return self();
        }
    }

    static class ThenStage extends Stage<ThenStage> {
        public ThenStage the_line_color_should_be(Color color) {
            DrawingView view = editor.getActiveView();
            Figure figure = view.getDrawing().getChild(0);

            assertThat(((LineFigure) figure).get(AttributeKeys.STROKE_COLOR)).isEqualTo(color);

            return self();
        }
    }
}
