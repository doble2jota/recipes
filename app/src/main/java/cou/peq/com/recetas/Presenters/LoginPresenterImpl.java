package cou.peq.com.recetas.Presenters;

import cou.peq.com.recetas.Interactors.CreateUserInteractor;
import cou.peq.com.recetas.Interactors.LoginInteractor;
import cou.peq.com.recetas.Interactors.LoginInteractorImpl;
import cou.peq.com.recetas.Presenters.Events.UserEvent;
import cou.peq.com.recetas.Views.LoginView;

/**
 * Created by Javier- on 01/04/2017.
 */

public class LoginPresenterImpl extends PresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    public void createUser(String userName, String password) {
        new CreateUserInteractor(userName,password).execute();
    }

    public void onEventMainThread(UserEvent userEvent){
        if (UserEvent.EVENT_SUCCESS_REGISTER_USER.equals(userEvent.getTag())){
            loginView.onRegisterSuccess();
        }
    }

    @Override public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override public void onDestroy() {
        loginView = null;
    }

    @Override public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

}