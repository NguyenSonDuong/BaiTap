package com.group1.baitap;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.function.Predicate;

public class AdapteDS extends BaseAdapter {
    public static ArrayList<Integer> checkList = new ArrayList<>();
    Context context;
    ArrayList<NhanView> nhanViews;

    public AdapteDS(Context context, ArrayList<NhanView> nhanViews) {
        this.context = context;
        this.nhanViews = nhanViews;
    }

    @Override
    public int getCount() {
        return nhanViews.size();
    }

    @Override
    public Object getItem(int position) {
        return nhanViews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHoder viewHoder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item,parent,false);
            viewHoder = new ViewHoder();
            viewHoder.tvInfor = convertView.findViewById(R.id.tvInfor);
            viewHoder.checkDelete =  convertView.findViewById(R.id.checkDelete);
            viewHoder.imgGioiTinh =  convertView.findViewById(R.id.imgGioiTinh);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        final NhanView nhanView = nhanViews.get(position);
        viewHoder.checkDelete.setChecked(false);
        viewHoder.tvInfor.setText(nhanView.getMa()+" - "+nhanView.getTen());
        if(nhanView.getGioitinh() == 1){
            viewHoder.imgGioiTinh.setImageResource(R.drawable.people64);
        }else {
            viewHoder.imgGioiTinh.setImageResource(R.drawable.woman64);
        }
        viewHoder.checkDelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    nhanView.setCheck(viewHoder.checkDelete.isChecked());
            }
        });
        return convertView;
    }



    class ViewHoder{
        ImageView imgGioiTinh;
        TextView tvInfor;
        CheckBox checkDelete;
    }
}
