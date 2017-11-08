package com.example.berylsystem.sample_prash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.berylsystem.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView NAME,ROLLNO,MOBILE,ETCLASS;
        ImageButton removeDataButton;
    }


    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME=(TextView) row.findViewById(R.id.text_name);
            layoutHandler.ROLLNO=(TextView) row.findViewById(R.id.text_rollno);
            layoutHandler.MOBILE=(TextView) row.findViewById(R.id.text_mobile);
            layoutHandler.ETCLASS=(TextView) row.findViewById(R.id.text_etclass);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler=(LayoutHandler) row.getTag();
            //layoutHandler.removeDataButton=(ImageButton) row.findViewById(R.id.removeButton);
        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.ROLLNO.setText(dataProvider.getRollno());
        layoutHandler.MOBILE.setText(dataProvider.getMobile());
        layoutHandler.ETCLASS.setText(dataProvider.getEtclass());

        //layoutHandler.removeDataButton=(ImageButton) row.findViewById(R.id.removeButton);



        return row;
    }
}