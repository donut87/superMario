package actor;

import java.util.function.Consumer;

import alive.IamAlive;
import alive.Life;

public class MarioWithFireFlower implements IamSuperMario {

	private IamAlive life;

	public MarioWithFireFlower(IamAlive life) {
		this.life = life;
	}

    public MarioWithFireFlower() {
		this(new Life(3, 0));
    }

    @Override
    public IamSuperMario isHitByEnemy() {
		return new MarioWithMushroom(getLife());
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return this;
    }

    @Override
    public IamSuperMario findsIceFlower() {
		return new MarioWithIceFlower(getLife());
    }

    @Override
    public IamSuperMario shoot(Consumer<String> c) {
        c.accept("Fireball");
        return this;
    }

	@Override
	public IamSuperMario findsLive() {
		return new MarioWithFireFlower(life.increase());
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
