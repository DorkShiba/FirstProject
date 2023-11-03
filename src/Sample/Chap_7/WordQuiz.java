package Sample.Chap_7;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Scanner;
import java.util.Iterator;
import java.lang.StringBuffer;

class Word {
    private String eng, kor;
    private boolean used;
    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
        used = false;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() { return used; }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
}

public class WordQuiz {
    private Vector<Word> wordList = new Vector<>();
    private Scanner scanner = new Scanner(System.in);

    public void reset() {
        Iterator<Word> it = wordList.iterator();
        while (it.hasNext()) {
            it.next().setUsed(false);
        }
    }

    public String getProblem(int correctIndex, int correctNum) {
        StringBuffer pro = new StringBuffer();
        Word correct = wordList.get(correctIndex);

        for (int i = 1; i <= 4; i++) {
            pro.append("(").append(i).append(")");

            if (i == correctNum) {
                pro.append(correct.getKor()).append(" ");
            } else {
                int wrongIndex;

                while (true) {
                    wrongIndex = (int) (Math.random() * 17);
                    if (wrongIndex == correctIndex || wordList.get(wrongIndex).isUsed()) { continue; }

                    wordList.get(wrongIndex).setUsed(true);
                    break;
                }
                pro.append(wordList.get(wrongIndex).getKor()).append(" ");
            }
        }
        pro.append(":>");

        return pro.toString();
    }

    public void run() {
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + wordList.size() + "개의 단어가 들어 있습니다.");

        while (true) {
            int correctIndex = (int) (Math.random() * 17);
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
            reset();
        }
    }

    public static void main(String[] args) {
        WordQuiz wq = new WordQuiz();
        wq.wordList.add(new Word("love", "사랑"));
        wq.wordList.add(new Word("animal", "동물"));
        wq.wordList.add(new Word("plant", "식물"));
        wq.wordList.add(new Word("human", "사람"));
        wq.wordList.add(new Word("painting", "그림"));
        wq.wordList.add(new Word("baby", "아기"));
        wq.wordList.add(new Word("eye", "눈"));
        wq.wordList.add(new Word("ear", "귀"));
        wq.wordList.add(new Word("nose", "코"));
        wq.wordList.add(new Word("mouth", "입"));
        wq.wordList.add(new Word("hand", "손"));
        wq.wordList.add(new Word("foot", "발"));
        wq.wordList.add(new Word("house", "집"));
        wq.wordList.add(new Word("dog", "개"));
        wq.wordList.add(new Word("cat", "고양이"));
        wq.wordList.add(new Word("tree", "나무"));
        wq.wordList.add(new Word("school", "학교"));
        wq.run();
    }
}
