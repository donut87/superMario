package actor;

import java.util.function.Consumer;

public abstract class AbstractMario implements IamSuperMario {

    private int lives = 3;

    public AbstractMario(int lives) {
        this.lives = lives;
    }

    @Override
    public int getLives() {
        return lives;
    }

    protected void increaseLive() {
        lives++;
    }

    protected void decreaseLive() {
        lives--;
    }

    @Override
    public IamSuperMario findsLive() {
        increaseLive();
        return this;
    }

    @Override
    public IamSuperMario shoot(Consumer<String> object) {
        return this;
    }

}
