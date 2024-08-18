package state;

import domain.card.Card;
import domain.card.Cards;
import domain.card.Denomination;
import domain.card.Suit;
import domain.state.Blackjack;
import domain.state.Bust;
import domain.state.DeckState;
import domain.state.Stay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlackjackTest {
    private static final Cards BLACKJACK_CARDS = new Cards()
            .add(Card.getInstance(Denomination.KING, Suit.SPADE))
            .add(Card.getInstance(Denomination.EIGHT, Suit.DIAMOND))
            .add(Card.getInstance(Denomination.THREE, Suit.DIAMOND));

    @Test
    @DisplayName("Blackjack -> Bust")
    void drawTest() {
        // given
        final DeckState deckState = new Blackjack(BLACKJACK_CARDS);

        // when
        final DeckState actual = deckState.draw(Card.getInstance(Denomination.EIGHT, Suit.SPADE));

        // then
        assertThat(actual).isInstanceOf(Bust.class);
    }

    @Test
    @DisplayName("Blackjack -> Stay")
    void stayTest() {
        // given
        final DeckState deckState = new Blackjack(BLACKJACK_CARDS);

        // when
        final DeckState actual = deckState.stay();

        // then
        assertThat(actual).isInstanceOf(Stay.class);
    }

    @Test
    @DisplayName("Blackjack은 갈 수 있는 상태가 없다.")
    void isFinishedTest() {
        assertThat(new Blackjack(BLACKJACK_CARDS).isFinished()).isFalse();
    }
}