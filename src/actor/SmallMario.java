package actor;

public class SmallMario extends AbstractMario implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        decreaseLive();
        if (getLives() < 0) {
            return new DeadMario();
        }
        return this;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return new MarioWithMushroom();
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithFireFlower();
    }
}
