package cou.peq.com.recetas.Views;

import android.app.Application;
import android.content.Context;

/**
 * Created by Javier- on 01/04/2017.
 */



public class RecipeApplication extends Application{
    public static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance= this;
    }


    public static Context get(){
        return instance;
    }

}
