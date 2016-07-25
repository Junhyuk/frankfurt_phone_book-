package com.example.fft_phonebook.mwc;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

@SuppressLint("ValidFragment")
public class Tab4 extends Fragment {
    Context mContext;

    private   FragmentTabHost mTabHost;



    public Tab4(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      //  View view = inflater.inflate(R.layout.activity_tab4, null);
        //return view;

        mTabHost = new FragmentTabHost(getActivity());

        Bundle b = new Bundle();
        b.putString("key", "Simple");


        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.textViewtab4);

        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
                Tab1.class, b);
        mTabHost.addTab(mTabHost.newTabSpec("array").setIndicator("Array"),
                Tab2.class, b);

        return mTabHost;
    }


    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }
}