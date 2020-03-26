package com.group1.baitap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {

    EditText edtMa,edtTen;
    Button btnAdd;
    ImageView imgDelete;
    ListView lvDS;
    ArrayList<NhanView> nhanViews;
    AdapteDS adapteDS;
    RadioButton rdNam,rdNu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();
        lvDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NhanView nhanView = nhanViews.get(position);
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(Main2Activity.KEY_NAME,nhanView.getTen());
                intent.putExtra(Main2Activity.KEY_MA,nhanView.getMa());
                intent.putExtra(Main2Activity.KEY_GT,nhanView.getGioitinh());
                startActivity(intent);
            }
        });
    }

    private void setEvent() {
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                nhanViews.removeIf(new Predicate<NhanView>() {
                    @Override
                    public boolean test(NhanView nhanView) {
                        return (nhanView.isCheck());
                    }
                });
                adapteDS.notifyDataSetChanged();
            }

        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = edtMa.getText().toString();
                String ten = edtTen.getText().toString();
                int sex =1;
                if(rdNam.isChecked()){
                    sex = 1;
                }else {
                    sex = 0;
                }
                NhanView nhanView = new NhanView(ma,ten,sex);
                nhanViews.add(nhanView);
                adapteDS.notifyDataSetChanged();
            }
        });

    }

    private void init() {
        edtMa = (EditText) findViewById(R.id.edtMa);
        edtTen = (EditText) findViewById(R.id.edtTen);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        imgDelete = (ImageView) findViewById(R.id.imgDelete);
        lvDS = (ListView) findViewById(R.id.lvDS);
        rdNu = (RadioButton) findViewById(R.id.rdNu);
        rdNam = (RadioButton) findViewById(R.id.rdNam);
        nhanViews = new ArrayList<>();
        adapteDS = new AdapteDS(this,nhanViews);
        lvDS.setAdapter(adapteDS);
    }

}
