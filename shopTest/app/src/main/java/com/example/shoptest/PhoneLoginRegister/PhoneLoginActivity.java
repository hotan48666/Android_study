package com.example.shoptest.PhoneLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.shoptest.EmailLoginRegister.EmailLoginActivity;
import com.example.shoptest.EmailLoginRegister.EmailRegisterActivity;
import com.example.shoptest.MainActivity;
import com.example.shoptest.R;

public class PhoneLoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void goToRegister(View view){

        Intent intent = new Intent(PhoneLoginActivity.this, PhoneRegisterActivity.class);
        startActivity(intent);
        finish();

    }

    public void backToMainPage(View view){

        Intent intent = new Intent(PhoneLoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
