package actor;

public class SuperMario {

    public enum MarioState {
        DEAD, SMALL, MUSHROOM, FIREFLOWER
    }

    private MarioState state;

    private int lives = 3;

    public SuperMario() {
        state = MarioState.SMALL;
        lives = 3;
    }

    public void isHitByEnemy() {
        if (hasMushroom()) {
            state = MarioState.SMALL;
            return;
        }
        if (hasFireFlower()) {
            state = MarioState.MUSHROOM;
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
        if (!hasFireFlower()) {
            state = MarioState.MUSHROOM;
        }
    }

    public boolean hasMushroom() {
        return MarioState.MUSHROOM.equals(state);
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
        state = MarioState.FIREFLOWER;
    }

    public boolean hasFireFlower() {
        return MarioState.FIREFLOWER.equals(state);
    }

}
