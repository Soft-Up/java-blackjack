package card;

import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class CardTest {
    @Test
    @DisplayName("카드는 숫자랑 문양을 가진다.")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> Card.getInstance(Denomination.FIVE, Suit.CLOVER));
    }

    @Test
    @DisplayName("카드는 잘못된 값이 들어오면 예외를 발생시킨다.")
    void constructorExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Card.getInstance(null, Suit.CLOVER));
    }
}
