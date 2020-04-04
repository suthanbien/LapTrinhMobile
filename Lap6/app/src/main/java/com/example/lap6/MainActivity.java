package com.example.lap6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHoTen;
    private EditText editTextCMND;
    private RadioGroup radioGroup;
    private RadioButton radioButtonTrungCap;
    private RadioButton radioButtonCaoDang;
    private RadioButton radioButtonDaiHoc;
    private LinearLayout linearLayout;
    private CheckBox checkBoxDocBao;
    private CheckBox checkBoxDocSach;
    private CheckBox checkBoxDocCode;
    private EditText editTextThem;
    private Button buttonGuiThongTin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHoTen = (EditText) findViewById(R.id.editText_HoTen);
        editTextCMND = (EditText) findViewById(R.id.editText_CMND);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonTrungCap = (RadioButton) findViewById(R.id.radioButton_TrungCap);
        radioButtonCaoDang = (RadioButton) findViewById(R.id.radioButton_CaoDang);
        radioButtonDaiHoc = (RadioButton) findViewById(R.id.radioButton_DaiHoc);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        checkBoxDocBao = (CheckBox) findViewById(R.id.checkBox_DocBao);
        checkBoxDocSach = (CheckBox) findViewById(R.id.checkBox_DocSach);
        checkBoxDocCode = (CheckBox) findViewById(R.id.checkBox_DocCode);
        editTextThem = (EditText) findViewById(R.id.editText_Them);
        buttonGuiThongTin = (Button) findViewById(R.id.button_GuiThongTin);

        buttonGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });

    }

    public void doShowInformation()
    {
        //Kiểm tra tên hợp lệ
        String ten=editTextHoTen.getText()+"";
        ten=ten.trim();
        if(ten.length()<3)
        {
            editTextHoTen.requestFocus();
            editTextHoTen.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
           return;
        }
        //kiểm tra CMND hợp lệ
        String cmnd=editTextCMND.getText()+"";
        cmnd=cmnd.trim();
        if(cmnd.length()!=9)
        {
            editTextCMND.requestFocus();
            editTextCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
           return;
        }
            //Kiểm tra bằng cấp
        String bang="";
        RadioGroup group=(RadioGroup) findViewById(R.id.radioGroup);
        int id=group.getCheckedRadioButtonId();
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
          return;
        }
        RadioButton rad=(RadioButton) findViewById(id);
        bang=rad.getText()+"";
        //Kiểm tra sở thích
        String sothich="";
        if(checkBoxDocBao.isChecked())
            sothich+=checkBoxDocBao.getText()+"\n";
        if(checkBoxDocSach.isChecked())
            sothich+=checkBoxDocSach.getText()+"\n";
        if(checkBoxDocCode.isChecked())
            sothich+=checkBoxDocCode.getText()+"\n";
        String bosung=editTextThem.getText()+"";


        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub
                dialog.cancel();
            }
        });
        //tạo nội dung
                String msg=ten+"\n";
                msg+= cmnd+"\n";
                msg+=bang+"\n";
                msg+=sothich;
                msg+="—————————–\n";
                msg+="Thông tin bổ sung:\n";
                msg+=bosung+ "\n";
                msg+="—————————–";
                builder.setMessage(msg);//thiết lập nội dung
                builder.create().show();//hiển thị Dialog
            }

}
