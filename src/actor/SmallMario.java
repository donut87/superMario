package actor;

import java.util.function.Consumer;

import alive.IamAlive;
import alive.Life;

public class SmallMario implements IamSuperMario {

	private IamAlive life;

	public SmallMario(IamAlive life) {
		this.life = life;
	}

    public SmallMario() {
		this(new Life(3, 0));
    }

    @Override
    public IamSuperMario isHitByEnemy() {
		return this.getLife().decrease();
    }

    @Override
    public IamSuperMario findsMushroom() {
		return new MarioWithMushroom(getLife());
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
		return new SmallMario(life.increase());
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
		return new SmallMario(life.findCoins(i));
	}

	@Override
	public IamAlive getLife() {
		return life;
	}
}
