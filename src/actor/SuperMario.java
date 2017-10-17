package actor;

public class SuperMario {

    private boolean isDead;
    private boolean isBig;
    private int lives = 3;

    public void isHitByEnemy() {
        if (isBig) {
            isBig = false;
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
        isBig = true;
    }

    public boolean isBig() {
        return isBig;
    }

    public int getLives() {
        return lives;
    }

}
