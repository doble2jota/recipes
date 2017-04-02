package cou.peq.com.recetas.Views;

/**
 * Created by Javier- on 01/04/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void onRegisterSuccess();
}
