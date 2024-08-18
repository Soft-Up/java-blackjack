package domain.card;

import domain.state.Score;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public Cards(final Collection<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Cards add(final Card card) {
        final List<Card> newCards = new ArrayList<>(cards);

        newCards.add(card);

        return new Cards(newCards);
    }

    public boolean isBlackjack() {
        return sum().isBlackjack();
    }

    public boolean isBust() {
        return sum().isBust();
    }

    public Score getScore() {
        Score score = sum();
        final long aceCount = cards.stream()
                .filter(Card::isAce)
                .count();

        for (long count = 0L; count < aceCount; count++) {
            score = score.add(10);
        }

        return score;
    }

    private Score sum() {
        return new Score(cards.stream().mapToInt(Card::getScore).sum());
    }
}
