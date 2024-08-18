package domain.state;

import domain.card.Card;
import domain.card.Cards;

public class Blackjack extends Running {
    private final Cards cards;

    public Blackjack(final Cards cards) {
        validate(cards);

        this.cards = cards;
    }

    private void validate(final Cards cards) {
        if (!cards.isBlackjack()) {
            throw new IllegalArgumentException("블랙잭 카드패가 아닙니다.");
        }
    }

    @Override
    public DeckState draw(final Card card) {
        final Cards newCards = cards.add(card);
        return new Bust();
    }

    @Override
    public DeckState stay() {
        return new Stay();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
