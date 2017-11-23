package actor;

import java.util.function.Consumer;

public class DeadMario extends AbstractMario implements IamSuperMario {

    public DeadMario(int lives) {
        super(lives);
    }

    public DeadMario() {
        this(0);
    }

    @Override
    public IamSuperMario isHitByEnemy() {
        return this;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public int getLives() {
        return 0;
    }

    @Override
    public IamSuperMario findsLive() {
        return new SmallMario(0);
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return this;
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return this;
    }

    @Override
    public IamSuperMario shoot(Consumer<String> object) {
        return this;
    }
}
