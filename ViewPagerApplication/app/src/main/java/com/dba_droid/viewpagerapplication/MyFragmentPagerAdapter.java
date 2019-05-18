package com.dba_droid.viewpagerapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;


//                                   FragmentStatePagerAdapter - create fr-s every time
class MyFragmentPagerAdapter extends FragmentPagerAdapter {

//  fast adapter because it doesn’t create fr-s every time
//  convenient for using small lists

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.i(MainActivity.TAG, "getItem(" + position + ")");
        return FirstFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return MainActivity.PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }
}