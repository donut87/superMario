package actor;

public class MarioWithStar extends AbstractMario {

    private final IamSuperMario originalMario;

    public MarioWithStar(IamSuperMario originalMario) {
        super(originalMario.getLives());
        this.originalMario = originalMario;
    }


    @Override
    public IamSuperMario isHitByEnemy() {
        return this;
    }

    @Override
    public IamSuperMario findsMushroom() {
        return new MarioWithStar(originalMario.findsMushroom());
    }

    @Override
    public IamSuperMario findsFireFlower() {
        return new MarioWithStar(originalMario.findsFireFlower());
    }

    @Override
    public IamSuperMario findsIceFlower() {
        return new MarioWithStar(originalMario.findsIceFlower());
    }

    @Override
    public IamSuperMario findsStar() {
        return this;
    }

    public IamSuperMario getOriginalMario() {
        return originalMario;
    }

}
