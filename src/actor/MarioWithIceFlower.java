package actor;

import java.util.function.Consumer;

import alive.Life;

public class MarioWithIceFlower extends AbstractMario implements IamSuperMario {

	public MarioWithIceFlower(Life life) {
		super(life);
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

}
