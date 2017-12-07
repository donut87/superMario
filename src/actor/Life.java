package actor;

public class Life {
	
	private int lives;
	private int coins;

	public Life(int lives, int coins) {
		this.lives = lives;
		this.coins = coins;
	}

	public int getLives() {
		return lives;
	}

	public int getCoins() {
		return coins;
	}

	public Life increase() {
		return new Life(lives + 1, coins);
	}

	public Life decrease() {
		return new Life(lives - 1, coins);
	}

	public Life findCoins(int i) {
		int c = coins + i;
		int l = lives;
		if (c >= 100) {
			l = lives + 1;
			c -= 100;
		}
		return new Life(l, c);
	}
}