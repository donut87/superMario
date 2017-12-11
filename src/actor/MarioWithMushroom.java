package actor;

public class MarioWithMushroom extends AbstractMario implements IamSuperMario {

	public MarioWithMushroom(Life life) {
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
