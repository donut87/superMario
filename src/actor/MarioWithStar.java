package actor;

public class MarioWithStar extends AbstractMario {

    private IamSuperMario originalMario;

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
        originalMario = originalMario.findsMushroom();
        return this;
    }

    @Override
    public IamSuperMario findsFireFlower() {
        originalMario = originalMario.findsFireFlower();
        return this;
    }

    @Override
    public IamSuperMario findsIceFlower() {
        originalMario = originalMario.findsIceFlower();
        return this;
    }

    @Override
    public IamSuperMario findsStar() {
        return this;
    }

    public IamSuperMario getOriginalMario() {
        return originalMario;
    }

}
