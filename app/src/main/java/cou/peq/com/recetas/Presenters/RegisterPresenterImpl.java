package cou.peq.com.recetas.Presenters;

import cou.peq.com.recetas.Views.RegisterView;

/**
 * Created by Javier- on 09/04/2017.
 */

public class RegisterPresenterImpl extends PresenterImpl implements RegisterPresenter{

    RegisterView registerView;

    public RegisterPresenterImpl(RegisterView registerView) {
        this.registerView= registerView;
    }
}
