package com.example.android1lesson2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;
public class SecondFragment extends Fragment {
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setOnClickListener(view1 -> {
            ThirdFragment thirdFragment = new ThirdFragment();
            Bundle bundle = new Bundle();
            bundle.putString("username", "admin");
            bundle.putString("password", "admin");
            thirdFragment.setArguments(bundle);
            transationToTirdFragment(thirdFragment);
        });
    }
    private void transationToTirdFragment(ThirdFragment thirdFragment){
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_second_view, thirdFragment)
                .addToBackStack(null)
                .commit();
    }


}