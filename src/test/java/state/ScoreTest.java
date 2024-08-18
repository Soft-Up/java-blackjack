package state;

import domain.state.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class ScoreTest {
    @Test
    @DisplayName("Score 생성자 테스트")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> new Score(0));
    }
}
