package com.borntonight.androidmvpbasics.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.borntonight.androidmvpbasics.R;
import com.borntonight.androidmvpbasics.presenter.ILoginPresenter;
import com.borntonight.androidmvpbasics.view.ILoginView;

public class LoginActivity extends AppCompatActivity  implements ILoginView, View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private Button   btnLogin;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUser = (EditText) this.findViewById(R.id.inEmail);
        editPass = (EditText) this.findViewById(R.id.inPassword);
        btnLogin = (Button) this.findViewById(R.id.loginButton);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                btnLogin.setEnabled(false);
                loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
                break;
        }
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        btnLogin.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login correct", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"Login incorrect, code = " + code,Toast.LENGTH_SHORT).show();
    }
}