package Sample.Chap_5.PracticalProblem;

public class Won2Dollar extends Converter {
    private String srcString;
    private String destString;
    public Won2Dollar(double won) {
        this.ratio = won;
        srcString = "원";
        destString = "달러";
    }

    @Override
    protected String getSrcString() { return srcString; }
    @Override
    protected String getDestString() { return destString; }
    @Override
    protected double convert(double src) { return src / ratio; }

    public static void main(String[] args) {
        Won2Dollar toDollar = new Won2Dollar(1200);
        toDollar.run();
    }
}
