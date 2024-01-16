package JavaStudy.Chap_4.PracticalProblem;

// Problem 1
public class TV {
    private String company;  // 제조회사
    private int year;  // 생산연도
    private int inch;  // 인치(사이즈)

    public TV(String company, int year, int inch) {
        this.company = company;
        this.year = year;
        this.inch = inch;
    }

    // 필드 게터
    public String getCompany() { return this.company; }
    public int getYear() { return this.year; }
    public int getInch() { return this.inch; }

    // 필드 세터
    public void setCompany(String company) { this.company = company; }
    public void setYear(int year) { this.year = year; }
    public void setInch(int inch) { this.inch = inch; }

    // TV의 정보를 설명하는 메소드
    public void show() {
        System.out.println(this.company + "에서 만든 " + this.year + "년형 "
        + this.inch + "인치 TV");
    }

    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32);
        myTV.show();
    }
}
