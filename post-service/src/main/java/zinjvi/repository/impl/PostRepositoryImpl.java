package zinjvi.repository.impl;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.stereotype.Repository;
import zinjvi.bean.Post;
import zinjvi.repository.PostRepository;

/**
 * Created by zinchenko on 26.10.14.
 */
@Repository
public class PostRepositoryImpl extends BaseMongoRepository<Post, String> implements PostRepository{

    @Override
    protected Post convertToEntity(DBObject dbObject) {
        Post post = new Post();
        post.setId((String) dbObject.get(ID_KEY).toString());
        post.setMessage((String) dbObject.get("message"));
        return post;
    }

    @Override
    protected DBObject convertToDBObject(Post post) {
        DBObject dbObject = new BasicDBObject();
        fillId(dbObject, post.getId());
        dbObject.put("message", post.getMessage());
        return dbObject;
    }

    @Override
    protected String getCollectionName() {
        return "posts";
    }

}
