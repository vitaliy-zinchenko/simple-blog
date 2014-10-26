package zinjvi.zinjvi.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by zinchenko on 26.10.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
