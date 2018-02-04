package com.benchmarking.fft_phonebook.jun;


import com.benchmarking.fft_phonebook.jun.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


@SuppressLint("ValidFragment")
public class Tab1 extends Fragment implements AdapterView.OnItemClickListener {

	public String[] RestaurantArray = {"고궁", "하이델크룩", "바첸하우스", "도모", "서울식당", "가야"};
	public String[] RestaurantPhone = {"+49 61717 79451", "+49 6171 971 600", "+49 6196 23430", "+49 6173 78898", "+49 61717 508 2448 ", "+49 6196 9214 431"};
	public String[] RestaurantAddress = {"Bahnstrasse 28, 61449 Steinbach", "Konigsteiner Strasse 30, 61440 Oberursel",
			"Konigsteiner Str. 157,65812 Bad Soden", "Westerbachstrasse 23,61476 Kronberg",
			"Hohemarkstrasse 194, 61440 Oberursel", "Odenwald Strass 5, 65812 Bad Soden" };

	public String[] RestrauntMenu= {"메뉴: 광어회 깐풍기 누룽지 탕수육 콩나물해장국 짜장면", "메뉴: 김치찜 장어 파전",
								"메뉴: 회 보쌈/삼겹살 장어 문어숙회 매운탕/짬뽕탕",  "메뉴: 돼지깐풍기 전복죽 삼겹살 오무라이스 김삼복",
								"메뉴: 탕종류, Sub Menu:곱창전골 삼겹살 김치전",
                                "메뉴: 굴보쌈 감자탕 " };



		public Context mContext;
		public Context iContext;


		public Tab1(Context context) {
			mContext = context;
		}
		public Tab1(){

		}


		public final static boolean DEBUG_JUN = true;


				@Override
				public void onCreate(Bundle savedInstanceState) {
					// TODO Auto-generated method stub
					super.onCreate(savedInstanceState);
				}
				@Override
				public View onCreateView(LayoutInflater inflater,
						ViewGroup container, Bundle savedInstanceState) {

					//super.onCreate(savedInstanceState);
					if (DEBUG_JUN) {
						//setContentView(R.layout.activity_main);
						View view = inflater.inflate(R.layout.activity_tab1, null);

						iContext = inflater.getContext();

						ArrayAdapter<String> Adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, RestaurantArray);
						ListView list = (ListView) view.findViewById(R.id.listView2);

						list.setAdapter(Adapter);
						//list.setOnItemClickListener((AdapterView.OnItemClickListener) this);
						list.setOnItemClickListener(this);

						return view;

					} else {


						View view = inflater.inflate(R.layout.activity_tab1, null);

						Button button1;
						button1 = (Button) view.findViewById(R.id.button1);

						button1.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								Uri uri = Uri.parse("http://junbenchmarking.tistory.com");
								Intent it = new Intent(Intent.ACTION_VIEW, uri);
								startActivity(it);
							}
						});

						return view;
					}
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