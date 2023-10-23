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
    private int amount;

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}

class GameDeck extends Pack {
    private void reset() {
        this.setAmount(21);
    }
}

class Grave extends Pack {

}

class Field extends Pack {
    private Card[] field = new Card[3];

    public void getCardInField(Pack pack) {

    }

    // 배율 판정
    private boolean isNature() {  // 필드 세 카드 자연 속성이 다 같은지
        String firstNature = field[0].getNature();
        String secondNature = field[1].getNature();
        String thirdNature = field[2].getNature();

        return (firstNature.equals(secondNature) &&
                secondNature.equals(thirdNature));
    }

    private boolean isArcane() {  // 아케인(서로 다른 속성)
        String firstNature = field[0].getNature();
        String secondNature = field[1].getNature();
        String thirdNature = field[2].getNature();

        return (!firstNature.equals(secondNature) &&
                !secondNature.equals(thirdNature) &&
                !firstNature.equals(thirdNature));
    }

    private boolean isFlush() {  // 플러시 (모두 같은 직업군)
        Card.Group firstGroup = field[0].getGroup();
        Card.Group secondGroup = field[1].getGroup();
        Card.Group thirdGroup = field[2].getGroup();

        return (firstGroup == secondGroup &&
                secondGroup == thirdGroup);
    }

    private boolean isDouble() {  // 더블 (두 개가 같은 직업)
        String firstPosition = field[0].getPosition();
        String secondPosition = field[1].getPosition();
        String thirdPosition = field[2].getPosition();

        return ((firstPosition.equals(secondPosition) ||
                secondPosition.equals(thirdPosition) ||
                thirdPosition.equals(firstPosition)) && !this.isFlush());
    }

    private boolean isStraight() {  // 스트레이트 (한 직업군의 모든 직업)
        String firstPosition = field[0].getPosition();
        String secondPosition = field[1].getPosition();
        String thirdPosition = field[2].getPosition();

        return (this.isFlush() && !firstPosition.equals(secondPosition) &&
                !secondPosition.equals(thirdPosition) &&
                !thirdPosition.equals(firstPosition));
    }

    private boolean isTriple() {
        String firstPosition = field[0].getPosition();
        String secondPosition = field[1].getPosition();
        String thirdPosition = field[2].getPosition();

        return (firstPosition.equals(secondPosition) &&
                secondPosition.equals(thirdPosition));
    }
}

class Hand extends Pack {

}
