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

@SuppressLint("ValidFragment")

public class sport extends Fragment implements AdapterView.OnItemClickListener{

    public Context mContext;
    public Context iContext;

    private   FragmentTabHost mTabHost;

    public String[] Shoping_list = {"Golf Range(바톰북)", "에쉬본 골프매장", "Weilrdo 골프장"};
    public String[] Shopping_number = {"+49 69 95092744", "+49 6196 7611772", "+49 6083 95050"};
    public String[] Shoping_address = {"Am Martinszehnten 6, 60437 Frankfurt am Main",
            "Katharina-Paulus-Straße 2, 65760 Eschborn",
            "Merzhäuser Str. 29, 61276 Weilrod - Altweilnau",
            "Pfortenstraße 5560386 Frankfurt am Main"

        };

    public String[] Story= {
            "Bad Homburg 에 위치한 소규모 골프장",
            "에쉬본 골프매장 의료, 골프채, 기타 장비 구매하기 좋은곳 ",
            "Frankfrut 근처 골프장 가격이 저렴 잘안알려져 있음",
            };


    public sport(Context context) {
        mContext = context;
    }
    public sport(){

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