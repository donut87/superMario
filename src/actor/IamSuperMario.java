package actor;

import java.util.function.Consumer;

import alive.IamAlive;

public interface IamSuperMario {

    IamSuperMario isHitByEnemy();

    IamSuperMario findsMushroom();

    IamSuperMario findsLive();

    IamSuperMario findsFireFlower();

    IamSuperMario findsIceFlower();

    IamSuperMario shoot(Consumer<String> object);

    IamSuperMario findsStar();

    IamSuperMario findsYoshi();

	IamSuperMario findCoins(int i);

	IamAlive getLife();

}