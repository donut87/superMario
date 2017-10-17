package actor;

public class MarioWithFireFlower extends AbstractMario implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        return new MarioWithMushroom();
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public boolean hasMushroom() {
        return false;
    }

    @Override
    public IamSuperMario findsLive() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return this;
    }

    @Override
    public boolean hasFireFlower() {
        return true;
    }


}
