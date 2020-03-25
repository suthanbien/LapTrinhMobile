package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public  static  final String TAG="MyMessager ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //print log
        /*Log.i(TAG,"OnCreate");
        // Layout (Cách bố trí các thành phần trên giao diện).
        RelativeLayout layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.GREEN);

        // Tạo Button
        Button button = new Button(this);
        button.setText("My Button");

        // Thêm button vào Layout
        layout.addView(button);

        // Nội dung giao diện.
        setContentView(layout);*/
    }



    @Override
    protected void onStop() {
        super.onStop();
        //print log
        Log.i(TAG,"OnStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"OnResum");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"OnRestar");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"OnStar");
    }


}
