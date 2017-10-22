package actor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MarioWithMushroomTest {

    private IamSuperMario mario;

    @Before
    public void setup() {
        this.mario = new MarioWithMushroom();
    }

    @Test
    public void WhenMarioWithMushroomIsHitByEnemy_ThenHeBecomesSmallMario() throws Exception {
        mario = mario.isHitByEnemy();

        assertTrue(SmallMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithMushroomFindsAMushroom_ThenHeStaysMarioWithMushroom() throws Exception {
        mario = mario.findsMushroom();

        assertTrue(MarioWithMushroom.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithMushroomFindsFireFlower_ThenHeBecomesMarioWithFireFlower() throws Exception {
        mario = mario.findsFireFlower();

        assertTrue(MarioWithFireFlower.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithMushroomFindsIceFlower_ThenHeBecomesMarioWithIceFlower() throws Exception {
        mario = mario.findsIceFlower();

        assertTrue(MarioWithIceFlower.class.isAssignableFrom(mario.getClass()));
    }
}
