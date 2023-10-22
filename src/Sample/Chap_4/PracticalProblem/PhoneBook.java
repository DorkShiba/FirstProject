package Sample.Chap_4.PracticalProblem;
import java.util.InputMismatchException;
import java.util.Scanner;

// Problem 8
class Phone {
    private String name;  // 사람 이름
    private String tel;  // 전화번호

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    // 필드 게터
    public String getName() { return this.name; }
    public String getTel() { return this.tel; }

    // 필드 세터
    public void setName(String name) { this.name = name; }
    public void setTel(String tel) { this.tel = tel; }

    // 사람의 전화번호를 설명하는 메소드
    public void show() { System.out.println(this.name + "의 번호는 " + this.tel + " 입니다."); }
}

public class PhoneBook {
    private final Scanner scanner = new Scanner(System.in);  // 스캐너
    private Phone[] phones;  // 전화번호부

    // 필드 게터
    public Phone[] getPhones() { return this.phones; }

    // 인원수대로 전화번호를 저장하는 메소드
    public void save() {
        int num;  // 인원수
        String name, tel;  // 이름과 전화번호

        while (true) {
            try {
                System.out.print("인원수>>");
                num = this.scanner.nextInt();

                if (num < 1) {
                    System.out.println("올바른 인원수를 입력해주세요");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요");
                this.scanner.nextLine();
            }
        }
        this.phones = new Phone[num];

        for (int i = 0; i < this.phones.length; i++) {
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
            name = this.scanner.next();
            tel = this.scanner.next();
            this.phones[i] = new Phone(name, tel);
        }

        System.out.println("저장되었습니다...");
    }

    // 사람이름으로 전화번호를 검색하는 메소드
    public void search() {
        String name;  // 이름
        boolean find = false;  // 사람을 전화번호부에서 찾았는지 여부

        while (true) {
            find = false;

            System.out.print("검색할 이름>>");
            name = this.scanner.next();

            if (name.equals("그만")) {
                this.scanner.close();
                break;
            }

            for (int i = 0; i < this.phones.length; i++) {
                if (this.phones[i].getName().equals(name)) {
                    this.phones[i].show();
                    find = true;
                    continue;
                }
            }

            if (!find) { System.out.println(name + " 이 없습니다."); }
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.save();
        phoneBook.search();
    }
}
