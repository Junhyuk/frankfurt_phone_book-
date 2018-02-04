package com.benchmarking.fft_phonebook.jun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import com.benchmarking.fft_phonebook.jun.R;

@SuppressLint("ValidFragment")

public class shoping extends Fragment implements AdapterView.OnItemClickListener{

    public Context mContext;
    public Context iContext;

    private   FragmentTabHost mTabHost;

    public String[] Shoping_list = {"Samsunb mobile", "MTZ", "매칭엔 아울렛"};
    public String[] Shopping_number = {"+49 0", "+49 0", "+49 0"};
    public String[] Shoping_address = {"Zeil 119, 60313 Frankfurt am Main",
            "Am Main-Taunus-Zentrum 1, 65843 Sulzbach (Taunus)",
            "Maienwaldstraße 2, 72555 Metzingen"
            };

    public String[] Story= {
            "FFT 시내에 위치한 SES shop",
            "슐츠바흐 종합 쇼핑몰",
            "매칭엔 아울렛 (FFT 에서 1시간 거리)"
            };


    public shoping(Context context) {
        mContext = context;
    }
    public shoping(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //super.onCreate(savedInstanceState);

            //setContentView(R.layout.activity_main);
            View view = inflater.inflate(R.layout.activity_tab1, null);

            iContext = inflater.getContext();

            ArrayAdapter<String> Adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, Shoping_list);
            ListView list = (ListView) view.findViewById(R.id.listView2);

            list.setAdapter(Adapter);
            //list.setOnItemClickListener((AdapterView.OnItemClickListener) this);
            list.setOnItemClickListener(this);

            return view;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

       // Log.i("MWC", "onItemClick function" + " "+ RestaurantArray [i]);



        String c_list = Shoping_list[i];
        String addr_list = Shoping_address [i];
        String phone_num = Shopping_number [i];
        String story=  Story [i];


        Intent intent = new Intent(iContext , second.class);

        intent.putExtra("arr_text", c_list);
        intent.putExtra("addr_text", addr_list);
        intent.putExtra("phone_num", phone_num );
        intent.putExtra("main_menu", story);

        Log.i("MWC", "Shoping onItemClick function" + " " + addr_list);
        //Log.i("MWC", "onItemClick function" + " " + phone_num);

        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }
}