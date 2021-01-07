public class Player {

    private int cashRoll;
    private String name;
    private Hand hand;

    public Player (int cashRoll, String name ) {
        setCashRoll(cashRoll);
        setName(name);
        setHand(new Hand(2));
    }

    public int getCashRoll() {
        return cashRoll;
    }

    public void setCashRoll(int cashRoll) {
        this.cashRoll = cashRoll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

}
