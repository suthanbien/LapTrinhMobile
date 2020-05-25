package com.example.baocaoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class dimen extends AppCompatActivity {
    private ImageView imgA;
    private ImageView imgW;
    private TextView txtDame,txtMau;
    private Button btnAttack;
    private  int wid=0;
    private  int hei=0;
    int mau=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimen);
        imgA = (ImageView) findViewById(R.id.imgA);
        imgW = (ImageView) findViewById(R.id.imgW);
        txtDame = (TextView) findViewById(R.id.txtDame);
        txtMau = (TextView) findViewById(R.id.txtMau);
        btnAttack = (Button) findViewById(R.id.btnAttack);
         wid=(int) getResources().getDimension(R.dimen.chieuRongQuai);
         hei=(int) getResources().getDimension(R.dimen.chieuDaiQuai);

        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Resources res =getResources();
                //tạo 1 biến color kiểu int
                int colorChiMang =res.getColor(R.color.colorChimang);
                int colorThuong=res.getColor(R.color.colorDameThuong);
                int dame = (r.nextInt((80-20)+1) + 20);

                if(dame >=70){
                    txtDame.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                            getResources().getDimension(R.dimen.chiMang));
                    txtDame.setTextColor(colorChiMang);
                }
                else {
                    txtDame.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                            getResources().getDimension(R.dimen.dameThuong));
                    txtDame.setTextColor(colorThuong);
                }
                txtDame.setText("-"+dame);
                mau=mau-dame;
                txtMau.setText(mau+"/500");
                if(mau<=0){
                    mau=500;
                    wid=(int) getResources().getDimension(R.dimen.chieuRongQuai);
                    hei=(int) getResources().getDimension(R.dimen.chieuDaiQuai);
                    txtMau.setText(mau+"/500");
                    txtDame.setText("");
                }

                wid=wid-dame;
                hei=hei-dame;
            imgA.getLayoutParams().width = wid;
            imgA.getLayoutParams().height = hei;
            imgA.requestLayout();

            }
        });
    }
}
