package actor;

import alive.IamAlive;
import alive.Life;

public class MarioWithMushroom extends AbstractMario implements IamSuperMario {

	public MarioWithMushroom(IamAlive life) {
		super(life);
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
}
