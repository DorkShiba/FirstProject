package Sample.Chap_5.PracticalProblem;

abstract class PairMap {
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    private int volume;
    private int len;
    public Dictionary(int vol) {
        this.volume = vol;
        keyArray = new String[vol];
        valueArray = new String[vol];
        len = 0;
    }

    public String get(String key) {
        for (int i = 0; i < len; i++) {
            if (keyArray[i].equals(key)) { return valueArray[i]; }
        }
        return null;
    }

    public void put(String key, String value) {
        for (int i = 0; i < len; i++) {
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }

        if (len == volume) {
            System.out.println("더 이상 입력할 수 없습니다.");
            return;
        }

        keyArray[len] = key;
        valueArray[len] = value;
        len++;
    }

    public String delete(String key) {
        String str;
        for (int i = 0; i < len; i++) {
            if (keyArray[i].equals(key)) {
                str = valueArray[i];
                for (int j = i; j < len; j++) {
                    keyArray[i] = keyArray[i+1];
                    valueArray[i] = valueArray[i+1];
                }
                len--;
                return str;
            }
        }

        System.out.println("해당 키가 존재하지 않습니다");
        return null;
    }

    public int length() { return len; }
}
public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("Hwang", "Java");
        dic.put("Lee", "Python");
        dic.put("Lee", "C++");
        System.out.println("Lee's value is " + dic.get("Lee"));
        System.out.println("Hwang's value is " + dic.get("Hwang"));
        dic.delete("Hwang");
        System.out.println("Hwang's value is " + dic.get("Hwang"));
    }
}
