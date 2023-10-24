package TripleFantasy;

public class Board {
    private Deck deck;
    private Field field;
    private Hand hand;
    private GameDeck gameDeck;
    private Grave grave;
    private int trick;
    public Board() {
        deck = new Deck();
        field = new Field();
        hand = new Hand();
        gameDeck = new GameDeck();
        grave = new Grave();
        trick = 3;
    }

    public void throwCard2Field() {
        for (int i = 0; i < field.getPack().length; i++) {
            if (field.getPack()[i] == null) {
                field.getPack()[i] = gameDeck.throwCard();
            }
        }
    }

    public void throwCard2Hand() {
        for (int i = 0; i < hand.getPack().length; i++) {
            if (hand.getPack()[i] == null) {
                hand.getPack()[i] = gameDeck.throwCard();
            }
        }
    }

    public void useCards() {
        for (int i = 0; i < field.getPack().length; i++) {
            grave.die(field.getPack()[i]);
            field.deleteCard(i);
        }
    }

    public double magnification() {
        double total = 1;

        // 자연 조합 배율
        if (field.isNature()) { total *= 3.00; }
        else if (field.isArcane()) { total *= 2.50; }

        // 직업 조합 배율
        if (field.isDouble()) { total *= 2.00; }
        else if (field.isStraight()) { total *= 5.00; }
        else if (field.isFlush()) { total *= 3.00; }
        else if (field.isTriple()) { total *= 7.00; }

        return total;
    }

    public int getTotalPower() {
        int power = 0;
        for (int i = 0; i < field.getPack().length; i++) {
            power += field.getPack()[i].getPower();
        }

        power = (int)Math.ceil(power * this.magnification());
        return power;
    }

    public int getTotalCure() {
        int cure = 0;
        for (int i = 0; i < field.getPack().length; i++) {
            cure += field.getPack()[i].getCure();
        }

        cure = (int)Math.ceil(cure * this.magnification());
        return cure;
    }
}
