package com.example.cspclab.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.SpannableStringBuilder;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        String str = "당신의 팬티, 옷, 인생을 살릴 앱";
        TextView tv = (TextView)findViewById(R.id.text_main);
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#00ffff")), 10, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ssb);


    }
    //Button을 클릭했을 때 호출되는 callback 메소드

    public void mOnClick(View v){

        Intent i;

        switch(v.getId()){

            case R.id.btn_server: // 메인 화면에서 접속하기 버튼 눌렀을 경우 ---> 로그인 화면

                i= new Intent(this, LoginActivity.class);

                startActivity(i);

                break;

            case R.id.btn_client: //메인 화면에서 종료하기 버튼 눌렀을 경우  ----> 종료
                i= new Intent(this, MainActivity2.class);

                startActivity(i);

                break;
                //i= new Intent(this, ClientActivity.class);

                //startActivity(i);

                //break;
            case R.id.btn_exit:
                moveTaskToBack(true);

                finish();

                android.os.Process.killProcess(android.os.Process.myPid());

        }

    }

}
