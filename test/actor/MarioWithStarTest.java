package actor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class MarioWithStarTest {

    @Test
    public void WhenSmallMarioFindsStar_ThenHeBecomesSmallMarioWithStar() {
        IamSuperMario mario = new SmallMario();
        mario = mario.findsStar();

        assertTrue(MarioWithStar.class.isAssignableFrom(mario.getClass()));
    }

    @Test
    public void WhenMarioWithStarIsHitByEnemy_ThenHisOriginalTypeStaysTheSame() throws Exception {
        IamSuperMario starMario = new MarioWithStar(new MarioWithFireFlower());
        
        starMario = starMario.isHitByEnemy();
        
        assertTrue(MarioWithFireFlower.class.isAssignableFrom(((MarioWithStar) starMario).getOriginalMario().getClass()));
    }

    @Test
    public void WhenMarioWithStarFindsMushroom_ThenDelegateMethodIsCalled() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsMushroom()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithStar(delegate);

        mario = mario.findsMushroom();

        Mockito.verify(delegate, Mockito.times(1)).findsMushroom();
    }

    @Test
    public void WhenMarioWithStarFindsFireFlower_ThenDelegateMethodIsCalled() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsFireFlower()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithStar(delegate);

        mario = mario.findsFireFlower();

        Mockito.verify(delegate, Mockito.times(1)).findsFireFlower();
    }

    @Test
    public void WhenMarioWithStarFindsIceFlower_ThenDelegateMethodIsCalled() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsIceFlower()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithStar(delegate);

        mario = mario.findsIceFlower();

        Mockito.verify(delegate, Mockito.times(1)).findsIceFlower();
    }

    @Test
    public void WhenMarioWithStarFindsStar_ThenMarioStaysTheSame() throws Exception {
        IamSuperMario delegate = Mockito.mock(IamSuperMario.class);
        Mockito.when(delegate.findsStar()).thenReturn(delegate);
        IamSuperMario mario = new MarioWithStar(delegate);

        mario = mario.findsStar();

        Mockito.verify(delegate, Mockito.times(0)).findsStar();
    }
}
