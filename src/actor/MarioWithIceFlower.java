package actor;

import java.util.function.Consumer;

public class MarioWithIceFlower extends AbstractMario implements IamSuperMario {

    public MarioWithIceFlower(int lives) {
		super(new Life(lives, 0));
    }

    public MarioWithIceFlower() {
        this(3);
    }

    @Override
    public IamSuperMario isHitByEnemy() {
        return new MarioWithMushroom(getLives());
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithFireFlower(getLives());
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
