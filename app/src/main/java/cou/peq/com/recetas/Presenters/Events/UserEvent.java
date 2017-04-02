package cou.peq.com.recetas.Presenters.Events;

import android.nfc.Tag;

/**
 * Created by Javier- on 01/04/2017.
 */

public class UserEvent {

    public static String EVENT_SUCCESS_REGISTER_USER="EVENT_SUCCESS_REGISTER_USER";


    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    private String Tag;

}
