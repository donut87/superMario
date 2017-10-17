package actor;

public abstract class AbstractMario implements IamSuperMario {

    private int lives = 3;

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

}
