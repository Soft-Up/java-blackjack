package domain.state;

import domain.card.Card;

public interface DeckState {
    DeckState draw(final Card card);

    DeckState stay();

    boolean isFinished();
}
