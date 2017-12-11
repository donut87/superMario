package actor;

import java.util.function.Consumer;

public abstract class AbstractMario implements IamSuperMario {

	private Life life;

	public AbstractMario(Life life) {
		this.life = life;
	}

    protected void increaseLive() {
		life = life.increase();
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
	public IamSuperMario findCoins(int i) {

		life = life.findCoins(i);
		return this;
	}

	@Override
	public Life getLife() {
		return this.life;
	}

}
