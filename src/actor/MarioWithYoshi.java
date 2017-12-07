package actor;

import java.util.function.Consumer;

public class MarioWithYoshi extends AbstractMario implements IamSuperMario {

    private final IamSuperMario originalMario;

    public MarioWithYoshi(IamSuperMario abstractMario) {
		super(new Life(abstractMario.getLives(), abstractMario.getCoinBallance()));
        this.originalMario = abstractMario;
    }

    @Override
    public IamSuperMario shoot(Consumer<String> object) {
        return originalMario.shoot(object);
    }

    @Override
    public IamSuperMario isHitByEnemy() {
        return this.originalMario;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return new MarioWithYoshi(originalMario.findsMushroom());
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithYoshi(originalMario.findsFireFlower());
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return new MarioWithYoshi(originalMario.findsIceFlower());
    }

}
