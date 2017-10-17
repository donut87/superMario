package actor;

public class SuperMario {

    public enum MarioState {
        DEAD, SMALL, MUSHROOM, FIREFLOWER
    }

    private MarioState state;

    private boolean hasMushroom;
    private int lives = 3;
    private boolean fireFlower;

    public SuperMario() {
        state = MarioState.SMALL;
        lives = 3;
    }

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
            state = MarioState.DEAD;
        }
    }

    public boolean isDead() {
        return MarioState.DEAD.equals(state);
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
        if (isDead()) {
            state = MarioState.SMALL;
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
