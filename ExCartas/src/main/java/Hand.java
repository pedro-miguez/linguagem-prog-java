import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Hand {

    private int handSize;
    private List<Card> hand;

    public Hand (int handSize, List<Card> hand) {
        setHandSize(handSize);
        setHand(hand);
    }

    public Hand (int handSize) {
        setHandSize(handSize);
        setHand(new ArrayList<Card>());
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<CardValue> getCardValuesInHand() {
        ArrayList<CardValue> cardValuesInHand = new ArrayList<CardValue>();

        for (Card c : hand) {
            if (!cardValuesInHand.contains(c.getCardValue())) {
                cardValuesInHand.add(c.getCardValue());
            }
        }
        return cardValuesInHand;
    }

    public int countHandValue() {
        int sum = 0;

        for (Card c : hand) {
            sum += c.getCardValue().getValue();
        }

        if (getCardValuesInHand().contains(CardValue.ACE) && sum > 21) {
            sum -= 10;
        }

        return sum;
    }



    public int countAmountOfCardValueInHand(CardValue cardValue) {
        int counter = 0;
        for (Card c : hand) {
            if (c.getCardValue() == cardValue) {
               counter++;
            }
        }
        return counter;
    }

    public void sortHand() {
        Collections.sort(hand);
    }

    @Override
    public String toString() {
        return "Hand: \n" + listHand();
    }

    public StringBuilder listHand() {
        StringBuilder cardsInHand = new StringBuilder();
        for (Card c : hand) {
            cardsInHand.append(c.toString()).append("\n");
        }
        return cardsInHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand1 = (Hand) o;
        return getHandSize() == hand1.getHandSize() &&
                getHand().equals(hand1.getHand());
    }

    public void drawFirstHand (Deck deck) {
        for (int i = 0; i < this.getHandSize(); i++) {
            hand.add(deck.topCard());
            deck.removeCard(deck.topCard());
        }
    }

    public void drawCards (Deck deck, int nOfCards) {
        for (int i = 0; i < nOfCards; i++) {
            hand.add(deck.topCard());
            deck.removeCard(deck.topCard());
        }
    }

    public void clearHand() {
        for (Card c : hand) {
            hand.remove(c);
        }
    }

    public int hit(Deck deck) {
        drawCards(deck, 1);
        return countHandValue();
    }
}
