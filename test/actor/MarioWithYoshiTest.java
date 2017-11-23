package actor;

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

}
