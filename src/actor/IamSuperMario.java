package actor;

import java.util.function.Consumer;

public interface IamSuperMario {

    IamSuperMario isHitByEnemy();

    IamSuperMario findsMushroom();

    int getLives();

    IamSuperMario findsLive();

    IamSuperMario findsFireFlower();

    IamSuperMario findsIceFlower();

    IamSuperMario shoot(Consumer<String> object);

    IamSuperMario findsStar();

    IamSuperMario findsYoshi();

}