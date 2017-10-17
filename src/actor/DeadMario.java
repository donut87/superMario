package actor;

public class DeadMario implements IamSuperMario {

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
        return new SmallMario();
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return this;
    }
}
