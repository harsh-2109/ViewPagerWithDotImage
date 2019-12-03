package com.example.viewpagerwithdotimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class IntroPageAdapter extends PagerAdapter {

    Context context;
    List<ScreenItem> mList;

    public IntroPageAdapter(Context context, List<ScreenItem> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_screen,null);

        ImageView imgSlide=view.findViewById(R.id.image_container);
        TextView slideTitle=view.findViewById(R.id.intro_title);
        TextView slideDesc=view.findViewById(R.id.intro_desc);

        imgSlide.setImageResource(mList.get(position).getScreenImage());
        slideTitle.setText(mList.get(position).getTitle());
        slideDesc.setText(mList.get(position).getDescription());

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
