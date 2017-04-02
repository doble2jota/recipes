package cou.peq.com.recetas.async;

/**
 * Created by Javier- on 01/04/2017.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CancelableExecutor {

    // Esto lo usamos para trabajos que queramos poder cancelar.
    public static final int N_THREADS = 1;
    private static ThreadPoolExecutor threadPoolExecutor;

    public synchronized static ThreadPoolExecutor getCancelableExecutor() {
        if (threadPoolExecutor == null) {
            threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(N_THREADS);
        }
        return threadPoolExecutor;
    }

    public static Future execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        return getCancelableExecutor().submit(runnable);
    }

}