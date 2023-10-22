package TripleFantasy;

public class Deck {
}

class Card {
    public static enum Group { Steel, Magic, Holy; };

    private int power;
    private int cure;
    final private String NATURE;
    final private Group GROUP;
    final private String POSITION;
    public Card(int power, int cure, String nature, String position) {
        this.power = power;
        this.cure = cure;
        this.NATURE = nature;
        this.POSITION = position;
        this.GROUP = switch (position) {
            case "Knight", "Warrior", "Thief" -> Group.Steel;
            case "Sorcerer", "Magician", "Necromancer" -> Group.Magic;
            case "Monk", "Paladin", "Priest" -> Group.Holy;
            default -> null;
        };
    }

    public int getPower() { return this.power; }
    public int getCure() { return cure; }
    public String getNature() { return NATURE; }
    public String getPosition() { return POSITION; }
    public Group getGroup() { return GROUP; }

    public void setPower(int power) { this.power = power; }
    public void setCure(int cure) { this.cure = cure; }
}

class Combination {
    private int amount;

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}

class Field extends Combination {
    private Card[] field = new Card[3];

    public boolean isNature() {
        return (field[0].getNature() == field[1].getNature() &&
                field[1].getNature() == field[2].getNature());
    }

    public boolean isArcane() {
        return (field[0].getNature() != field[1].getNature() &&
                field[1].getNature() != field[2].getNature() &&
                field[0].getNature() != field[2].getNature());
    }

    public boolean isDouble() { return true; }
}
