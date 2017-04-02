package cou.peq.com.recetas.Presenters;

/**
 * Created by Javier- on 01/04/2017.
 */

public interface LoginPresenter extends Presenter{
    void validateCredentials(String username, String password);
    void createUser(String userName, String password);
    void onDestroy();
}