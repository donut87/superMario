package actor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SmallMarioTest {

    @Test
    public void WhenSmallMarioFindsMushroom_ThenHeBecomesMarioWithMushroom() throws Exception {
        IamSuperMario mario = new SmallMario();
        mario.findsMushroom();
        assertTrue(mario.hasMushroom());
    }

}
