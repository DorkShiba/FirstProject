package DataStructureAndAlgorithms;

/**
 * A simple model for a consumer credit card.
 *
 * @author Seongmin Lim
 */
public class CreditCard {
    private String customer, bank, account;
    private int limit;
    private double balance;

    /**
     * 새 신용카드 인스턴스를 만든다
     *
     * @param cust          사용자의 이름(예, "임성민")
     * @param bk            은행의 이름(예, "농협은행")
     * @param acnt          계좌번호(예, "1234 2345 3456 4567")
     * @param lim           신용 한도(달러 단위)
     * @param initialBal    최초 잔금(달러 단위)
     */
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    /**
     * 주어진 금액만큼 카드에 청구함(단, 신용 한도가 충분하다면)
     * @param price     청구될 금액
     * @return          청구가 승인되면 true, 반려되면 false
     */
    public boolean charge(double price) {
        if(price + balance > limit) { return false; }   // 한도 초과면 청구 반려
        balance += price;                               // 아니면 잔금 최신화 후 승인
        return true;
    }

    /**
     * 고객의 지불을 진행해 잔금을 줄임
     * @param amount    지불할 양
     */
    public void makePayment(double amount) {
        balance -= amount;
    }
}
