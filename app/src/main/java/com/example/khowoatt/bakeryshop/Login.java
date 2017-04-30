package com.example.khowoatt.bakeryshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button mDaiLogLogin;
    Button mDaiLogRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDaiLogLogin = (Button) findViewById(R.id.btnLinkLogin);
        mDaiLogRegister = (Button) findViewById(R.id.btnLinkCreate);



        String text = getString(R.string.seemenu);
        String linkText = getString(R.string.menu);
        int start = text.indexOf(linkText);
        int end = start + linkText.length();

        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new CallToast(), start, end, 0);

        TextView textView = (TextView) findViewById(R.id.tilLogin);
        textView.setText(spannableString);
        textView.setMovementMethod(new LinkMovementMethod());

        mDaiLogRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDaiLogRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(Login.this);
                        LayoutInflater inflater = getLayoutInflater();

                        View view = inflater.inflate(R.layout.dialog_register, null);
                        builder.setView(view);

                        final EditText username = (EditText) view.findViewById(R.id.usernameR);
                        final EditText password = (EditText) view.findViewById(R.id.passwordR);
                        final EditText phone = (EditText) findViewById(R.id.phone);
                        final EditText address = (EditText) findViewById(R.id.addreass);
                        final EditText email = (EditText) findViewById(R.id.email);
                        final EditText facebook = (EditText) findViewById(R.id.facebook);

                        builder.setPositiveButton("Register", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Check username password
                                if (username.getText().equals("demo@example.com") &&
                                        password.getText().equals("demo") && phone.getText().equals("demo") &&
                                        address.getText().equals("demo") && email.getText().equals("demo") &&
                                        facebook.getText().equals("demo")
                                        ) {
                                    Toast.makeText(getApplicationContext(), "Register success!",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Login Failed!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create();

                        builder.show();
                    }
                });

            }
        });

        mDaiLogLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(Login.this);
                LayoutInflater inflater = getLayoutInflater();

                View view = inflater.inflate(R.layout.dialog_custom, null);
                builder.setView(view);

                final EditText username = (EditText) view.findViewById(R.id.username);
                final EditText password = (EditText) view.findViewById(R.id.password);

                builder.setPositiveButton("Login", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Check username password
                        if (username.getText().equals("demo@example.com") &&
                                password.getText().equals("demo")) {
                            Toast.makeText(getApplicationContext(), "Login success!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create();

                builder.show();
            }
        });
    }


    private class CallToast extends ClickableSpan {
        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }
    }



}