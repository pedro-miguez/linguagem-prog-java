import java.util.Objects;

public class Card implements Comparable<Card> {

    private CardType cardType;
    private CardValue cardValue;

    public Card (CardValue cardValue, CardType cardType) {
        setCardValue(cardValue);
        setCardType(cardType);
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public int compareTo(Card otherCard) {
        int typeCompare = this.getCardType().compareTo(otherCard.getCardType());
        int valueCompare = this.getCardValue().compareTo(otherCard.getCardValue());
        if (typeCompare != 0) {
            return typeCompare;
        } else {
            return valueCompare;
        }
    }

    @Override
    public String toString() {
        return String.format("%S of %S", this.getCardValue(), this.getCardType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getCardType() == card.getCardType() &&
                getCardValue() == card.getCardValue();
    }

}
