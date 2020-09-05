package com.example.shoptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.shoptest.Fragments.GoOutFragment;
import com.example.shoptest.Fragments.GoldFragment;
import com.example.shoptest.Fragments.OrdersFragment;
import com.example.shoptest.Fragments.VideosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new OrdersFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectdFragment = null;

                    switch (item.getItemId()){
                        case R.id.orders:
                            //Toast.makeText(HomeActivity.this , "orders", Toast.LENGTH_SHORT).show();
                            selectdFragment = new OrdersFragment();
                            break;
                        case R.id.goout:
                            //Toast.makeText(HomeActivity.this , "goout", Toast.LENGTH_SHORT).show();
                            selectdFragment = new GoOutFragment();
                            break;
                        case R.id.gold:
                            //Toast.makeText(HomeActivity.this , "gold", Toast.LENGTH_SHORT).show();
                            selectdFragment = new GoldFragment();
                            break;
                        case R.id.videos:
                            //Toast.makeText(HomeActivity.this , "videos", Toast.LENGTH_SHORT).show();
                            selectdFragment = new VideosFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectdFragment).commit();

                    return true;
                }
            };

}
