package actor;

import java.util.function.Consumer;

import alive.IamAlive;

public class MarioWithYoshi implements IamSuperMario {

	private final IamSuperMario originalMario;

    public MarioWithYoshi(IamSuperMario abstractMario) {
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

	@Override
	public IamSuperMario findsLive() {
		return new MarioWithYoshi(originalMario.findsLive());
	}

	@Override
	public IamSuperMario findsStar() {
		return new MarioWithStar(this);
	}

	@Override
	public IamSuperMario findsYoshi() {
		return this;
	}

	@Override
	public IamSuperMario findCoins(int i) {
		return new MarioWithYoshi(originalMario.findCoins(i));
	}

	@Override
	public IamAlive getLife() {
		return originalMario.getLife();
	}

}
