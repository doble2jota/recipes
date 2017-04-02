package cou.peq.com.recetas.async;

/**
 * Created by Javier- on 01/04/2017.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Javier Gamarra
 */
public class Executor {

    public static final int N_THREADS = 10;
    private static ExecutorService executor;

    public synchronized static ExecutorService getExecutor() {
        if (executor == null || executor.isShutdown()) {
            executor = Executors.newFixedThreadPool(N_THREADS);
        }
        return executor;
    }

    public static void execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        getExecutor().execute(runnable);
    }

    // Amine: Only for test!!!!
    public static boolean isExecutorShutDown(){
        if(executor!=null){
            executor.shutdown();
            return executor.isTerminated();
        }
        return true;
    }
    public static boolean isExecutorIdle(){
        if(executor==null){
            return true;
        }
        return executor.isTerminated() || executor.isShutdown();
    }
}
