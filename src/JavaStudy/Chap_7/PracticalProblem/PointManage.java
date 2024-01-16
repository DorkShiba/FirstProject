package JavaStudy.Chap_7.PracticalProblem;

import java.util.*;

public class PointManage {
    static Scanner scanner = new Scanner(System.in);
    private HashMap<String, Integer> clients = new HashMap<>();

    public String toString() {
        String str = "";
        var keys = clients.keySet();
        var it = keys.iterator();
        while (it.hasNext()) {
            String name = it.next();
            str = str.concat("(").concat(name).concat(",")
                    .concat(Integer.toString(clients.get(name))).concat(")");
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("** 포인트 관리 프로그램입니다 **");
        String name;
        int point;
        PointManage pm = new PointManage();
        while (true) {
            System.out.print("이름과 포인트 입력>> ");
            name = scanner.next();
            if (name.equals("그만")) { break; }
            point = scanner.nextInt();
            if (pm.clients.containsKey(name)) {
                pm.clients.put(name, pm.clients.get(name) + point);
            } else {
                pm.clients.put(name, point);
            }
            System.out.println(pm);
        }
    }
}
