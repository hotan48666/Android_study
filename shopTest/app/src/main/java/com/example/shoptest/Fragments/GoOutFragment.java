package com.example.shoptest.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoptest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoOutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoOutFragment extends Fragment {


    public GoOutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_go_out, container, false);
    }
}
