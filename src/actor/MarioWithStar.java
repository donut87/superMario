package actor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import alive.IamAlive;

public class MarioWithStar implements IamSuperMario {

	private IamSuperMario originalMario;
    private boolean isProtected = true;

    public MarioWithStar(IamSuperMario originalMario) {
        this.originalMario = originalMario;

        looseStarAfterOneSecond();
    }

    private void looseStarAfterOneSecond() {
        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                isProtected = false;
            }
        }, 1, TimeUnit.SECONDS);
    }


    @Override
    public IamSuperMario isHitByEnemy() {
        if (isProtected) {
            return this;
        } else {
            return this.originalMario.isHitByEnemy();
        }
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

    @Override
    public IamSuperMario shoot(Consumer<String> object) {
        return originalMario.shoot(object);
    }

	@Override
	public IamSuperMario findsLive() {
		originalMario = originalMario.findsLive();
		return this;
	}

	@Override
	public IamSuperMario findsYoshi() {
		originalMario = originalMario.findsYoshi();
		return this;
	}

	@Override
	public IamSuperMario findCoins(int i) {
		originalMario = originalMario.findCoins(i);
		return this;
	}

	@Override
	public IamAlive getLife() {
		return originalMario.getLife();
	}

}
