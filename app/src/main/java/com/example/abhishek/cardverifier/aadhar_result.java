package com.example.abhishek.cardverifier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.abhishek.cardverifier.VerhoeffAlgorithm.validateAadharNumber;

public class aadhar_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_result);

        String num = getIntent().getStringExtra("aadhar_num");
        boolean result = validateAadharNumber(num);
        display(result , num);
    }

    public void display(boolean result, String s)
    {
        ListView ls = findViewById(R.id.aadhar_result_view);
        ArrayList<String> screen = new ArrayList<>(1);
        screen.add("Entered Number :" + s);
        if(result == true)
        {
            screen.add("AADHAR is Valid");
        }
        else
            screen.add("AADHAR is Invalid");
        ArrayAdapter<String> adaptr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , screen );
        ls.setAdapter(adaptr);
    }

    public void retry(View v)
    {
        Intent i = new Intent(getApplicationContext() , aadhar_input.class);
        startActivity(i);
    }
    public void home(View v)
    {
        Intent i = new Intent(getApplicationContext() , front.class);
        startActivity(i);
    }
}
