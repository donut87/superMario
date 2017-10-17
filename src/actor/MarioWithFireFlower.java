package actor;

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

}
