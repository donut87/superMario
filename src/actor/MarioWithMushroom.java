package actor;

import java.util.function.Consumer;

import alive.IamAlive;
import alive.Life;

public class MarioWithMushroom implements IamSuperMario {

	private IamAlive life;

	public MarioWithMushroom(IamAlive life) {
		this.life = life;
	}

    public MarioWithMushroom() {
		this(new Life(3, 0));
    }

    @Override
    public IamSuperMario isHitByEnemy() {
		return new SmallMario(getLife());
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
		return new MarioWithFireFlower(getLife());
    }

    @Override
    public IamSuperMario findsIceFlower() {
		return new MarioWithIceFlower(getLife());
    }

	@Override
	public IamSuperMario findsLive() {
		return new MarioWithMushroom(life.increase());
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
		return new MarioWithFireFlower(life.findCoins(i));
	}

	@Override
	public IamAlive getLife() {
		return life;
	}
}
