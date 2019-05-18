package com.dba_droid.viewpagerapplication;

import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.jetbrains.annotations.NotNull;

public class FirstFragment extends Fragment {

    static final String ARG_PAGE_NUMBER = "arg_page_number";
    static final String SAVE_PAGE_NUMBER = "save_page_number";

    int pageNumber;
    int backColor;
    private int savedPageNumber = -1;

    static FirstFragment newInstance(int page) {
        FirstFragment pageFragment = new FirstFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            pageNumber = getArguments().getInt(ARG_PAGE_NUMBER);
        }
        Log.d(MainActivity.TAG, "onCreate: " + pageNumber);

        Random rnd = new Random();
        backColor = Color.argb(70, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER);
        }
        Log.d(MainActivity.TAG, "onCreate, savedPageNumber: " + savedPageNumber);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);

        TextView tvPage = view.findViewById(R.id.tv_page);
        tvPage.setText("Page " + pageNumber);
        tvPage.setBackgroundColor(backColor);

        Log.d(MainActivity.TAG, "onCreateView, savedPageNumber: " + savedPageNumber);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG, "onDestroy: " + pageNumber);
    }
}