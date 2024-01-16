package JavaStudy.Chap_7;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Scanner;

class Word {
    private String eng, kor;
    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }

    public String getEng() { return eng; }
    public String getKor() { return kor; }
}

public class WordQuiz {
    private Vector<Word> wordList = new Vector<>();
    private Scanner scanner = new Scanner(System.in);

    public void getWord() {
        System.out.print("단어 리스트에 넣을 영단어를 입력해주세요>>");
        String eng = scanner.next();
        System.out.print("한국어 뜻을 입력해주세요>>");
        String kor = scanner.next();
        wordList.add(new Word(eng, kor));
    }
    public String getProblem(int correctIndex, int correctNum) {
        String pro = "";
        Word correct = wordList.get(correctIndex);
        Vector<Integer> used = new Vector<>();

        for (int i = 1; i <= 4; i++) {
            pro = pro.concat("(").concat(Integer.toString(i)).concat(")");

            if (i == correctNum) {
                pro = pro.concat(correct.getKor()).concat(" ");
            } else {
                int wrongIndex;

                while (true) {
                    wrongIndex = (int) (Math.random() * wordList.size());
                    if (wrongIndex == correctIndex || used.contains(wrongIndex)) { continue; }

                    used.add(wrongIndex);
                    break;
                }
                pro = pro.concat(wordList.get(wrongIndex).getKor()).concat(" ");
            }
        }
        pro = pro.concat(":>");

        return pro;
    }

    public void run() {
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + wordList.size() + "개의 단어가 들어 있습니다.");

        while (true) {
            int correctIndex = (int) (Math.random() * wordList.size());
            Word correctAnswer = wordList.get(correctIndex);
            System.out.println(correctAnswer.getEng() + "?");

            int correctNum = (int) (Math.random() * 4 + 1);
            String problem = getProblem(correctIndex, correctNum);
            System.out.print(problem);

            int answer;
            while (true) {
                try {
                    answer = scanner.nextInt();
                    if ((answer < 1 && answer != -1) || answer > 4) {
                        System.out.println("1 ~ 4의 정수를 입력해주세요. 종료하시려면 -1을 입력해주세요.");
                        scanner.nextLine();
                        System.out.print(problem);
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("1 ~ 4의 정수를 입력해주세요. 종료하시려면 -1을 입력해주세요.");
                    scanner.nextLine();
                    System.out.print(problem);
                }
            }

            if (answer == -1) {
                System.out.println("\"명품영어\"를 종료합니다...");
                scanner.close();
                break;
            }

            if (answer == correctNum) {
                System.out.println("Excellent !!");
            } else {
                System.out.println("No. !!");
            }
        }
    }

    public static void main(String[] args) {
        WordQuiz wq = new WordQuiz();

        int wordNum;
        while (true) {
            System.out.print("단어 리스트의 단어 갯수를 입력해주세요 (4보다 큰 정수)>>");
            try {
                wordNum = wq.scanner.nextInt();
                if (wordNum <= 4) {
                    System.out.println("4보다 큰 정수를 입력해주세요");
                    wq.scanner.nextLine();
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("4보다 큰 정수를 입력해주세요");
                wq.scanner.nextLine();
            }
        }

        for (int i = 1; i <= wordNum; i++) {
            System.out.println(i + "번째 단어 입력");
            wq.getWord();
        }
        wq.run();
    }
}
