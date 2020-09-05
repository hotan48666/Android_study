package com.example.softsquared;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.softsquared.Pager.ContentsPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private View view;

    private ImageView loginMenu, searchMenu;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView,navigationView2;
    private ImageView side_menu_left ;

    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mContext = getApplicationContext();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        loginMenu = (ImageView) findViewById(R.id.login_menu);
        searchMenu = (ImageView) findViewById(R.id.search_menu);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView2= (NavigationView) findViewById(R.id.navigationView2);
        side_menu_left = (ImageView) findViewById(R.id.side_menu_left);
        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);

        mTabLayout.addTab(mTabLayout.newTab().setText("홈")) ;
        mTabLayout.addTab(mTabLayout.newTab().setText("방송")) ;
        mTabLayout.addTab(mTabLayout.newTab().setText("라이브")) ;
        mTabLayout.addTab(mTabLayout.newTab().setText("영화")) ;
        mTabLayout.addTab(mTabLayout.newTab().setText("해외 시리즈")) ;

        mViewPager = (ViewPager) findViewById(R.id.pager_content);
        mContentPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mContentPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        //mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        loginMenu.setOnClickListener(this);
        searchMenu.setOnClickListener(this);
        side_menu_left.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_menu:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.search_menu:
                drawerLayout.openDrawer(navigationView2, true);
                break;
            case R.id.side_menu_left:
                drawerLayout.closeDrawer(navigationView, true);
                break;
        }
    }


}
