package JavaStudy.Chap_5.PracticalProblem;

public class Km2Mile extends Converter {
    private String srcString;
    private String destString;
    public Km2Mile(double km) {
        this.ratio = km;
        srcString = "Km";
        destString = "mile";
    }

    @Override
    protected String getSrcString() { return srcString; }
    @Override
    protected String getDestString() { return destString; }
    @Override
    protected double convert(double src) { return src / ratio; }

    public static void main(String[] args) {
        Km2Mile toMile = new Km2Mile(1.6);
        toMile.run();
    }
}
