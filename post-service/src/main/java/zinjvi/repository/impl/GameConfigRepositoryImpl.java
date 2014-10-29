package zinjvi.repository.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import zinjvi.bean.gameconfig.Cart;
import zinjvi.bean.gameconfig.GameConfig;
import zinjvi.repository.GameConfigRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by zinchenko on 29.10.14.
 */
@Repository
public class GameConfigRepositoryImpl extends BaseMongoRepository<GameConfig, String> implements GameConfigRepository {
    @Override
    protected DBObjectToEntityBuilder getDBObjectToEntityBuilder(DBObject dbObject) {
        return new DBObjectToEntityBuilder(dbObject) {
            @Override
            public GameConfig build() {
                return new GameConfig()
                        .setId(objectIdToString((ObjectId) dbObject.get(ID_KEY)))
                        .setCarts(getCarts());
            }

            private List<Cart> getCarts(){
                return (List<Cart>) CollectionUtils.collect((List)dbObject.get("carts"), new Transformer() {
                    @Override
                    public Object transform(Object o) {
                        DBObject cart = (DBObject) o;
                        return new Cart()
                                .setName((String) cart.get("name"));
                    }
                });
            }
        };
    }

    @Override
    protected EntityToDBObjectBuilder getEntityToDBObjectBuilder(GameConfig entity) {
        return new EntityToDBObjectBuilder<GameConfig>(entity) {
            @Override
            public DBObject build() {

                return new DBObjectBuilder()
                        .putId(entity.getId())
                        .put("carts", getCarts())
                        .build();
            }

            private Collection getCarts() {
                return  CollectionUtils.collect(entity.getCarts(), new Transformer() {
                    @Override
                    public Object transform(Object o) {
                        Cart cart = (Cart) o;
                        return new BasicDBObject("name", cart.getName());
                    }
                });
            }
        };
    }

    @Override
    protected String getCollectionName() {
        return "gameConfig";
    }

    @Override
    public void addCart(Cart cart) {

    }
}
