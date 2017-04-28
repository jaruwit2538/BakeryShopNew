package com.example.khowoatt.bakeryshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DrinkMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);
    }
    public void onClickMenu (View view){
        Intent intent = new Intent(DrinkMenu.this, Login.class);
        startActivity(intent);
    }
    public void onClickMain (View view){
        finish();
    }
}
