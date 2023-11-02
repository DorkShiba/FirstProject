package Sample.Chap_6.PracticalProblem.app;
import Sample.Chap_6.PracticalProblem.base.Shape;
import Sample.Chap_6.PracticalProblem.derived.Circle;
public class GraphicEditor {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
    }
}
