package com.example.daggerpractice.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.example.daggerpractice.R;
import com.example.daggerpractice.models.User;
import com.example.daggerpractice.viewmodels.ViewModelProviderFactory;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    private AuthViewModel authViewModel;

    @BindView(R.id.user_id_input)
    TextInputEditText userInput;

    @BindView(R.id.login_button)
    Button loginButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_main);
        ButterKnife.bind(this);

        authViewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);
        setLogo();

        loginButton.setOnClickListener(this);

        subscrbeObservers();

    }

    void setLogo() {
        requestManager.load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.login_button: {
                attemptLogin();
                break;
            }
        }
    }

    private void subscrbeObservers() {

        authViewModel.observableUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING: {
                            showProgressBar(true);
                            break;
                        }

                        case AUTHENTICATED: {
                            showProgressBar(false);
                            Log.d(TAG, "Onchanged: LOGIN SUCCESS: "+ userAuthResource.data.getEmail());
                            break;
                        }

                        case ERROR: {
                            showProgressBar(false);
                            Toast.makeText(AuthActivity.this, userAuthResource.message + "\n Did you enter no btw 1 and 10", Toast.LENGTH_SHORT).show();
                            break;
                        }

                        case NOT_AUTHENTICATED: {
                            showProgressBar(false);
                            break;
                        }

                    }
                }
            }
        });
    }

    private void showProgressBar(boolean isVisible){
        if (isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }
    private void attemptLogin() {
        if (TextUtils.isEmpty(userInput.getText().toString())) {
            Toast.makeText(this, "Cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        authViewModel.authenticateWithId(Integer.parseInt(userInput.getText().toString()));
    }
}
