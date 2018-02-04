package com.benchmarking.fft_phonebook.jun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.view.MenuItem;
import android.widget.ListView;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.util.Log;

import com.benchmarking.fft_phonebook.jun.R;


@SuppressLint("ValidFragment")
public class Tab2 extends Fragment implements AdapterView.OnItemClickListener {

	public String[] RestaurantArray = {"Mikuni", "Hamon 스시", "스시모토", "이로하"};
	public String[] RestaurantPhone = {"+49 69 283627", "+49 6192 3075940", "+49 69 1310057", "+49 69 21994930", };
	public String[] RestaurantAddress = {"Fahrgasse 91, Frankfurt am Main",  "Rheingaustraße 65, 65719 Hofheim am Taunus",
			"Konrad-Adenauer-Straße 7, 60313 Frankfurt am Main", "Friedensstraße 6-10, 60311 Frankfurt am Main",
			 };


	/*
	public String[][] MainMenu= {
									{"음식1", "음식2"},
									{"음식3", "음식4"},
									{"음식3", "음식4"},
									{"음식3", "음식4"},
									{"음식3", "음식4"},
									{"음식3", "음식4"},

									};


	*/
	public String[] RestrauntMenu= {"Zeil 근처 일본사람이 운영하는 일식집 스시 및 찌라시 추천", "한국 사람이 하시는 스시집 점심 메뉴 사시미/스시 괜찮다",
			"Frankfurt 호텔에 있는 일식집으로 고급스럽고 가격이 비싼만큼 음식은 괜찮다",  "일본 전통식 스시 Restaurant 으로 높은 손님이 오시면 자주 간다. 최근에는 ..",
			};



	public Context mContext;
	public Context iContext;


	public Tab2 (Context context) {
		mContext = context;
	}
	public Tab2(){

	}


	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {

		//super.onCreate(savedInstanceState);

			//setContentView(R.layout.activity_main);
			View view = inflater.inflate(R.layout.activity_tab2, null);

			iContext = inflater.getContext();

			ArrayAdapter<String> Adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, RestaurantArray);
			ListView list = (ListView) view.findViewById(R.id.tab2_listView);

			list.setAdapter(Adapter);
			//list.setOnItemClickListener((AdapterView.OnItemClickListener) this);
			list.setOnItemClickListener(this);

			return view;
	}

	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

		Log.i("MWC", "onItemClick function" + " "+ RestaurantArray [i]);

		String c_list = RestaurantArray[i];
		String addr_list = RestaurantAddress [i];
		String phone_num = RestaurantPhone [i];
		String main_menu=  RestrauntMenu [i];


		Intent intent = new Intent(iContext , second.class);

		intent.putExtra("arr_text", c_list);
		intent.putExtra("addr_text", addr_list);
		intent.putExtra("phone_num", phone_num);
		intent.putExtra("main_menu", main_menu);

		Log.i("MWC", "onItemClick function" + " " + addr_list);
		Log.i("MWC", "onItemClick function" + " " + phone_num);

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

}