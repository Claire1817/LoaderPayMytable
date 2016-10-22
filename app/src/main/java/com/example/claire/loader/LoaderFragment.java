package com.example.claire.loader;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.glomadrian.roadrunner.IndeterminateRoadRunner;

public class LoaderFragment extends Fragment {
    private static final String ARG_PARAM2 = "0";

    private String text;
    private int color;

    public IndeterminateRoadRunner loader;
    public View rootView;

    public LoaderFragment() {
        // Required empty public constructor
    }

    public static LoaderFragment newInstance(int color) {
        LoaderFragment fragment = new LoaderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM2, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.custom__fragment_loader, container, false);
        loader = (IndeterminateRoadRunner) rootView.findViewById(R.id.material);
        loader.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                loader.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                setColorLoader(color);
            }
        });
        return (rootView);
    }


    public void setColorLoader(int color) {
        this.color = color;
        if (loader != null)
            loader.setColor(color);
    }
}

