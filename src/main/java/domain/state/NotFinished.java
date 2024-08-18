package domain.state;

public abstract class NotFinished implements DeckState {
    @Override
    public boolean isFinished() {
        return false;
    }
}
