package com.example.android1lesson2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {
    private static final String PARAMETER1 = "parameter1";
    private static final String PARAMETER2 = "parameter2";

    private String getParameter1;
    private String getParameter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getParameter1 = getArguments().getString(PARAMETER1);
            getParameter2 = getArguments().getString(PARAMETER2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public static HomeFragment newInstance(String parameter1, String parameter2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(PARAMETER1, parameter1);
        args.putString(PARAMETER2, parameter2);
        fragment.setArguments(args);
        return fragment;
    }



}
