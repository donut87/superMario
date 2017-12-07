package actor;

public class MarioWithMushroom extends AbstractMario implements IamSuperMario {

    public MarioWithMushroom(int lives) {
		super(new Life(lives, 0));
    }

    public MarioWithMushroom() {
        this(3);
    }

    @Override
    public IamSuperMario isHitByEnemy() {
        return new SmallMario(getLives());
    }

    @Override
    public IamSuperMario findsMushroom() {
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithFireFlower(getLives());
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return new MarioWithIceFlower(getLives());
    }
}
