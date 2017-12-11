package actor;

import alive.Life;

public class SmallMario extends AbstractMario implements IamSuperMario {

	public SmallMario(Life life) {
		super(life);
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
}
