package actor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeadMarioTest {

    

    @Test
    public void WhenDeadSuperMarioFindsLive_HeBecomesSmallMario() throws Exception {
        IamSuperMario mario = new DeadMario();

        mario = mario.findsLive();

        assertTrue(SmallMario.class.isAssignableFrom(mario.getClass()));
    }





}
