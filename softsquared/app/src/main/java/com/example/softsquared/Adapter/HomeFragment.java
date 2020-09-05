package com.example.softsquared.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.softsquared.MainActivity;
import com.example.softsquared.Model.Movie;
import com.example.softsquared.Model.Slider;
import com.example.softsquared.Pager.MovieAdapter;
import com.example.softsquared.Pager.SliderPagerAdapter;
import com.example.softsquared.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List<Slider> sliderList;
    private ViewPager slider_pager;
    private TabLayout indicator; //탭이랑 테이블 구분 필 !!....
    private View view;
    private Context mContext;
    private RecyclerView recyclerView;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mContext = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);

        view = inflater.inflate(R.layout.fragment_home, container, false);

        onSetNavigationDrawerEvents();


        return view;
    }

    private void onSetNavigationDrawerEvents() {
        slider_pager = view.findViewById(R.id.slider_pager);
        indicator = view.findViewById(R.id.indicator);
        recyclerView = view.findViewById(R.id.recyclerView);
        List<Movie> listMovie = new ArrayList<>();
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("moana", R.drawable.moana));

        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("moana", R.drawable.moana));
        listMovie.add(new Movie("moana", R.drawable.moana));

        MovieAdapter movieAdapter = new MovieAdapter(view.getContext(), listMovie);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));



        sliderList = new ArrayList<>();
        sliderList.add(new Slider(R.drawable.slide1,"slide Title /n more text here"));
        sliderList.add(new Slider(R.drawable.slide2,"slide Title /n more text here"));
        sliderList.add(new Slider(R.drawable.slide1,"slide Title /n more text here"));
        sliderList.add(new Slider(R.drawable.slide2,"slide Title /n more text here"));

        //SliderPagerAdapter 어탭터를 이용해 데이터 전환
        SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(view.getContext(),sliderList);
        //해당 페이지에 넣음
        slider_pager.setAdapter(sliderPagerAdapter);

        indicator.setupWithViewPager(slider_pager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeFragment.SliderTimer(), 2000,2000);
    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {

            /*
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slider_pager.getCurrentItem() < sliderList.size() -1){
                        slider_pager.setCurrentItem(slider_pager.getCurrentItem() +1);
                    }else
                        slider_pager.setCurrentItem(0);

                }
            });
            */

        }
    }
}
