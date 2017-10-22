package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.Test;
import org.mockito.Mockito;

public class SmallMarioTest {

    @Test
    public void WhenSmallMarioFindsMushroom_ThenHeBecomesMarioWithMushroom() throws Exception {
        IamSuperMario mario = new SmallMario();
        mario = mario.findsMushroom();
        assertTrue(MarioWithMushroom.class.isAssignableFrom(mario.getClass()));
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
    public void WhenSuperMarioFindsAFireFlower_ThenHeGrows() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.findsFireFlower();

        assertTrue(MarioWithFireFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioFindsIceFlower_ThenHeBecomesMarioWithIceFlower() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.findsIceFlower();

        assertTrue(MarioWithIceFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSmallMarioGetsCommandToShoot_ThenNothingHappens() throws Exception {
        IamSuperMario mario = new SmallMario();

        Consumer<String> consumer = Mockito.mock(Consumer.class);
        mario.shoot(consumer);

        Mockito.verify(consumer, Mockito.never()).accept(Mockito.anyString());
    }
}
