package cou.peq.com.recetas.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import cou.peq.com.recetas.Presenters.Events.GenericServerErrorEvent;
import cou.peq.com.recetas.Utils.EventBusUtils;

/**
 * @author Javier Gamarra
 */
public class PresenterImpl implements Presenter {

    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        EventBusUtils.register(this);
    }

    @Override
    public void onStart() {
    }

    @Override
    public void registerSticky() {
        EventBusUtils.registerSticky(this);
    }

    @Override
    public void onResume() {
        EventBusUtils.register(this);
    }

    @Override
    public void onPause() {
        EventBusUtils.unregister(this);
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void hideProgress() {

    }

}