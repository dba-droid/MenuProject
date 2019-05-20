package com.dba_droid.tablayoutyapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerFragmentAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;

    TabPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0: {
                return new Fragment_01();
            }
            case 1: {
                return new Fragment_02();
            }
            case 2: {
                return new Fragment_03();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "FRAGMENT " + position + 1;
    }
}
