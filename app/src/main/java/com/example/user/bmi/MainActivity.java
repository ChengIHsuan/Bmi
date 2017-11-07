package com.example.user.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    String s = new String("abc");
    View.OnClickListener listener = new View.OnClickListener() {  //OnClickListener是介面
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button)findViewById(R.id.b_help);  //匿名類別
        bHelp.setOnClickListener(listener);  //執行listener的程式碼
        //getResources().getString(R.string.app_name);  //字串拉出來，彈性比較好
    }



    public void bmi(View view) {
        //   System.out.println("What???");   //sout快捷
        Log.d("MainActivity", "testing bmi method");
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        //EditText edWeight = findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
        float weight = Float.parseFloat(edWeight.getText().toString());
        //float weight = edWeight.getText().toString();
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);
        new AlertDialog.Builder(this)  //對話框
                //.setMessage("Your Bmi is " + bmi)  //訊息
                .setMessage(getString(R.string.your_bmi_is) + bmi)  //alt + enter
                .setPositiveButton(R.string.ok, null)  //正向按鈕 反向按鈕 中性按鈕(取消)
                .setTitle(R.string.bmi_title)  //標題
                .show();

        //Log.d("MainActivity", "Your BMI is : " + bmi);
    }

}
