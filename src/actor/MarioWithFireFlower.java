package actor;

import java.util.function.Consumer;

public class MarioWithFireFlower extends AbstractMario implements IamSuperMario {

    public MarioWithFireFlower(int lives) {
        super(lives);
    }

    public MarioWithFireFlower() {
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
        return this;
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return new MarioWithIceFlower(getLives());
    }

    @Override
    public IamSuperMario shoot(Consumer<String> c) {
        c.accept("Fireball");
        return this;
    }

}
