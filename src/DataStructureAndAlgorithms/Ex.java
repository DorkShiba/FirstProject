package DataStructureAndAlgorithms;

class Flower {
    private String name;
    private int petals;
    private float price;

    public Flower(String name, int petals, float price) {
        this.name = name;
        this.petals = petals;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPetals() { return petals; }
    public void setPetals(int petals) { this.petals = petals; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
}
public class Ex {
    public boolean isMultiple(long n, long m) {
        return n % m == 0;
    }

    public static boolean isOdd(int i) {
        while (i > 0) {
            i -= 2;
        }

        if (i == 0) { return false; }
        else { return true; }
    }

    public static int sigma(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) { sum += i; }

        return sum;
    }

    public static int evenSigma(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }

        return sum;
    }

    public static int squareSigma(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }

        return sum;
    }

    public static int countVowel(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { count++; }
        }

        return count;
    }

    public static String removePunctuation(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c == '.' || c == ',' || c == '?' || c == '!' || c == '\'' || c == '\"' ||
            c == ':' || c == ';' || c == '-')) { sb.append(c); }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Let\'s try, Mike!";
        str = removePunctuation(str);
        System.out.println(str);
    }
}
