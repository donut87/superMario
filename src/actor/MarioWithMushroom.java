package actor;

public class MarioWithMushroom extends AbstractMario implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        return new SmallMario();
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public IamSuperMario findsLive() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithFireFlower();
    }
}
