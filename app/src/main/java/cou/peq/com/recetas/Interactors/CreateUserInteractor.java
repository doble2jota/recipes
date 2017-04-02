package cou.peq.com.recetas.Interactors;


import cou.peq.com.recetas.Model.UserDomain;

/**
 * Created by Javier- on 01/04/2017.
 */

public class CreateUserInteractor extends AbstractInteractor {

    private String userName;
    private String password;

    public CreateUserInteractor(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void runOnBackGround() {
        UserDomain userDomain = new UserDomain();
        userDomain.createUser(userName,password);
    }
}
