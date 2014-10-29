package zinjvi.repository;

import zinjvi.bean.gameconfig.Cart;
import zinjvi.bean.gameconfig.GameConfig;

/**
 * Created by zinchenko on 29.10.14.
 */
public interface GameConfigRepository extends Repository<GameConfig, String>{

    void addCart(Cart cart);

}
