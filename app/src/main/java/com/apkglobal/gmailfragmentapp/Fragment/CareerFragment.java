package com.apkglobal.gmailfragmentapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkglobal.gmailfragmentapp.R;

/**
 * Created by Mj 2 on 14-Jun-17.
 */

public class CareerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.career_fragment,container,false);
        return view;
    }
}
