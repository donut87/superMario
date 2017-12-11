package actor;

import java.util.function.Consumer;

import alive.IamAlive;
import alive.Life;

public class MarioWithIceFlower implements IamSuperMario {

	private IamAlive life;

	public MarioWithIceFlower(IamAlive life) {
		this.life = life;
	}

    public MarioWithIceFlower() {
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
		return new MarioWithFireFlower(getLife());
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return this;
    }

    @Override
    public IamSuperMario shoot(Consumer<String> object) {
        object.accept("Iceball");
        return this;
    }

	@Override
	public IamSuperMario findsLive() {
		return new MarioWithIceFlower(life.increase());
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
		return new MarioWithIceFlower(life.findCoins(i));
	}

	@Override
	public IamAlive getLife() {
		return life;
	}

}
