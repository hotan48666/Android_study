package com.example.shoptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.shoptest.Adapters.PlateAdapter;
import com.example.shoptest.EmailLoginRegister.EmailLoginActivity;
import com.example.shoptest.EmailLoginRegister.EmailRegisterActivity;
import com.example.shoptest.Models.PlateModel;
import com.example.shoptest.PhoneLoginRegister.PhoneLoginActivity;
import com.example.shoptest.PhoneLoginRegister.PhoneRegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PlateModel> plateModelList;
    private PlateAdapter plateAdapter;

    private LinearLayout emailContinue, phoneConinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위에 상단바 제거
        /*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/
        // 버그로 수정
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        emailContinue = (LinearLayout) findViewById(R.id.linear2);
        phoneConinue = (LinearLayout) findViewById(R.id.linear1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setKeepScreenOn(true);

        recyclerView.setHasFixedSize(true);

        plateModelList = new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));
        plateModelList.add(new PlateModel(R.drawable.ic_launcher_background));


        plateAdapter = new PlateAdapter(plateModelList, this);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();

        autoScroll();


        // 이메일 버튼 클릭시 처리
        emailContinue.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, EmailLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });

        // 폰 버튼 클릭시 처리
        phoneConinue.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PhoneLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });
    }

    public void autoScroll(){

        final int speedScroll = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {

            int count = 0;

            @Override
            public void run() {

                if (count == plateAdapter.getItemCount()){
                    count = 0;
                }
                if(count < plateAdapter.getItemCount()){
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };
        handler.postDelayed(runnable,speedScroll);
    }

    public void goToHomePage(View view){

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();

    }
}
