package actor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MarioWithIceFlowerTest {
    @Test
    public void WhenSuperMarioWithIceFlowerIsHitByEnemy_ThenHeBecomesMarioWithMushroom() throws Exception {
        IamSuperMario mario = new MarioWithIceFlower();

        mario = mario.isHitByEnemy();

        assertTrue(MarioWithMushroom.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioWithIceFlowerFindsMushroom_ThenHeKeepsTheIceFlower() throws Exception {
        IamSuperMario mario = new MarioWithIceFlower();

        mario = mario.findsMushroom();

        assertTrue(MarioWithIceFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioWithIceFlowerFindsFireFlower_ThenHeSwitchesToTheFireFlower() throws Exception {
        IamSuperMario mario = new MarioWithIceFlower();

        mario = mario.findsFireFlower();

        assertTrue(MarioWithFireFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenSuperMarioWithIceFlowerFindsIceFlower_ThenHeStaysSuperMarioWithIceFlower() throws Exception {
        IamSuperMario mario = new MarioWithIceFlower();

        mario = mario.findsIceFlower();

        assertTrue(MarioWithIceFlower.class.isAssignableFrom(mario.getClass()));
    }
}
