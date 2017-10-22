package actor;

public class MarioWithIceFlower extends AbstractMario implements IamSuperMario {

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
        return new MarioWithFireFlower();
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return this;
    }

}
