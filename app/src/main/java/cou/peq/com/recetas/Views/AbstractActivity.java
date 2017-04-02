package cou.peq.com.recetas.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import cou.peq.com.recetas.Presenters.Presenter;
import cou.peq.com.recetas.R;

/**
 * @author Javier Gamarra
 */
public abstract class AbstractActivity<P extends Presenter> extends AppCompatActivity {


    public static String CALLER_ACTIVITY_NAME_TAG = "callerActivityName";
    public static String HISTORY_TASK_HAS_BEEN_RESET = "HistoryTaskHasBeenReset";


    private static final String TAG = "AbstractActivity";
    private P presenter;
    private boolean currentSettingsHasBeenChanged = false;
    private String PACKAGE_NAME;

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = createPresenter();
        presenter.setActivity(this);
        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        Runtime.getRuntime().gc();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            return onActivityCanceled();
        }
        return super.onKeyDown(keyCode, event);
    }



    public boolean onActivityCanceled(){
        finish();
        return true;
    }

}