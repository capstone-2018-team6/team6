package com.example.cspclab.myapplication1;

import android.graphics.Color;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
public class LoginActivity extends AppCompatActivity {
    private static String TAG = "LoginActivity";

    private static final String TAG_JSON="ddok";
    private static final String TAG_ID = "floor";
    private static final String TAG_NAME = "number";
    private static final String TAG_ADDRESS ="usable";

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12;
    ImageView iv;
    ArrayList<HashMap<String, String>> mArrayList;
    String mJsonString;
    String txt1_="", txt2_="", txt3_="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);                                                //
        btn1 = (Button) findViewById(R.id.btn_1st_left_man);
        btn2 = (Button) findViewById(R.id.btn_2nd_left_man);
        btn3 = (Button) findViewById(R.id.btn_3nd_left_man);
        btn4 = (Button) findViewById(R.id.btn_1st_right_man);
        btn5 = (Button) findViewById(R.id.btn_2nd_right_man);
        btn6 = (Button) findViewById(R.id.btn_3nd_right_man);
        btn7 = (Button) findViewById(R.id.btn_1st_left_woman);
        btn8 = (Button) findViewById(R.id.btn_2nd_left_woman);
        btn9 = (Button) findViewById(R.id.btn_3nd_left_woman);
        btn10 = (Button) findViewById(R.id.btn_1st_right_woman);
        btn11 = (Button) findViewById(R.id.btn_2nd_right_woman);
        btn12 = (Button) findViewById(R.id.btn_3nd_right_woman);
        txt1 = (TextView) findViewById(R.id.textView);
        txt2 = (TextView) findViewById(R.id.textView1);
        txt3 = (TextView) findViewById(R.id.textView2);
        txt4 = (TextView) findViewById(R.id.textView3);
        txt5 = (TextView) findViewById(R.id.textView4);
        txt6 = (TextView) findViewById(R.id.textView5);
        txt7 = (TextView) findViewById(R.id.textView6);
        txt8 = (TextView) findViewById(R.id.textView7);
        txt9 = (TextView) findViewById(R.id.textView8);
        txt10 = (TextView) findViewById(R.id.textView9);
        txt11 = (TextView) findViewById(R.id.textView10);
        txt12 = (TextView) findViewById(R.id.textView11);
        txt4.setText("2");
        txt5.setText("3");
        txt6.setText("0");
        txt7.setText("1");
        txt8.setText("1");
        txt9.setText("3");
        txt10.setText("2");
        txt11.setText("1");
        txt12.setText("2");
        iv = (ImageView)findViewById(R.id.imageView);
        mArrayList = new ArrayList<>();

        txt6.setTextColor(Color.parseColor("#FFFF0000"));

        btn1.setOnClickListener(new Button.OnClickListener(){
           @Override
           public void onClick(View view) {
               iv.setVisibility(View.VISIBLE);
               String sid = txt1.getText().toString();
               if(sid.equals("0")) {
                   iv.setImageResource((R.drawable.left0));

               }
               else{
                   iv.setImageResource((R.drawable.left1));
               }
               iv.setOnClickListener(new OnClickListener(){
                   public void onClick(View arg0){
                       iv.setVisibility(View.INVISIBLE);
                   }
               });
           }
        });
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt2.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else{
                    iv.setImageResource((R.drawable.left1));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt3.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else{
                    iv.setImageResource((R.drawable.left1));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        btn4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt4.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        btn5.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt5.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn6.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt6.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn7.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt7.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn8.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt8.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn9.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt9.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn10.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt10.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn11.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt11.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        btn12.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.VISIBLE);
                String sid = txt12.getText().toString();
                if(sid.equals("0")) {
                    iv.setImageResource((R.drawable.left0));
                }
                else if(sid.equals("1")){
                    iv.setImageResource((R.drawable.left1));
                }
                else if(sid.equals("2")){
                    iv.setImageResource((R.drawable.left2));
                }
                else{
                    iv.setImageResource((R.drawable.left3));
                }
                iv.setOnClickListener(new OnClickListener(){
                    public void onClick(View arg0){
                        iv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        LoginActivity.GetData task = new LoginActivity.GetData();
        task.execute("http://13.231.134.238/clean.php");
    }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(LoginActivity.this,                                //
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            //mTextViewResult.setText(result);
            Log.d(TAG, "response  - " + result);

            if (result == null){

                //mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){
        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
            /*
            for(int i = jsonArray.length() - 1; i >= 0; i--){
                JSONObject item = jsonArray.getJSONObject(i);

                String id = item.getString(TAG_ID);
                String name = item.getString(TAG_NAME);
                String address = item.getString(TAG_ADDRESS);

                if(id.equals("1")) {
                    if(address.equals("0")) {
                        txt1.setText("1");
                        txt1_="1";
                    }
                    else{
                        txt1.setTextColor(Color.parseColor("#FFFF0000"));
                        txt1.setText("0");
                        txt1_="0";
                    }
                    txt2.setText(txt2_);
                    txt3.setText(txt3_);
                }
                else if(id.equals("2")) {
                    if(address.equals("0")) {
                        txt2.setText("1");
                        txt2_="1";
                    }
                    else{
                        txt2.setTextColor(Color.parseColor("#FFFF0000"));
                        txt2.setText("0");
                        txt2_="0";
                    }
                    txt1.setText(txt1_);
                    txt3.setText(txt3_);
                }
                else if(id.equals("3")) {
                    if(address.equals("0")) {
                        txt3.setText("1");
                        txt3_="1";
                    }
                    else{
                        txt3.setTextColor(Color.parseColor("#FFFF0000"));
                        txt3.setText("0");
                        txt3_="0";
                    }
                    txt1.setText(txt1_);
                    txt2.setText(txt2_);
                }
                HashMap<String,String> hashMap = new HashMap<>();

                hashMap.put(TAG_ID, id);
                hashMap.put(TAG_NAME, name);
                hashMap.put(TAG_ADDRESS, address);

                mArrayList.add(hashMap);
            }
            */
        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }
}
