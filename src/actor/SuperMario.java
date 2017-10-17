package actor;

public class SuperMario {
	
	private boolean isDead;
	private boolean isBig;

	public void isHitByEnemy() {
		if(isBig) {
			isBig = false;
			return;
		}
		isDead = true;
	}

	public boolean isDead() {
		return isDead;
	}

	public void findsMushroom() {
		isBig = true;
	}

	public boolean isBig() {
		return isBig;
	}

}
