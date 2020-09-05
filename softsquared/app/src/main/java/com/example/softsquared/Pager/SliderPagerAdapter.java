package com.example.softsquared.Pager;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.softsquared.Model.Slider;
import com.example.softsquared.R;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Slider> mList;

    public SliderPagerAdapter(Context mContext, List<Slider> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View sliderLayout = inflater.inflate(R.layout.slider_item, null);
        ImageView sliderImg = sliderLayout.findViewById(R.id.slider_img);
        TextView sliderText = sliderLayout.findViewById(R.id.slider_title);
        sliderImg.setImageResource(mList.get(position).getImg());
        sliderText.setText(mList.get(position).getTitle());

        container.addView(sliderLayout);
        return sliderLayout;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}