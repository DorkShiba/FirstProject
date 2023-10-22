package Sample.Chap_5.PracticalProblem;

public class IPTV extends ColorTV {
    private String address;
    public IPTV(String address, int size, int resolution) {
        super(size, resolution);
        this.address = address;
    }

    @Override
    public void printProperty() {
        System.out.println("나의 IPTV는 " + address + " 주소의 " + this.getSize() + "인치 " +
                this.getResolution() + "컬러");
    }

    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}
