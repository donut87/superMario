package actor;

import java.util.function.Consumer;

public abstract class AbstractMario implements IamSuperMario {

	private Life life;

	// new Life(lives, 0)

	public AbstractMario(Life life) {
		this.life = life;
	}

    @Override
    public int getLives() {
		return life.getLives();
    }

    protected void increaseLive() {
		life = life.increase();
    }

    protected void decreaseLive() {
		life = life.decrease();
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
		return life.getCoins();
	}

	@Override
	public IamSuperMario findCoins(int i) {

		life = life.findCoins(i);
		return this;
	}

}
