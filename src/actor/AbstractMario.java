package actor;

import java.util.function.Consumer;

import alive.IamAlive;

public abstract class AbstractMario implements IamSuperMario {

	private IamAlive life;

	public AbstractMario(IamAlive life) {
		this.life = life;
	}

    @Override
    public IamSuperMario findsLive() {
        life = life.increase();
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
	public IamAlive getLife() {
		return this.life;
	}

}
