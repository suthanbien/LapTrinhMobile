package com.example.lap7_3_truyendulieuqualai;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_INPUT=113;
    public static final int RESULT_CODE_SAVE1=115;
    public static final int RESULT_CODE_SAVE2=116;
    Button btnInputData;
    ListView lvData;
    ArrayList<Integer> arrData=new ArrayList<Integer>();
    ArrayAdapter<Integer> adapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInputData=findViewById(R.id.btnMoActivity);
        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mở Activity với REQUEST_CODE_INPUT
                Intent intent=new Intent(MainActivity.this, ChildActivity.class);
                //gọi startActivityForResult
                startActivityForResult(intent, REQUEST_CODE_INPUT);


            }
        });
        //đoạn code dưới này học nhiều rồi, ko nói lại
        lvData=(ListView) findViewById(R.id.lvData);

        adapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, arrData);
        lvData.setAdapter(adapter);
    }

    //xử lý kết quả trả về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Kiểm tra có đúng requestCode =REQUEST_CODE_INPUT hay không
        //Vì ta có thể mở Activity với những RequestCode khác nhau
        if(requestCode==REQUEST_CODE_INPUT) {
            //Kiểm trả ResultCode trả về, cái này ở bên InputDataActivity truyền về
            //có nó rồi thì xử lý trở lên thông thường
            switch (resultCode) {
                case RESULT_CODE_SAVE1:
                    //giá trị từ InputDataActivity
                    int v1 = data.getIntExtra("data", 0);
                    arrData.add(v1 * v1);
                    adapter.notifyDataSetChanged();
                    break;
                case RESULT_CODE_SAVE2:
                    //giá trị từ InputDataActivity
                    int v2 = data.getIntExtra("data", 0);
                    arrData.add(v2);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
