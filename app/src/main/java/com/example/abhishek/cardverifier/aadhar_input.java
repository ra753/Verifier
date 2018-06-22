package com.example.abhishek.cardverifier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class aadhar_input extends AppCompatActivity {

    public void getAadharNum(View V)
    {
        EditText received_num = (EditText) findViewById(R.id.aadharnum);
        String aadhar_num = received_num.getText().toString();

        if (aadhar_num.equals(""))
        {
            Toast.makeText(this, "Enter AADHAR Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(aadhar_num.length() != 12)
        {
            Toast.makeText( this, "Valid AADHAR Number is of 12 Digits!", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent i = new Intent(getApplicationContext() , aadhar_result.class);
        i.putExtra("aadhar_num", aadhar_num );
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_input);
    }
}
