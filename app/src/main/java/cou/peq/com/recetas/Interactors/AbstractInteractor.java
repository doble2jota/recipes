package cou.peq.com.recetas.Interactors;

import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.Future;

import cou.peq.com.recetas.async.CancelableExecutor;
import cou.peq.com.recetas.async.Executor;


/**
 * Created by Javier- on 01/04/2017.
 */

public abstract class AbstractInteractor extends Job implements Runnable {
    public static final int PRIORITY=10;

    protected AbstractInteractor() {
        super(new Params(PRIORITY));
    }

    public void execute () {
        Executor.execute(this);
    }
    public abstract void runOnBackGround();

    public Future executeCanelableThread(){
        return CancelableExecutor.execute(this);
    }


    @Override
    public void run() {
        try {
            runOnBackGround();
        }catch (Throwable throwable){
            Log.d(this.getClass().getSimpleName(),"Error Abstract Interactor");
        }
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
