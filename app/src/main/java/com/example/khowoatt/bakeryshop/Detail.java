package com.example.khowoatt.bakeryshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //initial view ผูก view ที่หน้า ui ให้รู้จักกับตัวแปรบน java
        TextView titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        TextView detailTextView = (TextView) findViewById(R.id.txtDetailScroll);
        ImageView detailImageView = (ImageView) findViewById(R.id.imvImageDetail);
        Button button = (Button) findViewById(R.id.btnBack);

        //รับข้อมูลจาก main activity มาแสดงผลบน detail
        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));
        detailImageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.bb1));

    }//main method
    public void  clickBack(View view) {
        //ปุ่มคลิ้ก back เมื่อทำการคลิ้กปุ่ม back จะทำการกลับมาหน้า main และปิดหน้า detail
        finish();

    }
}//main class
