package JavaStudy.Chap_6.PracticalProblem.app;
import JavaStudy.Chap_6.PracticalProblem.base.Shape;
import JavaStudy.Chap_6.PracticalProblem.derived.Circle;
public class GraphicEditor {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
    }
}
