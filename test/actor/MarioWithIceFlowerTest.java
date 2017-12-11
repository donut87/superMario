package actor;

import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.Test;
import org.mockito.Mockito;

import alive.IamAlive;

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

    @Test
    @SuppressWarnings("unchecked")
    public void WhenSuperMarioWithFireFlowerGetsCommandForShooting_ThenHeShootsFireBall() throws Exception {
        IamSuperMario mario = new MarioWithIceFlower();
        Consumer<String> consumer = Mockito.mock(Consumer.class);

        mario = mario.shoot(consumer);

		Mockito.verify(consumer, Mockito.times(1)).accept("Iceball");
    }

	@Test
	public void WhenMarioWithIceFlowerFindsLive_ThenLivesIncrease() throws Exception {
		IamAlive life = Mockito.mock(IamAlive.class);
		new MarioWithIceFlower(life).findsLive();

		Mockito.verify(life, Mockito.times(1)).increase();
	}

	@Test
	public void WhenMarioWithFireFlowerFindsStar_ThenHeBecomesMarioWithStar() throws Exception {
		IamSuperMario mario = new MarioWithIceFlower().findsStar();
		
		assertTrue(MarioWithStar.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenMarioWithIceFlowerFindsAYoshi_ThenHeBecomesMarioWithYoshi() throws Exception {
		IamSuperMario mario = new MarioWithIceFlower().findsYoshi();

		assertTrue(MarioWithYoshi.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenSuperMarioWithIceFlowerFindsCoins_ThenCoinsAreIncreased() throws Exception {
		IamAlive life = Mockito.mock(IamAlive.class);
		new MarioWithIceFlower(life).findCoins(5);

		Mockito.verify(life, Mockito.times(1)).findCoins(5);
	}
}
