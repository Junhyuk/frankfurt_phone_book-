package com.benchmarking.fft_phonebook.jun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.util.Log;
import android.content.Intent;

import com.benchmarking.fft_phonebook.jun.R;

import static android.widget.AdapterView.*;


public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    //변수 선언


    public String[] restaurantArray = {"고궁", "하이델크룩", "바첸하우스", "도모", "서울식당", "송학"};
    public String[] restaurantPhone = {"+49 61717 79451", "+49 6171 971 600", "+49 6196 23430", "+49 6173 78898", "+49 61717 508 2448 ", "+49 6192 200 0122"};
    public String[] restaurantAddress = {"Bahnstrasse 28, 61449 Steinbach (Taunus)", "Königsteiner Straße 30, 61440 Oberursel (Taunus)",
                                             "Königsteiner Str. 157,65812 Bad Soden am Taunus", "Westerbachstraße 23,61476 Kronberg im Taunus",
                                            "Hohemarkstraße 194, 61440 Oberursel (Taunus)", "Frankfurt str17, 65830 Kriftel" };

    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, restaurantArray);
        ListView list = (ListView)findViewById(R.id.listView);

        list.setAdapter(Adapter);
        list.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

        Log.i("MWC", "onItemClick function" + " "+ restaurantArray [i]);



        String c_list = restaurantArray [i];
        String addr_list = restaurantAddress [i];
        String phone_num = restaurantPhone [i];


        Intent intent = new Intent(MainActivity.this, second.class);

        intent.putExtra("arr_text", c_list);
        intent.putExtra("addr_text", addr_list);
        intent.putExtra("phone_num", phone_num);

        Log.i("MWC", "onItemClick function" + " " + addr_list);
        Log.i("MWC", "onItemClick function" + " " + phone_num);


        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
