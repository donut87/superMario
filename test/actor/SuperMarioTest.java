package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SuperMarioTest {

    @Test
    public void WhenMarioIsInitialized_ThenHeIsAlive() throws Exception {
        SuperMario mario = new SuperMario();
        assertFalse(mario.isDead());
    }

    @Test
    public void WhenMarioFindsMushroom_ThenHeIsBig() throws Exception {
        SuperMario mario = new SuperMario();
        mario.findsMushroom();
        assertTrue(mario.isBig());
    }

    @Test
    public void WhenBigMarioIsHitByEnemy_ThenHeBecomesSmallMario() throws Exception {
        SuperMario mario = new SuperMario();
        mario.findsMushroom();

        mario.isHitByEnemy();

        assertFalse(mario.isBig());
    }

    @Test
    public void WhenSuperMarioStarts_ThenHeHasThreeLives() throws Exception {
        SuperMario mario = new SuperMario();

        assertEquals(3, mario.getLives());
    }

    @Test
    public void WhenSuperMarioDies_HeLosesALive() throws Exception {
        SuperMario mario = new SuperMario();

        mario.isHitByEnemy();

        assertEquals(2, mario.getLives());
    }

    @Test
    public void WhenSuperMarioHasUsedAllLives_ThenHeHeIsDead() throws Exception {
        SuperMario mario = new SuperMario();

        mario.isHitByEnemy();
        mario.isHitByEnemy();
        mario.isHitByEnemy();
        mario.isHitByEnemy();

        assertTrue(mario.isDead());
    }

    @Test
    public void WhenSuperMarioFindsALive_ThenHisNumberOfLivesAreIncreased() throws Exception {
        SuperMario mario = new SuperMario();

        mario.findsLive();

        assertEquals(4, mario.getLives());
    }

    @Test
    public void WhenDeadSuperMarioFindsLive_HeBecomesAliveAgain() throws Exception {
        SuperMario mario = new SuperMario();

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
        SuperMario mario = new SuperMario();

        mario.findsFireFlower();

        assertTrue(mario.hasFireFlower());
    }

    @Test
    public void WhenMarioWithFireFlowerIsHitByEnemy_ThenHeBecomesBigMario() throws Exception {
        SuperMario mario = new SuperMario();

        mario.findsFireFlower();
        mario.isHitByEnemy();

        assertTrue(mario.isBig() && !mario.hasFireFlower());
    }

    @Test
    public void WhenSuperMarioWithFireFlowerFindsMushroom_ThenHeKeepsTheFireFlower() throws Exception {
        SuperMario mario = new SuperMario();
        
        mario.findsFireFlower();
        mario.findsMushroom();
        
        assertTrue(mario.hasFireFlower() && !mario.isBig());
    }

}
