package alive;

import actor.IamSuperMario;

public interface IamAlive {

	int getLives();

	int getCoins();

	IamAlive increase();

	IamSuperMario decrease();

	IamAlive findCoins(int i);

}