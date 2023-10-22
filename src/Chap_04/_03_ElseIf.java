package Chap_04;

public class _03_ElseIf {
    public static void main(String[] args) {
        // 한라봉 에이드 있으면 주문
        // 아니면 망고 주스 있으면 주문
        // 다 없으면 아이스 아메리카노
        boolean hallabongAde = true, mangoJuice = true;
        
        if (hallabongAde) {
            System.out.println("한라봉 에이드 +1");
        } else if (mangoJuice) {
            System.out.println("망고 주스 +1");
        } else {
            System.out.println("아이스 아메리카노 +1");
        }
    }
}