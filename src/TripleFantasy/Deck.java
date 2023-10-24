package TripleFantasy;

public class Deck {
}

class Card {
    public static enum Group { Steel, Magic, Holy }  // 직업군 3개 (강철, 마법, 신성)

    private int power;  // 공격력
    private int cure;  // 치유력
    final private String NATURE;  // 자연 속성 (불, 물, 풀)
    final private Group GROUP;  // 직업군 (강철, 마법, 신성)
    final private String POSITION;  // 직업
    public Card(int power, int cure, String nature, String position) {
        this.power = power;
        this.cure = cure;
        this.NATURE = nature;
        this.POSITION = position;

        // 직업군 분기
        this.GROUP = switch (position) {
            case "Knight", "Warrior", "Thief" -> Group.Steel;  // 기사, 전사, 도적 -> 강철
            case "Sorcerer", "Magician", "Necromancer" -> Group.Magic;  // 주술사, 마법사, 흑마법사 -> 마법
            default -> Group.Holy;  // 수도사, 성기사, 사제 -> 신성
        };
    }

    // Getter
    public int getPower() { return this.power; }
    public int getCure() { return cure; }
    public String getNature() { return NATURE; }
    public String getPosition() { return POSITION; }
    public Group getGroup() { return GROUP; }

    // Setter
    public void setPower(int power) { this.power = power; }
    public void setCure(int cure) { this.cure = cure; }
}

class Pack {
    protected int amount;
    protected Card[] pack;

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
    public Card[] getPack() { return pack; }
}

// 게임 중 아직 쓰이지 않은 덱
class GameDeck extends Pack {
    public GameDeck() {
        amount = 0;
        pack = new Card[21];
    }
    private void reset() {
        this.setAmount(21);
    }
    public Card throwCard() {
        Card temp = pack[amount-1];
        pack[amount-1] = null;
        amount--;
        return temp;
    }
}

// 사용하고 들어간 무덤
class Grave extends Pack {
    public Grave() {
        amount = 0;
        pack = new Card[24];
    }

    public void die(Card dead) {
        pack[amount] = dead;
        amount++;
    }
}

// 이번 턴에 사용될 카드 3장(필드)
class Field extends Pack {
    public Field() {
        amount = 0;
        pack = new Card[3];
    }

    public void deleteCard(int num) {
        pack[num] = null;
        amount--;
    }

    // 조합 판정
    public boolean isNature() {  // 필드 세 카드 자연 속성이 다 같은지
        String firstNature = pack[0].getNature();
        String secondNature = pack[1].getNature();
        String thirdNature = pack[2].getNature();

        return (firstNature.equals(secondNature) &&
                secondNature.equals(thirdNature));
    }

    public boolean isArcane() {  // 아케인(서로 다른 속성)
        String firstNature = pack[0].getNature();
        String secondNature = pack[1].getNature();
        String thirdNature = pack[2].getNature();

        return (!firstNature.equals(secondNature) &&
                !secondNature.equals(thirdNature) &&
                !firstNature.equals(thirdNature));
    }

    public boolean isFlush() {  // 플러시 (모두 같은 직업군)
        Card.Group firstGroup = pack[0].getGroup();
        Card.Group secondGroup = pack[1].getGroup();
        Card.Group thirdGroup = pack[2].getGroup();

        return (firstGroup == secondGroup &&
                secondGroup == thirdGroup);
    }

    public boolean isDouble() {  // 더블 (두 개가 같은 직업)
        String firstPosition = pack[0].getPosition();
        String secondPosition = pack[1].getPosition();
        String thirdPosition = pack[2].getPosition();

        return ((firstPosition.equals(secondPosition) ||
                secondPosition.equals(thirdPosition) ||
                thirdPosition.equals(firstPosition)) && !this.isFlush());
    }

    public boolean isStraight() {  // 스트레이트 (한 직업군의 모든 직업)
        String firstPosition = pack[0].getPosition();
        String secondPosition = pack[1].getPosition();
        String thirdPosition = pack[2].getPosition();

        return (this.isFlush() && !firstPosition.equals(secondPosition) &&
                !secondPosition.equals(thirdPosition) &&
                !thirdPosition.equals(firstPosition));
    }

    public boolean isTriple() {
        String firstPosition = pack[0].getPosition();
        String secondPosition = pack[1].getPosition();
        String thirdPosition = pack[2].getPosition();

        return (firstPosition.equals(secondPosition) &&
                secondPosition.equals(thirdPosition));
    }
}

// 이번 턴에 사용하진 않고 잠시 저장해두는 카드 3장(핸드)
class Hand extends Pack {
    public Hand() {
        amount = 0;
        pack = new Card[3];
    }
}
