package actor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.Test;
import org.mockito.Mockito;

public class MarioWithYoshiTest {

    @Test
    public void WhenMarioFindsYoshi_ThenHeBecomesMarioWithYoshi() throws Exception {
        IamSuperMario mario = new SmallMario();

        mario = mario.findsYoshi();

        assertTrue(MarioWithYoshi.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void WhenMarioWithYoshiShoots_ThenDelegateShoots() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.shoot(Mockito.any())).thenReturn(delegate);
        IamSuperMario mario = new MarioWithYoshi(delegate);

        Consumer<String> object = Mockito.mock(Consumer.class);

        mario = mario.shoot(object);

        Mockito.verify(delegate, Mockito.times(1)).shoot(object);
    }

    @Test
    public void WhenMarioWithYoshiIsHitByEnemy_ThenHeLosesYoshi() throws Exception {
        IamSuperMario delegate = new MarioWithMushroom();
        IamSuperMario mario = new MarioWithYoshi(delegate);

        mario = mario.isHitByEnemy();

        assertTrue(delegate.getClass().isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithYoshiFindsMushroom_ThenRulesForFindingMushroomsApply() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsMushroom()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithYoshi(delegate);

        mario = mario.findsMushroom();

        Mockito.verify(delegate, Mockito.times(1)).findsMushroom();
    }

    @Test
    public void WhenMarioWithYoshiFindsFireFlower_ThenRulesForFindingFireFlowersApply() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsFireFlower()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithYoshi(delegate);

        mario = mario.findsFireFlower();

        Mockito.verify(delegate, Mockito.times(1)).findsFireFlower();
    }

    @Test
    public void WhenMarioWithYoshiFindsIceFlower_ThenRulesForFindingIveFlowersApply() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsIceFlower()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithYoshi(delegate);

        mario = mario.findsIceFlower();

        Mockito.verify(delegate, Mockito.times(1)).findsIceFlower();
    }

	@Test
	public void WhenMarioWithYoshiFindsCoins_ThenDelegateFindsCoins() throws Exception {
		IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
		IamSuperMario mario = new MarioWithYoshi(delegate);

		mario = mario.findCoins(5);

		Mockito.verify(delegate, Mockito.times(1)).findCoins(5);
	}

	@Test
	public void WhenMarioWithYoshiFindsLife_ThenDelegateFindsLife() throws Exception {
		IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
		IamSuperMario mario = new MarioWithYoshi(delegate);

		mario = mario.findsLive();

		Mockito.verify(delegate, Mockito.times(1)).findsLive();
	}

	@Test
	public void WhenMarioWithYoshiFindsYoshi_ThenNothingHappens() throws Exception {
		IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
		IamSuperMario mario = new MarioWithYoshi(delegate);

		IamSuperMario mario2 = mario.findsYoshi();

		assertEquals(mario, mario2);
	}

	@Test
	public void WhenMarioWithYoshiFindsStar_ThenMarioBecomesMarioWithStar() throws Exception {
		IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
		IamSuperMario mario = new MarioWithYoshi(delegate);

		mario = mario.findsStar();

		assertTrue(MarioWithStar.class.isAssignableFrom(mario.getClass()));
	}

}
