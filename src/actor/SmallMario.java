package actor;

public class SmallMario extends AbstractMario implements IamSuperMario {

    public SmallMario(int i) {
		super(new Life(i, 0));
    }

    public SmallMario() {
        this(3);
    }

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
        return new MarioWithMushroom(getLives());
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
