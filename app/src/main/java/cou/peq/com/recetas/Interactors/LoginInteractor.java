package cou.peq.com.recetas.Interactors;

/**
 * Created by Javier- on 01/04/2017.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
