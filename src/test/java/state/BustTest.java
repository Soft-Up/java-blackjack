package state;

import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suit;
import domain.state.Bust;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThat;

class BustTest {
    @Test
    @DisplayName("Bust은 갈 수 있는 상태가 없다.")
    void drawTest() {
        assertThatIllegalStateException().isThrownBy(() -> new Bust().draw(Card.getInstance(Denomination.EIGHT, Suit.DIAMOND)));
    }

    @Test
    @DisplayName("Bust은 갈 수 있는 상태가 없다.")
    void stayTest() {
        assertThatIllegalStateException().isThrownBy(() -> new Bust().stay());
    }

    @Test
    @DisplayName("Bust은 갈 수 있는 상태가 없다.")
    void isFinishedTest() {
        assertThat(new Bust().isFinished()).isTrue();
    }
}