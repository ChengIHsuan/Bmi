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
//    View.OnClickListener listener = new View.OnClickListener() {  //OnClickListener是介面
//        @Override
//        public void onClick(View view) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button)findViewById(R.id.b_help);

        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連。由於BMI主要反應整體體重，無法區別體重中體脂肪組織與非脂肪組織（包括肌肉、器官），同樣身高體重的人可算出相同的BMI，但其實脂肪量不同[1]，因此其實BMI是整體營養狀態的指標。以往拿來做為肥胖的指標，是因發現BMI與體脂肪在統計上有高度相關；但在同樣BMI之下，仍會有體脂肪率的差異。")
                        .setTitle("BMI的統計意義")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });  //匿名類別

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
        

        if (bmi<20){
            new AlertDialog.Builder(this)  //對話框
                    .setMessage("Your Bmi is " + bmi +" ,請多吃點!")  //訊息
                    .setPositiveButton(R.string.ok, null)  //正向按鈕 反向按鈕 中性按鈕(取消)
                    .setTitle(R.string.bmi_title)  //標題
                    .show();
        }else {

            new AlertDialog.Builder(this)  //對話框
                    //.setMessage("Your Bmi is " + bmi)  //訊息
                    .setMessage(getString(R.string.your_bmi_is) + bmi)  //alt + enter
                    .setPositiveButton(R.string.ok, null)  //正向按鈕 反向按鈕 中性按鈕(取消)
                    .setTitle(R.string.bmi_title)  //標題
                    .show();
        }

        //Log.d("MainActivity", "Your BMI is : " + bmi);
    }

}
