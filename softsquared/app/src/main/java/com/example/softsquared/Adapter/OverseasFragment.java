package com.example.softsquared.Adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.softsquared.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverseasFragment extends Fragment {

    public OverseasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overseas, container, false);
    }
}
