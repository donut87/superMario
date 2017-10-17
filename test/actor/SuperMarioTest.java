package actor;

import static org.junit.Assert.*;

import org.junit.Test;

import actor.SuperMario;

public class SuperMarioTest {

	@Test
	public void WhenSmallMarioIsHitByEnemy_ThenHeDies() throws Exception {
		SuperMario mario = new SuperMario();
		mario.isHitByEnemy();
		assertTrue(mario.isDead());
	}

	@Test
	public void WhenMarioIsInitialized_ThenHeIsAlive() throws Exception {
		SuperMario mario = new SuperMario();
		assertFalse(mario.isDead());
	}

	@Test
	public void WhenMarioFindsMushroom_ThenHeIsBig() throws Exception {
		SuperMario mario = new SuperMario();
		mario.findsMushroom();
		assertTrue(mario.isBig());
	}

	@Test
	public void WhenBigMarioIsHitByEnemy_ThenHeBecomesSmallMario() throws Exception {
		SuperMario mario = new SuperMario();
		mario.findsMushroom();

		mario.isHitByEnemy();

		assertFalse(mario.isBig());
	}

}
