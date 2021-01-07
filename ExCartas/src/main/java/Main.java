public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck(DeckType.THREE_CARD_TYPE_CUT);
        Hand hand = new Hand(10);

        System.out.println(deck);

        deck.shuffleDeck();

        hand.drawFirstHand(deck);

        System.out.println(hand);

        hand.sortHand();

        System.out.println(hand);

        System.out.println(hand.getCardValuesInHand());
        System.out.println(hand.countAmountOfCardValueInHand(CardValue.SEVEN));
    }
}
