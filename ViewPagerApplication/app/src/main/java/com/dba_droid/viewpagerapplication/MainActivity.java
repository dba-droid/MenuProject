package com.dba_droid.viewpagerapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    static final int PAGE_COUNT = 10;

    ViewPager pager;
    PagerAdapter pagerAdapter;
    public final static String TAG = "appTag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

//        pager.setOffscreenPageLimit(5);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //todo open logs
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE: {
//                        Log.i(TAG, "scroll stoped");
                        break;
                    }
                    case ViewPager.SCROLL_STATE_DRAGGING: {
//                        Log.i(TAG, "scrolling...");
                        break;
                    }
                    case ViewPager.SCROLL_STATE_SETTLING: {
//                        Log.i(TAG, "scroll to end screen");
                        break;
                    }
                }
            }
        });

//        pager.setCurrentItem(5);
//       int pagerPos = pager.getCurrentItem();

    }
}
