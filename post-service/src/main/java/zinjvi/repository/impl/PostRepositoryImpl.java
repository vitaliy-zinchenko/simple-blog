package zinjvi.repository.impl;

import com.mongodb.DBObject;
import org.springframework.stereotype.Repository;
import zinjvi.bean.Comment;
import zinjvi.bean.Post;
import zinjvi.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 26.10.14.
 */
@Repository
public class PostRepositoryImpl extends BaseMongoRepository<Post, String> implements PostRepository{

    @Override
    protected DBObjectToEntityBuilder getDBObjectToEntityBuilder(DBObject dbObject) {
        return new DBObjectToEntityBuilder<Post>(dbObject) {
            @Override
            public Post build() {
                entity = new Post();
                entity.setId((String) dbObject.get(ID_KEY).toString());
                entity.setMessage((String) dbObject.get("message"));
                fillComments();
                return entity;
            }
            private void fillComments() {
                List<DBObject> dbObjects = (List<DBObject>) dbObject.get("comments");
                if (dbObjects == null)
                    return;
                for(DBObject commentDBObject: dbObjects) {
                    Comment comment = new Comment();
                    comment.setMessage((String) commentDBObject.get("message"));
                    entity.getComments().add(comment);
                }
            }
        };
    }

    @Override
    protected EntityToDBObjectBuilder getEntityToDBObjectBuilder(Post entity) {
        return new EntityToDBObjectBuilder<Post> (entity) {
        @Override
        public DBObject build() {
            return creteDBObjectBuilder()
                    .putId(entity.getId())
                    .put("message", entity.getMessage())
                    .put("comments", createComments())
                    .build();
        }

        private List createComments() {
            List comments = new ArrayList();
            for (Comment comment: entity.getComments()) {
                creteDBObjectBuilder()
                        .put("message", comment.getMessage())
                        .buildTo(comments);
            }
            return comments;
        }
        };
    }

    @Override
    protected String getCollectionName() {
        return "posts";
    }


}
