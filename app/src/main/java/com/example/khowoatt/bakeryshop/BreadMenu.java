package com.example.khowoatt.bakeryshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BreadMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_menu);
    }
    public void onClickMenu (View view){
        Intent intent = new Intent(BreadMenu.this, Login.class);
        startActivity(intent);
    }
    public void onClickMain (View view){
        finish();
    }
}
