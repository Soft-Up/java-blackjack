package state;

import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suit;
import domain.state.DeckState;
import domain.state.Stay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class StayTest {
    @Test
    @DisplayName("Stay은 갈 수 있는 상태가 없다.")
    void drawTest() {
        // given
        final DeckState deckState = new Stay();

        // when & then
        assertThatIllegalStateException().isThrownBy(() -> deckState.draw(Card.getInstance(Denomination.EIGHT, Suit.SPADE)));
    }

    @Test
    @DisplayName("Stay은 갈 수 있는 상태가 없다.")
    void stayTest() {
        // given
        final DeckState deckState = new Stay();

        // when & then
        assertThatIllegalStateException().isThrownBy(deckState::stay);
    }

    @Test
    @DisplayName("Stay은 갈 수 있는 상태가 없다.")
    void isFinishedTest() {
        assertThat(new Stay().isFinished()).isTrue();
    }
}