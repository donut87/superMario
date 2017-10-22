package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DeadMarioTest {
    
    IamSuperMario mario;

    @Before
    public void setup() {
        mario = new DeadMario();
    }

    @Test
    public void WhenDeadSuperMarioFindsLive_HeBecomesSmallMario() throws Exception {
        mario = mario.findsLive();

        assertTrue(SmallMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void DeadMarioHasNoLives() throws Exception {
        assertEquals(0, mario.getLives());
    }

    @Test
    public void WhenDeadMarioIsHitByEnemy_ThenHeStaysDead() throws Exception {
        mario = mario.isHitByEnemy();

        assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenDeadMarioFindsMushroom_ThenHeStaysDead() throws Exception {
        mario = mario.findsMushroom();

        assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenDeadMarioFindsFireFlower_ThenHeStaysDead() throws Exception {
        mario = mario.findsFireFlower();

        assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenDeadMarioFindsIceFlower_ThenHeStaysDead() throws Exception {
        mario = mario.findsIceFlower();

        assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
    }

}
