package com.weytenera.xsq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.weytenera.xsq.R;
import com.weytenera.xsq.beans.Type;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class TypeAdapter extends BaseAdapter {

    ArrayList<Type> types=new ArrayList<>();
    Context context;

    public TypeAdapter(ArrayList<Type> types,Context context) {
        this.types=types;
        this.context=context;
    }

    @Override
    public int getCount() {
        return types.size();
    }

    @Override
    public Object getItem(int position) {
        return types.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.home_type_item,parent,false);

        }
        ((TextView)convertView.findViewById(R.id.txt_content)).setText(types.get(position).info);
        ((ImageView)convertView.findViewById(R.id.img_pic)).setImageResource(types.get(position).drawable);
        return convertView;
    }
}
