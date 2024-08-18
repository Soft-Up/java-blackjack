package domain.card;

import java.util.Arrays;
import java.util.List;

public class Card {
    private static final List<Card> INSTANCES;

    private final Denomination denomination;

    private final Suit suit;

    static {
        INSTANCES = Arrays.stream(Denomination.values()).flatMap(denominationElement ->
                Arrays.stream(Suit.values()).map(suitElement -> new Card(denominationElement, suitElement))
        ).toList();
    }

    private Card(
            final Denomination denomination,
            final Suit suit
    ) {
        validate(denomination, suit);

        this.denomination = denomination;
        this.suit = suit;
    }

    private void validate(
            final Denomination denomination,
            final Suit suit
    ) {
        if (denomination == null || suit == null) {
            throw new IllegalArgumentException("값이 null 입니다.");
        }
    }

    public boolean isAce() {
        return denomination.isAce();
    }

    public int getScore() {
        return denomination.getScore();
    }

    public static Card getInstance(
            final Denomination denomination,
            final Suit suit
    ) {
        return INSTANCES.stream()
                .filter(value -> value.denomination == denomination && value.suit == suit)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 값이 없습니다."));
    }
}
