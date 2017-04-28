package com.example.khowoatt.bakeryshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        String text = getString(R.string.seemenu);
        String linkText = getString(R.string.menu);
        int start = text.indexOf(linkText);
        int end = start + linkText.length();

        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new CallToast(), start, end, 0);

        TextView textView = (TextView) findViewById(R.id.tilLogin);
        textView.setText(spannableString);
        textView.setMovementMethod(new LinkMovementMethod());
    }

    private class CallToast extends ClickableSpan {
        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }
    }
}