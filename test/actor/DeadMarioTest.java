package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import alive.IamAlive;

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
		assertEquals(0, mario.getLife().getLives());
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

    @Test
    public void WhenDeadMarioFindsLive_ThenHeIsSmallAndHasZeroLives() throws Exception {
        mario = mario.findsLive();

		assertEquals(0, mario.getLife().getLives());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void WhenDeadMarioFires_ThenNothingHappens() throws Exception {
        Consumer<String> consumer = Mockito.mock(Consumer.class);
        mario.shoot(consumer);

        Mockito.verify(consumer, Mockito.never()).accept(Mockito.anyString());
    }

	@Test
	public void WhenDeadMarioFindsStar_ThenHeStaysDead() throws Exception {
		mario = mario.findsStar();

		assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenDeadMarioFindsYoshi_ThenHeStaysDead() throws Exception {
		mario = mario.findsYoshi();

		assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenDeadMarioFindsCoin_ThenHeStaysDead() throws Exception {
		mario = mario.findCoins(1);

		assertTrue(DeadMario.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenDeadMarioFindsCoins_CoinsAreNotCollected() throws Exception {
		IamAlive life = Mockito.mock(IamAlive.class);
		IamSuperMario mario = new DeadMario(life);

		mario.findCoins(2);

		Mockito.verify(life, Mockito.never()).findCoins(Mockito.anyInt());
	}

}
