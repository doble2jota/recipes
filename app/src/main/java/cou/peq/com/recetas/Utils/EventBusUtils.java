package cou.peq.com.recetas.Utils;

import android.os.Handler;

import cou.peq.com.recetas.Presenters.Events.BaseEvent;
import cou.peq.com.recetas.Presenters.Events.SimpleErrorEvent;
import de.greenrobot.event.EventBus;


/**
 * Created by Javier- on 01/04/2017.
 */

public class EventBusUtils extends BaseEvent{


    public static final String EVENT_SUCCESS_UPLOADING_MEDIAFILE_TAG = "SUCCESS_UPLOADING_MEDIAFILE";
    public static final String EVENT_ERROR_UPLOADING_MEDIAFILE_TAG = "ERROR_UPLOADING_MEDIAFILE";
    public static final String EVENT_SUCCESS_MEDIAFILE_TAG = "SUCCESS_MEDIAFILE";
    public static final String EVENT_ERROR_MEDIAFILE_TAG = "ERROR_MEDIAFILE";

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void register(Object object) {
        if (!isRegistred(object))
            EventBus.getDefault().register(object);
    }

    public static void registerSticky(Object object) {
        if (!isRegistred(object))
            EventBus.getDefault().registerSticky(object);
    }

    public static void unregister(Object object) {
        if (isRegistred(object))
            EventBus.getDefault().unregister(object);
    }

    public static void postSticky(Object object) {
        EventBus.getDefault().postSticky(object);
    }

    public static boolean isRegistred(Object object){
        return EventBus.getDefault().isRegistered(object);
    }

    public static void postDelayed(final Object object, int millis){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                post(object);
            }
        }, millis);
    }

    public static void postStickyDelayed(final Object object, int millis){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                postSticky(object);
            }
        }, millis);
    }

    public static void postError(String errorText){
        EventBusUtils.post(new SimpleErrorEvent(errorText));
    }
}