package JavaStudy.Chap_7.PracticalProblem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


class Student {
    String name, major;
    int number;
    double gradeAverage;
    public Student(String name, String major, int number, double gradeAverage) {
        this.name = name; this.major = major;
        this.number = number;
        this.gradeAverage = gradeAverage;
    }

    public String toString() {
        String str = "";
        str = str.concat("이름:").concat(name).concat("\n");
        str = str.concat("학과:").concat(major).concat("\n");
        str = str.concat("학번:").concat(Integer.toString(number)).concat("\n");
        str = str.concat("학점평균:").concat(Double.toString(gradeAverage));
        return str;
    }
}

public class StudentManage {
    ArrayList<Student> students = new ArrayList<>();
    HashMap<String, Student> students2 = new HashMap<>();
    String[] names = new String[4];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String name, major;
        int number;
        double grade;
        StudentManage sm = new StudentManage();

        System.out.println("학생 이름, 학과, 학번, 학점평균을 입력하세요.");
        String str;
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            str = scanner.next();
            String[] info = str.split(", ");

            name = info[0];
            major = info[1];
            number = Integer.parseInt(info[2]);
            grade = Double.parseDouble(info[3]);

            sm.students.add(new Student(name, major, number, grade));
            sm.students2.put(name, new Student(name, major, number, grade));
            sm.names[i] = name;
        }
        System.out.println("-------------------------------");

//        for (int i = 0; i < 4; i++) {
//            System.out.println(sm.students.get(i));
//            System.out.println("-------------------------------");
//        }
//
//        while (true) {
//            System.out.print("학생 이름 >> ");
//            name = scanner.next();
//            if (name.equals("그만")) { break; }
//            Student temp = null;
//            int i = 0;
//            while (i < sm.students.size()) {
//                if (sm.students.get(i).name.equals(name)) {
//                    temp = sm.students.get(i);
//                    break;
//                }
//                i++;
//            }
//            if (temp == null) {
//                System.out.println("그런 학생은 없습니다.");
//            } else {
//                System.out.println(temp.name + ", " + temp.major + ", " + temp.number + ", " + temp.gradeAverage);
//            }
//        }
        for (int i = 0; i < 4; i++) {
            System.out.println(sm.students2.get(sm.names[i]));
            System.out.println("-------------------------------");
        }

        while (true) {
            System.out.print("학생 이름 >> ");
            name = scanner.next();
            if (name.equals("그만") || name.equals("quit")) { break; }
            Student temp = null;
            for (int i = 0; i < 4; i++) {
                if (sm.names[i].equals(name)) {
                    temp = sm.students2.get(sm.names[i]);
                    break;
                }
            }
            if (temp == null) {
                System.out.println("그런 학생은 없습니다.");
            } else {
               System.out.println(temp.name + ", " + temp.major + ", " + temp.number + ", " + temp.gradeAverage);
            }
        }
    }
}
