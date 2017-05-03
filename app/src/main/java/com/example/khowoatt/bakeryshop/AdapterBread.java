package com.example.khowoatt.bakeryshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by khowoatt on 1/5/2560.
 */

public class AdapterBread extends BaseAdapter{
    private Context context;
    private int[] ints;
    private String[] title,detail;

    public AdapterBread(Context context, int[] ints, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.title = titleStrings;
        this.detail = detailStrings;
    }


    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_bread,parent,false);

        //Initial view ผูกไอดีของ view กับตัวแปร
        ImageView imageView = (ImageView) view.findViewById(R.id.imvLbread);
        TextView titleTextView = (TextView) view.findViewById(R.id.txtBread);
        TextView detailTextView = (TextView) view.findViewById(R.id.txtDetailBread);

        //ShowView เอาข้อมูลไปแสดงผลบนหน้า App
        imageView.setImageResource(ints[position]);
        titleTextView.setText(title[position]);
        detailTextView.setText(detail[position]);
        return view;
    }

    /*private Context objContext;
    private String[] nameBakeryStrings,pictureStrings,priceStrings;

    public AdapterBread(Context objContext,String[] nameBakeryStrings,String[] pictureStrings,String[] priceStrings) {
        this.objContext = objContext;
        this.nameBakeryStrings = nameBakeryStrings;
        this.pictureStrings = pictureStrings;
        this.priceStrings = priceStrings;

    }

    @Override
    public boolean equals(Object obj) {
            return super.equals(obj);
    }

    @Override
    public int getCount() {
        return nameBakeryStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.listview_bread,parent,false);

        TextView nameTextView = (TextView) view.findViewById(R.id.txtBread);
        nameTextView.setText(nameBakeryStrings[position]);

        TextView priceTextView = (TextView) view.findViewById(R.id.txtDetailBread);
        priceTextView.setText(priceStrings[position]);

        ImageView pictureImageView = (ImageView) view.findViewById(R.id.imvLbread);
        Picasso.with(objContext).load(pictureStrings[position]).into(pictureImageView);
        return view;

    }*/
}
