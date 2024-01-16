package JavaStudy.Chap_7.PracticalProblem;
import java.util.*;

public class MyProgram {
    static Scanner scanner = new Scanner(System.in);
    Vector<String> commands = new Vector<>();
    HashMap<String, Integer> vars = new HashMap<>();

    public void putCommands() {
        String str;
        while (true) {
            System.out.print(">> ");
            str = scanner.nextLine();
            if (str.equals("go")) { break; }
            else if (str.equals("quit")) {
                commands.add(str);
                break;
            }
            commands.add(str);
        }
    }

    public void mov(String name, int variable) {
        vars.put(name, variable);
    }

    public void add(String name, int variable) {
        vars.put(name, vars.get(name)+variable);
    }

    public void sub(String name, int variable) {
        vars.put(name, vars.get(name)-variable);
    }

    public boolean jn0(String name) {
        return vars.get(name) == 0;
    }

    public void printVars() {
        var names = vars.keySet();
        var it = names.iterator();
        while (it.hasNext()) {
            String curr = it.next();
            System.out.print(curr + ":" + vars.get(curr) + " ");
        }
        System.out.println();
    }

    public boolean execute() {
        System.out.println("[" + commands.get(commands.size() - 1) + "]");
        if (commands.get(commands.size() - 1).equals("quit")) { return false; }
        for (int i = 0; i < commands.size() - 1; i++) {
            String[] curr = commands.get(i).split(" ");
            switch (curr[0]) {
                case "mov" -> {
                    try {
                        mov(curr[1], Integer.parseInt(curr[2]));
                    } catch (NumberFormatException e) {
                        mov(curr[1], vars.get(curr[2]));
                    }
                }
                case "add" -> {
                    try {
                        add(curr[1], Integer.parseInt(curr[2]));
                    } catch (NumberFormatException e) {
                        add(curr[1], vars.get(curr[2]));
                    }
                }
                case "sub" -> {
                    try {
                        sub(curr[1], Integer.parseInt(curr[2]));
                    } catch (NumberFormatException e) {
                        sub(curr[1], vars.get(curr[2]));
                    }
                }
                case "jn0" -> {
                    if (!jn0(curr[1])) { i = Integer.parseInt(curr[2]) - 1; }
                }
            }
        }

        printVars();
        String printVar = commands.get(commands.size()-1).split(" ")[1];
        System.out.println("출력할 결과는 " + vars.get(printVar) + ". 프로그램 실행 끝");

        return true;
    }

    public static void main(String[] args) {
        MyProgram mp = new MyProgram();
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO를 입력하면 작동합니다.");
        while (true) {
            mp.putCommands();
            if (!mp.execute()) { break; }
        }
    }
}
