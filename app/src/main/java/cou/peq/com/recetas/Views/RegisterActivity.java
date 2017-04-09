package cou.peq.com.recetas.Views;


import android.os.Bundle;
import cou.peq.com.recetas.Presenters.RegisterPresenterImpl;
import cou.peq.com.recetas.Presenters.RegisterPresenter;
import cou.peq.com.recetas.R;

/**
 * Created by Javier- on 09/04/2017.
 */

public class RegisterActivity extends AbstractActivity<RegisterPresenter> implements RegisterView{


    private RegisterPresenterImpl registerPresenterImpl;

    @Override
    protected RegisterPresenter createPresenter() {
        return registerPresenterImpl = new RegisterPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }
}
