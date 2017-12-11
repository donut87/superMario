package actor;

import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import alive.IamAlive;

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

	@Test
	public void WhenMarioWithMushroomFindsALive_ThenHeKeepsTheMushroom() throws Exception {
		mario = mario.findsLive();

		assertTrue(MarioWithMushroom.class.isAssignableFrom(mario.getClass()));

	}

	@Test
	public void WhenMarioWithMushroomFindsALive_ThenHisLivesAreIncreased() throws Exception {
		IamAlive life = Mockito.mock(IamAlive.class);
		new MarioWithMushroom(life).findsLive();

		Mockito.verify(life, Mockito.times(1)).increase();

	}

	@Test
	@SuppressWarnings("unchecked")
	public void WhenMarioWithMushroomGetsCommandToShoot_ThenNothingHappens() throws Exception {
		IamSuperMario mario = new MarioWithMushroom();

		Consumer<String> consumer = Mockito.mock(Consumer.class);
		mario.shoot(consumer);

		Mockito.verify(consumer, Mockito.never()).accept(Mockito.anyString());
	}

	@Test
	public void WhenMarioWithMushroomFindsStar_HeBecomesMarioWithStar() throws Exception {
		mario = mario.findsStar();

		assertTrue(MarioWithStar.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenMarioWithMushroomFindsYoshi_HeBecomesMarioWithYoshi() throws Exception {
		mario = mario.findsYoshi();

		assertTrue(MarioWithYoshi.class.isAssignableFrom(mario.getClass()));
	}

	@Test
	public void WhenMarioWithMushroomFindsCoins_ThenHisCoinsAreIncreased() throws Exception {
		IamAlive life = Mockito.mock(IamAlive.class);
		new MarioWithMushroom(life).findCoins(3);

		Mockito.verify(life, Mockito.times(1)).findCoins(3);

	}
}
