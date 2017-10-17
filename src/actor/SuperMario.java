package actor;

public class SuperMario {

    private boolean isDead;
    private boolean hasMushroom;
    private int lives = 3;
    private boolean fireFlower;

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

    public boolean isDead() {
        return isDead;
    }

    public void findsMushroom() {
        if (!fireFlower) {
            hasMushroom = true;
        }
    }

    public boolean hasMushroom() {
        return hasMushroom;
    }

    public int getLives() {
        return lives;
    }

    public void findsLive() {
        if (isDead) {
            isDead = false;
        }
        lives++;
    }

    public void findsFireFlower() {
        hasMushroom = false;
        this.fireFlower = true;
    }

    public boolean hasFireFlower() {
        return fireFlower;
    }

}
