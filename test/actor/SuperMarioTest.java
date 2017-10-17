package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SuperMarioTest {

    @Test
    public void WhenMarioIsInitialized_ThenHeIsAliveAndSmall() throws Exception {
        IamSuperMario mario = new SmallMario();
        assertFalse(mario.isDead());
    }

    @Test
    public void WhenMarioWithMushroomIsHitByEnemy_ThenHeBecomesSmallMario() throws Exception {
        IamSuperMario mario = new MarioWithMushroom();

        mario = mario.isHitByEnemy();

        assertFalse(mario.hasMushroom());
    }

    @Test
    public void WhenSuperMarioStarts_ThenHeHasThreeLives() throws Exception {
        IamSuperMario mario = new SmallMario();

        assertEquals(3, mario.getLives());
    }

    @Test
    public void WhenSuperMarioDies_HeLosesALive() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.isHitByEnemy();

        assertEquals(2, mario.getLives());
    }

    @Test
    public void WhenSuperMarioHasUsedAllLives_ThenHeHeIsDead() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.isHitByEnemy();
        mario.isHitByEnemy();
        mario.isHitByEnemy();
        mario.isHitByEnemy();

        assertTrue(mario.isDead());
    }

    @Test
    public void WhenSuperMarioFindsALive_ThenHisNumberOfLivesAreIncreased() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.findsLive();

        assertEquals(4, mario.getLives());
    }

    @Test
    public void WhenDeadSuperMarioFindsLive_HeBecomesAliveAgain() throws Exception {
        IamSuperMario mario = new SmallMario();

        // kill Mario
        mario.isHitByEnemy();
        mario.isHitByEnemy();
        mario.isHitByEnemy();
        mario.isHitByEnemy();

        mario.findsLive();

        assertFalse(mario.isDead());
    }

    @Test
    public void WhenSuperMarioFindsAFireFlower_ThenHeGrows() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.findsFireFlower();

        assertTrue(mario.hasFireFlower());
    }

    @Test
    public void WhenMarioWithFireFlowerIsHitByEnemy_ThenHeBecomesMarioWithMushroom() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.findsFireFlower();
        mario.isHitByEnemy();

        assertTrue(mario.hasMushroom() && !mario.hasFireFlower());
    }

    @Test
    public void WhenSuperMarioWithFireFlowerFindsMushroom_ThenHeKeepsTheFireFlower() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.findsFireFlower();
        mario = mario.findsMushroom();

        assertTrue(mario.hasFireFlower() && !mario.hasMushroom());
    }

    @Test
    public void WhenSuperMarioFirstFindsMushroomAndThenFireFlowerFindsMushroom_ThenHeKeepsTheFireFlower()
            throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.findsMushroom();
        mario.findsFireFlower();
        mario.findsMushroom();

        assertTrue(mario.hasFireFlower() && !mario.hasMushroom());
    }

}
