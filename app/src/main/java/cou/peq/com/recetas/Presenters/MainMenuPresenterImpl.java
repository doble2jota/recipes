package cou.peq.com.recetas.Presenters;

import cou.peq.com.recetas.Interactors.MainMenuInteractor;
import cou.peq.com.recetas.Views.MainMenuView;

/**
 * Created by raquel on 02/04/2017.
 */

public class MainMenuPresenterImpl
    extends PresenterImpl implements MainMenuPresenter {

    private MainMenuView mainMenuView;
    private MainMenuInteractor mainMenuInteractor;

    public MainMenuPresenterImpl(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
    }
}
