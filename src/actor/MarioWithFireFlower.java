package actor;

import java.util.function.Consumer;

import alive.Life;

public class MarioWithFireFlower extends AbstractMario implements IamSuperMario {

	public MarioWithFireFlower(Life life) {
		super(life);
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

}
