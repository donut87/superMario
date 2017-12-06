package actor;

import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.Test;
import org.mockito.Mockito;

public class MarioWithFireFlowerTest {

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

    @Test
    public void WhenSuperMarioWithFireFlowerFindsIceFlower_ThenHeSwitchesToTheIceFlower() throws Exception {
        IamSuperMario mario = new MarioWithFireFlower();

        mario = mario.findsIceFlower();

        assertTrue(MarioWithIceFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioWithFireFlowerFindsFireFlower_ThenHeStaysMarioWithFireFlower() throws Exception {
        IamSuperMario mario = new MarioWithFireFlower();

        mario = mario.findsFireFlower();

        assertTrue(MarioWithFireFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void WhenSuperMarioWithFireFlowerGetsCommandForShooting_ThenHeShootsFireBall() throws Exception {
        IamSuperMario mario = new MarioWithFireFlower();
        Consumer<String> consumer = Mockito.mock(Consumer.class);

        mario = mario.shoot(consumer);

        Mockito.verify(consumer, Mockito.atLeastOnce()).accept(Mockito.any(String.class));
        Mockito.verify(consumer, Mockito.atMost(1)).accept(Mockito.any(String.class));
    }
}
