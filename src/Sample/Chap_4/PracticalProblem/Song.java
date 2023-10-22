package Sample.Chap_4.PracticalProblem;

// Problem 3
public class Song {
    private String title;  // 노래 제목
    private String artist;  // 가수
    private int year;  // 노래 출시 연도
    private String country;  // 가수의 국적

    // 생성자
    public Song() { }
    public Song(String title, String artist, int year, String country) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    // 필드 게터
    public String getTitle() { return this.title; }
    public String getArtist() { return this.artist; }
    public int getYear() { return this.year; }
    public String getCountry() { return this.country; }

    // 필드 세터
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setYear(int year) { this.year = year; }
    public void setCountry(String country) { this.country = country; }

    // 노래의 정보를 설명하는 메소드
    public void show() {
        System.out.println(this.year + "년 " + this.country + "국적의 " +
                this.artist + "가 부른 " + this.title);
    }

    public static void main(String[] args) {
        Song mySong = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
        mySong.show();
    }
}
