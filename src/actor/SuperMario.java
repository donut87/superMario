package actor;

public class SuperMario implements IamSuperMario {

    private boolean isDead;
    private boolean hasMushroom;
    private int lives = 3;
    private boolean fireFlower;

    @Override
    public void isHitByEnemy() {
        if (hasMushroom) {
            hasMushroom = false;
            return;
        }
        if (fireFlower) {
            hasMushroom = true;
            fireFlower = false;
            return;
        }
        lives -= 1;
        if (lives < 0) {
            isDead = true;
        }
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void findsMushroom() {
        if (!fireFlower) {
            hasMushroom = true;
        }
    }

    @Override
    public boolean hasMushroom() {
        return hasMushroom;
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public void findsLive() {
        if (isDead) {
            isDead = false;
        }
        lives++;
    }

    @Override
    public void findsFireFlower() {
        hasMushroom = false;
        this.fireFlower = true;
    }

    @Override
    public boolean hasFireFlower() {
        return fireFlower;
    }

}
