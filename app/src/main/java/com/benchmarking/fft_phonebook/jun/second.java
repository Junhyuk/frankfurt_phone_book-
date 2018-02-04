package com.benchmarking.fft_phonebook.jun;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.benchmarking.fft_phonebook.jun.R;
import com.google.android.gms.maps.GoogleMap;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.text.SpannableStringBuilder;

//import static com.benchmarking.fft_phonebook.jun.R.id.button;

import android.widget.Toast;

/**
 * Created by Administrator on 2016-02-11.
 */
public class second extends Activity  implements View.OnClickListener {

    String g_addr;
    String g_phone_num;
    String g_menu;
    private View arg0;
    private GoogleMap map;
    private final int MY_PERMISSION_REQUEST_CALL= 100;
    private static final String TAG = "AppPermission";

    @Override
    protected void onCreate(Bundle savedInstantanceState){
        Log.i("MWC", "second second");


        super.onCreate(savedInstantanceState);
        setContentView(R.layout.second);


        Bundle bundle = getIntent().getExtras();

        String text = bundle.getString("arr_text");
        String addr_text = bundle.getString("addr_text");
        String phone_text= bundle.getString("phone_num");
        String menu = bundle.getString("main_menu");

        g_addr = addr_text;
        g_phone_num = phone_text;
        g_menu = menu;


        TextView sc_t = (TextView) findViewById(R.id.LargeText);
        sc_t.setText(text);



        TextView sc_addr = (TextView) findViewById(R.id.textView);

        //addr_text ="Address:  " +"\n"+ addr_text;
       // addr_text = addr_text;

        final SpannableStringBuilder sps = new SpannableStringBuilder(addr_text);
        sps.setSpan(new RelativeSizeSpan(1.2f), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sc_addr.setText(sps, TextView.BufferType.SPANNABLE);

        //sc_addr.append(sps);
        //sc_addr.setText(addr_text);

        TextView sc_phone = (TextView) findViewById(R.id.textView2);

        SpannableString content = new SpannableString(phone_text);
        content.setSpan(new UnderlineSpan(), 0, phone_text.length(), 0);
        sc_phone.setText(content);



        TextView sc_menu = (TextView) findViewById(R.id.Menu);
        sc_menu.setText(menu);



        Log.i("MWC", "second second" + addr_text);
        Log.i("MWC", "second second"  + phone_text);


        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0){

        switch (arg0.getId()){
           case R.id.button:
              // startActivity(new Intent("android.intent.action.CALL", Uri.parse(g_phone_num)));
               Log.i("MWC", "second second " + g_phone_num);
               //startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" +g_phone_num)));


               checkPermission();


               break;
           case R.id.button2:
               Log.i("MWC", "second second"  + g_addr);

               //Uri uri = Uri.parse("geo:38.899533,-77.036476");
               Intent it = new Intent(android.content.Intent.ACTION_VIEW,
               Uri.parse("http://maps.google.com/?q=" + g_addr));
               startActivity(it);
               break;

       }

    }



    @TargetApi(Build.VERSION_CODES.M)
    private void checkPermission() {
        Log.i(TAG, "CheckPermission : " + checkSelfPermission(Manifest.permission.CALL_PHONE));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                // Explain to the user why we need to write the permission.
                Toast.makeText(this, "Phone call", Toast.LENGTH_SHORT).show();
            }

            requestPermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.CALL_PHONE},
                    MY_PERMISSION_REQUEST_CALL);

            // MY_PERMISSION_REQUEST_STORAGE is an
            // app-defined int constant

        } else {
            Log.e(TAG, "permission deny");
            call_with_number();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CALL:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {


                    call_with_number();

                    // permission was granted, yay! do the
                    // calendar task you need to do.

                } else {

                    Log.d(TAG, "Permission always deny");

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                break;
        }
    }

    private void call_with_number() {

        try {
            Intent i;
            //i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" +g_phone_num));
            i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:" + g_phone_num));
            startActivity(i);

        } catch (ActivityNotFoundException e) {
            Log.e("전화걸기", "전화걸기에 실패했습니다", e);

        }
    }
}
