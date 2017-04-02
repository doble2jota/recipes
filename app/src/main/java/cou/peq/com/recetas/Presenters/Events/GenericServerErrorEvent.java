package cou.peq.com.recetas.Presenters.Events;

/**
 * Created by Javier- on 01/04/2017.
 */

public class GenericServerErrorEvent extends BaseEvent {

    public static String ERROR_LOGIN="ERROR_LOGIN";

    private String Tag;
    private String message;

    public String getTag() {
        return Tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTag(String tag) {
        Tag = tag;
    }
}