package actor;

import java.util.function.Consumer;

public abstract class AbstractMario implements IamSuperMario {

    private int lives = 3;
	private int coins = 0;

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

    @Override
    public IamSuperMario findsStar() {
        return new MarioWithStar(this);
    }

    @Override
    public IamSuperMario findsYoshi() {
        return new MarioWithYoshi(this);
    }

	@Override
	public int getCoinBallance() {
		return this.coins;
	}

	@Override
	public IamSuperMario findCoins(int i) {
		coins += i;
		if (coins >= 100) {
			lives++;
			coins -= 100;
		}
		return this;
	}

}
