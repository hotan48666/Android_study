package com.example.tablelayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void toolbar(View view){

        Intent intent = new Intent(MainActivity.this, ToolbarActivity.class);
        startActivity(intent);
        finish();

    }

    public void gird(View view){

        Intent intent = new Intent(MainActivity.this, GridLayout.class);
        startActivity(intent);
        finish();

    }

}
