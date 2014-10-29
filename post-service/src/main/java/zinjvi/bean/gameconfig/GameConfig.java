package zinjvi.bean.gameconfig;

import java.util.List;

/**
 * Created by zinchenko on 29.10.14.
 */
public class GameConfig {

    private String id;

    private List<Cart> carts;

    public String getId() {
        return id;
    }

    public GameConfig setId(String id) {
        this.id = id;
        return this;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public GameConfig setCarts(List<Cart> carts) {
        this.carts = carts;
        return this;
    }


}
