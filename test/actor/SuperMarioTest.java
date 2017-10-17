package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class SuperMarioTest {

    @Test
    public void WhenMarioIsInitialized_ThenHeIsAliveAndSmall() throws Exception {
        IamSuperMario mario = new SmallMario();
        assertFalse(mario.isDead());
    }

    @Test
    public void WhenSmallMarioFindsMushroom_ThenHeBecomesMarioWithMushroom() throws Exception {
        IamSuperMario mario = new SmallMario();
        mario = mario.findsMushroom();
        assertTrue(MarioWithMushroom.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithMushroomIsHitByEnemy_ThenHeBecomesSmallMario() throws Exception {
        IamSuperMario mario = new MarioWithMushroom();

        mario = mario.isHitByEnemy();

        assertTrue(SmallMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioStarts_ThenHeHasThreeLives() throws Exception {
        IamSuperMario mario = new SmallMario();

        assertEquals(3, mario.getLives());
    }

    @Test
    public void WhenSuperMarioDies_HeLosesALive() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.isHitByEnemy();

        assertEquals(2, mario.getLives());
    }

    @Test
    public void WhenSuperMarioHasUsedAllLives_ThenHeHeIsDead() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.isHitByEnemy();
        mario = mario.isHitByEnemy();
        mario = mario.isHitByEnemy();
        mario = mario.isHitByEnemy();

        assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioFindsALive_ThenHisNumberOfLivesAreIncreased() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario.findsLive();

        assertEquals(4, mario.getLives());
    }

    @Test
    public void WhenDeadSuperMarioFindsLive_HeBecomesSmallMario() throws Exception {
        IamSuperMario mario = new DeadMario();

        mario = mario.findsLive();

        assertTrue(SmallMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioFindsAFireFlower_ThenHeGrows() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.findsFireFlower();

        assertTrue(MarioWithFireFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithFireFlowerIsHitByEnemy_ThenHeBecomesMarioWithMushroom() throws Exception {
        IamSuperMario mario = new MarioWithFireFlower();

        mario = mario.isHitByEnemy();

        assertTrue(MarioWithMushroom.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioWithFireFlowerFindsMushroom_ThenHeKeepsTheFireFlower() throws Exception {
        IamSuperMario mario = new MarioWithFireFlower();

        mario = mario.findsMushroom();

        assertTrue(MarioWithFireFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Ignore
    @Test
    public void WhenSuperMarioFindsIceFlower_ThenHeBecomesMarioWithIceFlower() throws Exception {
        IamSuperMario mario = new SmallMario();

        // mario.findsIceFlower();

    }
}
