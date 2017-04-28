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
    private UserTable objUserTABLE;
    private BakeryTable objBakeryTABLE;
    private OrderTable objOrderTABLE;
    private CakeTable objCakeTABLE;
    private DrinkTable objDrinkTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectedSQLite();
        testAddValue();

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

    public void testAddValue(){
        objUserTABLE.addNewUser("testUser","testPass","testName","testEmail","testPhone","testAddress");
        objBakeryTABLE.addNewBakery("testBakery","testSource","testPrice");
        objOrderTABLE.addNewOrder("testOfficer","testBakery","testDate","testTotalPrice");
        objDrinkTABLE.addNewDrink("testDrink","testSource","testPrice");
        objCakeTABLE.addNewCake("testCake","testSource","testPrice");
    }

    private void connectedSQLite(){
        objUserTABLE = new UserTable(this);
        objBakeryTABLE = new BakeryTable(this);
        objOrderTABLE = new OrderTable(this);
        objCakeTABLE = new CakeTable(this);
        objDrinkTABLE = new DrinkTable(this);
    }



}
