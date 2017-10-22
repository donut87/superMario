package actor;

import java.util.function.Consumer;

public class MarioWithFireFlower extends AbstractMario implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        return new MarioWithMushroom();
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
        return new MarioWithIceFlower();
    }

    @Override
    public IamSuperMario shoot(Consumer<String> c) {
        c.accept("Fireball");
        return this;
    }

}
