package com.example.khowoatt.bakeryshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickCake (View view){
        Intent intent = new Intent(MainActivity.this,CakeMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Cake
    public void onClickBread (View view){
        Intent intent= new Intent(MainActivity.this,BreadMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu bread
    public void onClickDrinks (View view){
        Intent intent= new Intent(MainActivity.this,DrinkMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Drink
    public void onClickLogin (View view){
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }//ลิ้งกลับหน้า login



}
