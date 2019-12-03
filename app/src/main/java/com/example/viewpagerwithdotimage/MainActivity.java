package com.example.viewpagerwithdotimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPage;
    Button next_button;
    int item_number=1;
    List<ScreenItem> mList=new ArrayList<>();
    TabLayout tabIndicator;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList.add(new ScreenItem("One","Choose Food", R.drawable.img1));
        mList.add(new ScreenItem("Two","On the way for delivery...!", R.drawable.img2));
        mList.add(new ScreenItem("Three","Payment Option", R.drawable.img3));

        viewPage=findViewById(R.id.viewPager);
        viewPage.setAdapter(new IntroPageAdapter(MainActivity.this,mList));

        tabIndicator=findViewById(R.id.tabLayout);
        tabIndicator.setupWithViewPager(viewPage);

        sound=MediaPlayer.create(MainActivity.this,R.raw.sound);
        sound.start();
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                change();
                sound.start();
            }
        });

        next_button=findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
    }
    private void change(){
        if(item_number<=mList.size()) {
            viewPage.setCurrentItem(item_number);
            item_number++;
        }
        if(item_number==mList.size()){
            item_number=0;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sound.stop();
        sound.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sound.stop();
        sound.release();
    }
}
