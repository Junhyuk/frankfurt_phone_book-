package com.benchmarking.fft_phonebook.jun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.benchmarking.fft_phonebook.jun.R;

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
        //View view = inflater.inflate(R.layout.activity_tab4, null);
        //return view;

        mTabHost = new FragmentTabHost(getActivity());

        Bundle b = new Bundle();
        b.putString("key", "Tab4");


        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.textViewtab4);

        mTabHost.addTab(mTabHost.newTabSpec("Shoping").setIndicator("Shoping"),
                shoping.class, b);
        mTabHost.addTab(mTabHost.newTabSpec("Sport").setIndicator("Sport"),
                sport.class, b);

        return mTabHost;
    }


    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }
}