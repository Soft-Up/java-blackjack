package domain.user;

import domain.card.Card;
import domain.state.DeckState;

public class Player {
    private final String name;

    private final DeckState deckState;

    public Player(
            final String name,
            final DeckState deckState
    ) {
        this.name = name;
        this.deckState = deckState;
    }

    public Player draw(final Card card) {
        deckState.draw(card);
        return this;
    }

    public boolean isFinished() {
        return deckState.isFinished();
    }
}
