package com.example.softsquared.Pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.softsquared.Adapter.BroadCastFragment;
import com.example.softsquared.Adapter.HomeFragment;
import com.example.softsquared.Adapter.LiveFragment;
import com.example.softsquared.Adapter.MovieFragment;
import com.example.softsquared.Adapter.OverseasFragment;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public ContentsPagerAdapter(@NonNull FragmentManager fm, int pageCount) {
        super(fm, pageCount);
        this.mPageCount = pageCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                HomeFragment homeFragment = new HomeFragment();

                return homeFragment;



            case 1:

                BroadCastFragment broadCastFragment = new BroadCastFragment();

                return broadCastFragment;



            case 2:

                LiveFragment liveFragment = new LiveFragment();

                return liveFragment;



            case 3:

                MovieFragment movieFragment = new MovieFragment();

                return movieFragment;



            case 4:

                OverseasFragment overseasFragment = new OverseasFragment();

                return overseasFragment;



            default:

                return null;

        }

    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
