package com.example.lap7_3_truyendulieuqualai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChildActivity extends AppCompatActivity {
    Button btnSave1;
    Button btnSave2;
    EditText editNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        btnSave1=findViewById(R.id.btnSave1);
        btnSave2=findViewById(R.id.btnSave2);
        editNumber=findViewById(R.id.edtNumber);
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gửi thông điệp là lưu bình phương
                 sendToMain(MainActivity.RESULT_CODE_SAVE1);
            }
        });
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gửi thông điệp là lưu số gốc
                sendToMain(MainActivity.RESULT_CODE_SAVE2);
            }
        });
    }
        /**
         * hàm xử lý gửi kết quả về mainactivity
         * khi hàm này được gọi thì lập tức onActivityResult
         * * ở MainActivity sẽ sảy ra đem theo ResultCode và Intent
         * * @param resultcode
         * */
        public void sendToMain(int resultcode)
        {
            Intent intent=getIntent();
            int value= Integer.parseInt(editNumber.getText()+"");
            intent.putExtra("data", value);
            setResult(resultcode, intent);
            finish();
        }
}
