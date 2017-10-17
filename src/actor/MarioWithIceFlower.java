package actor;

public class MarioWithIceFlower implements IamSuperMario {

    @Override
    public IamSuperMario isHitByEnemy() {
        return new MarioWithMushroom();
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public int getLives() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public IamSuperMario findsLive() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithFireFlower();
    }

    @Override
    public IamSuperMario findsIceFlower() {
        // TODO Auto-generated method stub
        return null;
    }

}
