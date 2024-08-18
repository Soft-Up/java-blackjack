package state;

import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suit;
import domain.state.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HitTest {
    @Test
    @DisplayName("Hit -> Hit")
    void drawHitTest() {
        // given
        final DeckState deckState = new Hit();

        // when
        final DeckState actual = deckState.draw(Card.getInstance(Denomination.EIGHT, Suit.SPADE));

        // then
        assertThat(actual).isInstanceOf(Hit.class);
    }

    @Test
    @DisplayName("Hit -> Bust")
    void drawBustTest() {
        // given
        final DeckState deckState = new Hit()
                .draw(Card.getInstance(Denomination.KING, Suit.SPADE))
                .draw(Card.getInstance(Denomination.EIGHT, Suit.DIAMOND));

        // when
        final DeckState actual = deckState.draw(Card.getInstance(Denomination.EIGHT, Suit.SPADE));

        // then
        assertThat(actual).isInstanceOf(Bust.class);
    }

    @Test
    @DisplayName("Hit -> Blackjack")
    void drawBlackjackTest() {
        // given
        final DeckState deckState = new Hit()
                .draw(Card.getInstance(Denomination.KING, Suit.SPADE))
                .draw(Card.getInstance(Denomination.EIGHT, Suit.DIAMOND));

        // when
        final DeckState actual = deckState.draw(Card.getInstance(Denomination.THREE, Suit.SPADE));

        // then
        assertThat(actual).isInstanceOf(Blackjack.class);
    }

    @Test
    @DisplayName("Hit -> Stay")
    void stayTest() {
        // given
        final DeckState deckState = new Hit();

        // when
        final DeckState actual = deckState.stay();

        // then
        assertThat(actual).isInstanceOf(Stay.class);
    }
}