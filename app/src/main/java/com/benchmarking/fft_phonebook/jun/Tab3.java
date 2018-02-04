package com.benchmarking.fft_phonebook.jun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.benchmarking.fft_phonebook.jun.R;


@SuppressLint("ValidFragment")
public class Tab3 extends Fragment implements AdapterView.OnItemClickListener {

	public String[] RestaurantArray = {"Restaurant Mai Vien", "Muter Krauss", "멘델스존", "Mangia Mangia"};
	public String[] RestaurantPhone = {"+49 69 7073870", "+49 6196 1289", "+49 6196 643390", "+49 6173 967174", };
	public String[] RestaurantAddress = {"Schloßstraße 92, 60486 Frankfurt am Main",
			"Hauptstraße 13, 65824 Schwalbach am Taunus",
			"Königsteiner Str. 89, 65812 Bad Soden am Taunus",
			"Friedensstraße 6-10, 60311 Frankfurt am Main",
			 };


	public String[] RestrauntMenu= {"해장용 베트남 쌀국수 싸고 맛있음",
			"Muter Kraus 독일 식당",

			"음악가 멘델스존이 거주했던 집을 개조해 만든 Italy 식당 , Samsung Dish  주문가능",
			"Kronberg 에 있는 Fancy 한 Italy 레스토랑, 햄버거와 스테이크 먹을만함",
			};



	public Context mContext;
	public Context iContext;


	public Tab3(Context context) {
		mContext = context;
	}
	public Tab3(){

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