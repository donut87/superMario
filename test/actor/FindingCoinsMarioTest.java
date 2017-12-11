package actor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindingCoinsMarioTest {

	@Test
	public void WhenMarioStarts_ThenHeHasNoCoinsInHisAccount() throws Exception {
		IamSuperMario mario = new SmallMario();
		int coins = mario.getLife().getCoins();
		assertEquals(0, coins);
	}

	@Test
	public void WhenMarioFindsCoins_ThenTheseCoinsAreAccountedInTheBallance() throws Exception {
		IamSuperMario mario = new SmallMario();
		mario = mario.findCoins(4);
		int coins = mario.getLife().getCoins();
		assertEquals(4, coins);
	}

	@Test
	public void WhenMarioFinds100Coins_ThenHeGainsANewLive() throws Exception {
		IamSuperMario mario = new SmallMario();
		mario = mario.findCoins(100);
		int lives = mario.getLife().getLives();
		assertEquals(4, lives);
	}

	@Test
	public void WhenMarioFinds100Coins_ThenTheBallanceIsReducedBy100Coins() throws Exception {
		IamSuperMario mario = new SmallMario();
		mario = mario.findCoins(100);
		int coins = mario.getLife().getCoins();
		assertEquals(0, coins);
	}

}
