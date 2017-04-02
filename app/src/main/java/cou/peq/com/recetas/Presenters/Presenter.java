package cou.peq.com.recetas.Presenters;

import android.app.Activity;
import android.os.Bundle;

import cou.peq.com.recetas.Presenters.Events.GenericServerErrorEvent;

/**
 * Created by Javier- on 01/04/2017.
 */

public interface Presenter {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent);

    void showError(String error);

    void finishActivity();

    Activity getActivity();

    void setActivity(Activity activity);

    void hideProgress();

    void registerSticky();
}