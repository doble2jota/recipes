package cou.peq.com.recetas.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import cou.peq.com.recetas.Presenters.MainMenuPresenter;
import cou.peq.com.recetas.Presenters.MainMenuPresenterImpl;
import cou.peq.com.recetas.R;
import cou.peq.com.recetas.Views.Adapters.MainMenuGridAdapter;

public class MainMenuActivity extends  AbstractActivity<MainMenuPresenter> implements MainMenuView, View.OnClickListener  {

    private MainMenuPresenterImpl mainMenuPresenterImplPresenter;
    private GridView menuGridView;

    @Override
    protected MainMenuPresenter createPresenter() {
        return mainMenuPresenterImplPresenter = new MainMenuPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuGridView =  (GridView) findViewById(R.id.mainMenuGrid);
        fillMenu(menuGridView);

    }

    private void fillMenu(GridView menuGridView) {
        menuGridView.setAdapter(new MainMenuGridAdapter(menuGridView.getContext()));
    }

    @Override
    public void onClick(View view) {

    }
}
