package Sample.Chap_7.PracticalProblem;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

class Location {
    private int longitude, latitude;
    public Location(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLong() { return longitude; }
    public int getLat() { return latitude; }
}

public class LocationManage {
    static Scanner scanner = new Scanner(System.in);
    private HashMap<String, Location> city = new HashMap<>();


    public void inputCity() {
        System.out.println("도시, 경도, 위도를 입력하세요.");
        String cityInfo;
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            cityInfo = scanner.nextLine();
            String[] splitInfo = cityInfo.split(", ");
            city.put(splitInfo[0], new Location(Integer.parseInt(splitInfo[1]), Integer.parseInt(splitInfo[2])));
        }
    }

    public HashMap<String, Location> getCity() { return city; }

    public static void main(String[] args) {
        LocationManage lm = new LocationManage();
        lm.inputCity();
        System.out.println("-------------------------------");

        var city = lm.getCity();
        var names = lm.getCity().keySet();
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String name = it.next();
            System.out.printf("%-4s", name);
            System.out.print(" ");
            System.out.printf("%-4d", city.get(name).getLong());
            System.out.print(" ");
            System.out.printf("%-4d", city.get(name).getLat());
            System.out.println();
        }
        System.out.println("-------------------------------");

        while (true) {
            System.out.print("도시 이름 >> ");
            String name = scanner.next();
            if (name.equals("그만")) { break; }

            if (city.containsKey(name)) {
                System.out.printf("%-4s", name);
                System.out.printf("%-4d", city.get(name).getLong());
                System.out.printf("%-4d", city.get(name).getLat());
                System.out.println();
            } else {
                System.out.println(name + "는 없습니다.");
            }
        }
    }
}
