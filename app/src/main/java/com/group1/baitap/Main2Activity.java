package com.group1.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String KEY_NAME = "NAME";
    public static final String KEY_MA = "MA";
    public static final String KEY_GT = "GT";
    ImageView imgGioiTinh;
    TextView tvName,tvMa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        setData();
    }

    private void setData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(KEY_NAME);
        String ma = intent.getStringExtra(KEY_MA);
        int gt = intent.getIntExtra(KEY_GT,0);
        if(gt == 1){
            imgGioiTinh.setImageResource(R.drawable.people64);
        }else {
            imgGioiTinh.setImageResource(R.drawable.woman64);
        }
        tvName.setText(name);
        tvMa.setText(ma);
    }

    private void init() {
        imgGioiTinh = (ImageView) findViewById(R.id.imgGioiTinh);
        tvName = (TextView) findViewById(R.id.tvName);
        tvMa = (TextView) findViewById(R.id.tvMa);
    }



}
