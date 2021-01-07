import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Deck {

    private List<Card> deck;
    private DeckType deckType;

    private static final DeckType DECKTYPE_OMITTED = DeckType.FULL_DECK;

    public Deck (List<Card> deck, DeckType deckType) {
        setDeck(deck);
        setDeckType(deckType);
        createDeck();
    }

    public Deck (DeckType deckType) {
        setDeck(new ArrayList<Card>());
        setDeckType(deckType);
        createDeck();
    }

    public Deck() {
        setDeck(new ArrayList<Card>());
        setDeckType(DECKTYPE_OMITTED);
        createDeck();
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = new ArrayList<Card>(deck);
    }

    public DeckType getDeckType() {
        return deckType;
    }

    public void setDeckType(DeckType deckType) {
        this.deckType = deckType;
    }

    public void createDeck() {
        switch (deckType) {
            case FULL_DECK:
                for (CardType ct: CardType.values()) {
                    for (CardValue cv : CardValue.values()) {
                        addCard(new Card (cv, ct));
                    }
                }
                break;
            case THREE_CARD_TYPE_CUT:
                for (CardType ct: CardType.values()) {
                    for (CardValue cv : CardValue.values()) {
                        if (cv.getValue() < 8 || cv.getValue() > 10) {
                            addCard(new Card (cv, ct));
                        }
                    }
                }
                break;
        }
    }

    public void addCard (Card card) {
        if (!deck.contains(card)) {
            this.deck.add(card);
        } else {
            System.out.println("Card already exists");
        }
    }

    public void removeCard (Card card) {
        if (deck.contains(card)) {
            this.deck.remove(card);
        } else {
            System.out.println("Card not in deck");
        }
    }


    public void shuffleDeck () {
        Collections.shuffle(deck);
    }

    public Card topCard() {
        return this.getDeck().get(this.getDeck().size() - 1);
    }

    @Override
    public String toString() {
        return "Deck: \n" + listDeck();
    }

    public StringBuilder listDeck() {
        StringBuilder cardsInHand = new StringBuilder();
        for (Card c : deck) {
            cardsInHand.append(c.toString()).append("\n");
        }
        return cardsInHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck1 = (Deck) o;
        return getDeck().equals(deck1.getDeck()) &&
                getDeckType() == deck1.getDeckType();
    }


}
