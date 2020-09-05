package com.example.shoptest.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoptest.R;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersFragment extends Fragment implements View.OnClickListener {


    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView,navigationView2;
    TextView tv_logout;

    private View view;

    private RelativeLayout
    loginSignUp,
    bookmarks,
    eightMMGold;

    private TextView your_obers, favourite_orders, address_book, help, rateustheplaystore, reportasafetyemergency, send_feedback ,location;

    public OrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_orders, container, false);

        onSetNavigationDrawerEvents();


        return view;
    }




    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) view.findViewById(R.id.navigationView);
        navigationView2 = (NavigationView) view.findViewById(R.id.navigationView2);

        navigationBar = (ImageView) view.findViewById(R.id.navigationBar);

        loginSignUp = (RelativeLayout) view.findViewById(R.id.relativeLayout1);
        bookmarks = (RelativeLayout) view.findViewById(R.id.relativeLayout2);
        eightMMGold = (RelativeLayout) view.findViewById(R.id.relativeLayout3);

        your_obers = (TextView) view.findViewById(R.id.your_obers);
        favourite_orders = (TextView) view.findViewById(R.id.favourite_orders);
        address_book = (TextView) view.findViewById(R.id.address_book);
        help = (TextView) view.findViewById(R.id.help);

        rateustheplaystore = (TextView) view.findViewById(R.id.rateustheplaystore);
        reportasafetyemergency = (TextView) view.findViewById(R.id.reportasafetyemergency);
        send_feedback = (TextView) view.findViewById(R.id.send_feedback);
        location = (TextView) view.findViewById(R.id.location);
        navigationBar.setOnClickListener(this);
        location.setOnClickListener(this);
        //
        loginSignUp.setOnClickListener(this);
        bookmarks.setOnClickListener(this);
        eightMMGold.setOnClickListener(this);

        your_obers.setOnClickListener(this);
        favourite_orders.setOnClickListener(this);
        address_book.setOnClickListener(this);
        help.setOnClickListener(this);

        rateustheplaystore.setOnClickListener(this);
        reportasafetyemergency.setOnClickListener(this);
        send_feedback.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                Toast.makeText(getContext(),"타냐",Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(navigationView, true);

                break;
            case R.id.relativeLayout1:
                //drawerLayout.openDrawer(navigationView, true);
                Toast.makeText(getContext(),"로그인",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout2:
                //drawerLayout.openDrawer(navigationView, true);
                Toast.makeText(getContext(),"로그인2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout3:
               // drawerLayout.openDrawer(navigationView, true);
                Toast.makeText(getContext(),"로그인3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.location:
                Toast.makeText(getContext(),"타냐",Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(navigationView2, true);

                break;



        }
    }

    private void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }


}
