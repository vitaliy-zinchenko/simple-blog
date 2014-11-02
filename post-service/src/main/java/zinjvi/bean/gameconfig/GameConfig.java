package zinjvi.bean.gameconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 29.10.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameConfig {

    private String id;

    private String name;

    private List<Cart> carts = new ArrayList<Cart>();

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

    public String getName() {
        return name;
    }

    public GameConfig setName(String name) {
        this.name = name;
        return this;
    }
}
