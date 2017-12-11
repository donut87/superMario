package alive;

import actor.DeadMario;
import actor.IamSuperMario;
import actor.SmallMario;

public class Life implements IamAlive {
	
	private int lives;
	private int coins;

	public Life(int lives, int coins) {
		this.lives = lives;
		this.coins = coins;
	}

	@Override
	public int getLives() {
		return lives;
	}

	@Override
	public int getCoins() {
		return coins;
	}

	@Override
	public IamAlive increase() {
		return new Life(lives + 1, coins);
	}

	@Override
	public IamSuperMario decrease() {
		if (this.lives == 0) {
			return new DeadMario();
		}
		return new SmallMario(new Life(lives - 1, coins));
	}

	@Override
	public IamAlive findCoins(int i) {
		int c = coins + i;
		int l = lives;
		if (c >= 100) {
			l = lives + 1;
			c -= 100;
		}
		return new Life(l, c);
	}
}