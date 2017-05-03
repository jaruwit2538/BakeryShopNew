package com.example.khowoatt.bakeryshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class BreadMenu extends AppCompatActivity {
    private ListView BreadlistView;
    private int[] ints = new int[]{R.drawable.bb1, R.drawable.bb2, R.drawable.bb3,
            R.drawable.bb4, R.drawable.bb5, R.drawable.bb6, R.drawable.bb7};
    private String[] title, detail,shortStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_menu);
        //bindWidget();
        //createListView();
        BreadlistView = (ListView) findViewById(R.id.livBread);

        //Get value
        title = getResources().getStringArray(R.array.title);
        detail = getResources().getStringArray(R.array.detail);

        //subStrings detailStrings ตัดคำในส่วนของ detail เพื่อให้ข้อความไม่เกิน 30 ตัวอักษร
       /* shortStrings = new String[detailStrings.length];//จองพื้นที่ในหน่วยความจำในตัวแปร shortStrings
        for (int i=0;i<detailStrings.length;i++){//เริ่มนับตั้งแต่ตัวแรกถึงตัวที่30แล้วตัดคำ
            shortStrings[i]=detailStrings[i].substring(0,29)+"...";//นับถึง30ตัวแล้วโยนจาก detailStrings ไป shortStrings หลังข้อความจะแสดงว่า ...

        }//end for */

        //create listview
        AdapterBread adapterBread = new AdapterBread(BreadMenu.this, ints, title, detail);//ตัวแปรที่ใช้ในหน้านี้
        BreadlistView.setAdapter(adapterBread);

        BreadlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//เมื่อมีการคลิ้ก้อมูลตำแหน่งใด จะเก็บตำแหน่งข้อมูลจากการคลิ้ก
                Intent intent = new Intent(BreadMenu.this,Detail.class);//ประกาศเรียกใช้ object .this คืออ้างถึง activity ที่ใช้ปัจจุบัน ส่งข้อมูลจากหน้า main ไปหน้า detail
                intent.putExtra("Title", title[position]);
                intent.putExtra("Detail",detail[position]);
                intent.putExtra("Image",ints[position]);
                startActivity(intent);
            }
        });

        //active when click listview ลิ้งไปหน้า detail เมื่อคลิ้กเลือก item


    }
    /*private void createListView() {
        BakeryTable objBakeryTable = new BakeryTable(this);
        String[] strName_bakery = objBakeryTable.readAllBakery(1);
        String[] strPicture_bakery = objBakeryTable.readAllBakery(2);
        String[] strPrice_bakery = objBakeryTable.readAllBakery(3);
        AdapterBread objAdapterBread = new AdapterBread(BreadMenu.this,strName_bakery,strPicture_bakery,strPrice_bakery);
        breadListView.setAdapter(objAdapterBread);
    }
    private void bindWidget() {
        breadListView = (ListView) findViewById(R.id.livBread);

    }*/
    public void onClickMenu (View view){
        Intent intent = new Intent(BreadMenu.this, Login.class);
        startActivity(intent);
    }
    public void onClickMain (View view){
        finish();
    }
}
