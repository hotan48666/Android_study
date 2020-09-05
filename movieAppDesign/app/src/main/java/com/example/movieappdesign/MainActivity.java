package com.example.movieappdesign;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // ㄹㅣ스트 생성
    private List<Slider> sliderList;
    private ViewPager slider_pager;
    private TabLayout indicator; //탭이랑 테이블 구분 필 !!....
    private RecyclerView recyclerView;

    //slider_pager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰 페이저 액티비티를 찾음
        slider_pager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        recyclerView = findViewById(R.id.Rv_movies);
        // 리스트로 데이터를 받음
        sliderList = new ArrayList<>();

        // 데이터를 리스트에 넣음
        // 넣을떄 Slider 생성자를 이용
        sliderList.add(new Slider(R.drawable.slide1,"slide Title /nmore text here"));
        sliderList.add(new Slider(R.drawable.slide2,"slide Title /nmore text here"));
        sliderList.add(new Slider(R.drawable.slide1,"slide Title /nmore text here"));
        sliderList.add(new Slider(R.drawable.slide2,"slide Title /nmore text here"));

        //SliderPagerAdapter 어탭터를 이용해 데이터 전환
        SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(this,sliderList);
        //해당 페이지에 넣음
        slider_pager.setAdapter(sliderPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000,6000);
        indicator.setupWithViewPager(slider_pager, true);

        //
        List<Movie> listMovie = new ArrayList<>();

        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("blackp", R.drawable.blackp));
        listMovie.add(new Movie("themartian", R.drawable.themartian));
        listMovie.add(new Movie("mov2", R.drawable.mov2));
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("blackp", R.drawable.blackp));
        listMovie.add(new Movie("themartian", R.drawable.themartian));
        listMovie.add(new Movie("mov2", R.drawable.mov2));
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("blackp", R.drawable.blackp));
        listMovie.add(new Movie("themartian", R.drawable.themartian));
        listMovie.add(new Movie("mov2", R.drawable.mov2));

        MovieAdapter movieAdapter = new MovieAdapter(this, listMovie);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    //움직임
    class SliderTimer extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slider_pager.getCurrentItem() < sliderList.size() -1){
                        slider_pager.setCurrentItem(slider_pager.getCurrentItem() +1);
                    }else
                        slider_pager.setCurrentItem(0);

                }
            });
        }
    }
}
