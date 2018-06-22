package com.example.abhishek.cardverifier;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void check(View v)
    {
        EditText card_num = (EditText) findViewById(R.id.card_num);
        String num = card_num.getText().toString();
        //Toast.makeText(this, num, Toast.LENGTH_SHORT).show();

        if (num == null || num.equals(""))
        {
            Toast.makeText(this, "Enter Card Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(num.length() < 15 || num.length() > 16)
        {
            Toast.makeText( this, "Valid Card Number is of 16 Digits!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(getApplicationContext() , result.class);
        i.putExtra("num", num);
        startActivity(i);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
