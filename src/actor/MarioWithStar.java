package actor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class MarioWithStar extends AbstractMario {

    private final IamSuperMario originalMario;
    private boolean isProtected = true;

    public MarioWithStar(IamSuperMario originalMario) {
		super(new Life(originalMario.getLives(), originalMario.getCoinBallance()));
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

}
