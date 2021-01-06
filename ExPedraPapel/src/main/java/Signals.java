public enum Signals {
    ROCK, PAPER, SCISSOR;

    public int interactionResult (Signals s2) {
        switch (this) {
            case ROCK:
                switch (s2) {
                    case ROCK:
                        return 0;
                    case PAPER:
                        return 2;
                    case SCISSOR:
                        return 1;
                }
            case SCISSOR:
                switch (s2) {
                    case ROCK:
                        return 2;
                    case PAPER:
                        return 1;
                    case SCISSOR:
                        return 0;
                }
            case PAPER:
                switch (s2) {
                    case ROCK:
                        return 1;
                    case PAPER:
                        return 0;
                    case SCISSOR:
                        return 2;
                }
            default:
                throw new IllegalStateException("Algo correu mal");
        }
    }
}
