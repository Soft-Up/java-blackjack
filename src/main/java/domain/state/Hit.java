package domain.state;

import domain.card.Card;
import domain.card.Cards;

public class Hit extends Started {
    private final Cards cards;

    public Hit() {
        this.cards = new Cards();
    }

    public Hit(final Cards cards) {
        this.cards = cards;
    }

    @Override
    public DeckState draw(final Card card) {
        final Cards newCards = cards.add(card);

        if(newCards.isBlackjack()) {
            return new Blackjack(newCards);
        }
        if(newCards.isBust()) {
            return new Bust();
        }
        return new Hit(newCards);
    }

    @Override
    public DeckState stay() {
        return new Stay();
    }
}
