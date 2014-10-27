package zinjvi.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 25.10.14.
 */
public class Post {

    private String id;

    private String message;

    private List<Comment> comments = new ArrayList<Comment>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
