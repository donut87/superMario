package actor;

public class MarioWithMushroom extends AbstractMario implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        return new SmallMario();
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
        return true;
    }

    @Override
    public IamSuperMario findsLive() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithFireFlower();
    }

    @Override
    public boolean hasFireFlower() {
        return false;
    }


}
