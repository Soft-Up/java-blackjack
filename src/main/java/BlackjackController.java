import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suit;
import domain.state.DeckState;
import domain.state.DeckStateFactory;
import domain.user.Player;

import java.math.BigInteger;
import java.util.List;

public class BlackjackController {
    public void startGame() {
        final List<Player> players = List.of("pobi","jason")
                .stream()
                .map(name -> {
                    final Card firstCard = Card.getInstance(Denomination.EIGHT, Suit.SPADE);
                    final Card secondCard = Card.getInstance(Denomination.THREE, Suit.SPADE);
                    final DeckState initialState = DeckStateFactory.getInstanceWhenGameStart(
                            firstCard,
                            secondCard
                    );
                    return new Player(name, initialState);
                })
                .toList();

        BigInteger
        for (final Player player : players) {
            while(!player.isFinished()) {
                fianl boolean result = InputView.getMoreCard();

                if (result) {
                    player.draw(randomCard());
                }
            }
        }

        //
    }
}
