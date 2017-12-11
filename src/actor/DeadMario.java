package actor;

import java.util.function.Consumer;

import alive.IamAlive;
import alive.Life;

public class DeadMario implements IamSuperMario {

	private IamAlive life;

	public DeadMario(IamAlive life) {
		this.life = life;
	}

    public DeadMario() {
		this(new Life(0, 0));
    }

    @Override
    public IamSuperMario isHitByEnemy() {
        return this;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public IamSuperMario findsLive() {
		return new SmallMario(new Life(0, 0));
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return this;
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return this;
    }

    @Override
    public IamSuperMario shoot(Consumer<String> object) {
        return this;
    }

	@Override
	public IamSuperMario findsStar() {
		return this;
	}

	@Override
	public IamSuperMario findsYoshi() {
		return this;
	}

	@Override
	public IamSuperMario findCoins(int i) {
		return this;
	}

	@Override
	public IamAlive getLife() {
		return life;
	}
}
