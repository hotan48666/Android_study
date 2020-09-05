package com.example.shoptest.EmailLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.shoptest.MainActivity;
import com.example.shoptest.R;

public class EmailRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void goToLogin(View view){

        Intent intent = new Intent(EmailRegisterActivity.this, EmailLoginActivity.class);
        startActivity(intent);
        finish();

    }

    public void backToMainPage(View view){

        Intent intent = new Intent(EmailRegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
