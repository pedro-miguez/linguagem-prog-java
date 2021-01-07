public enum Signals {
    ROCK, PAPER, SCISSOR;

    public int interactionResult (Signals s2) {
        return switch (this) {
            case ROCK -> switch (s2) {
                case ROCK -> 0;
                case PAPER -> 2;
                case SCISSOR -> 1;
            };
            case SCISSOR -> switch (s2) {
                case ROCK -> 2;
                case PAPER -> 1;
                case SCISSOR -> 0;
            };
            case PAPER -> switch (s2) {
                case ROCK -> 1;
                case PAPER -> 0;
                case SCISSOR -> 2;
            };
        };
    }
    
}
