package cou.peq.com.recetas.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import cou.peq.com.recetas.Presenters.LoginPresenter;
import cou.peq.com.recetas.Presenters.LoginPresenterImpl;
import cou.peq.com.recetas.R;
import cou.peq.com.recetas.Utils.UtilsAnimation.AnimationUtils;

import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AbstractActivity<LoginPresenter> implements LoginView, View.OnClickListener{

    private ProgressBar progressBar;
    private LoginPresenterImpl loginPresenterImpl;
    private EditText emailTextView;
    private EditText passwordEditText;
    private LinearLayout containerLayout;
    View confirmButton;

    @Override
    protected LoginPresenter createPresenter() {
        return loginPresenterImpl = new LoginPresenterImpl(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        progressBar=(ProgressBar)findViewById(R.id.login_progress);
        containerLayout= (LinearLayout) findViewById(R.id.container_layout);
        (confirmButton= findViewById(R.id.email_sign_in_button)).setOnClickListener(this);
        emailTextView = (EditText)findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.password);
        loginPresenterImpl = new LoginPresenterImpl(this);

        showButton(confirmButton);
    }



    private void  showButton(View view){
        view.postDelayed(new Runnable()
        {
            @Override
            public void run(){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    AnimationUtils.show(confirmButton);
                }
            }
        },500);
    }


    @Override protected void onDestroy() {
        loginPresenterImpl.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
    }

    @Override public void setPasswordError() {
    }

    @Override public void navigateToHome() {
    }

    @Override
    public void onRegisterSuccess() {
        Toast.makeText(this,"REGISTRADO",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterFailed() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this,"Error de autenticación", Toast.LENGTH_LONG).show();

        confirmButton.animate()
                .scaleX(1.0f)
                .setDuration(500)
                .setListener(null)
                .start();

    }

    @Override public void onClick(View v) {
        confirmButton.animate()
                .scaleX(0.0f)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        progressBar.setVisibility(View.VISIBLE);
                        loginPresenterImpl.createUser(emailTextView.getText().toString(),passwordEditText.getText().toString());
                    }
                })
                .start();
    }
}