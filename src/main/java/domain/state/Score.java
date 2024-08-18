package domain.state;

public class Score {
    private static final int BLACKJACK_SCORE = 21;

    private final int value;

    public Score(final int value) {
        this.value = value;
    }

    public Score add(final int value) {
        final Score newScore = new Score(this.value + value);

        if(newScore.isBust()) {
            return this;
        }

        return newScore;
    }

    public boolean isBlackjack() {
        return value == BLACKJACK_SCORE;
    }

    public boolean isBust() {
        return value > BLACKJACK_SCORE;
    }
}
