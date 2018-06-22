package com.example.abhishek.cardverifier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class front extends AppCompatActivity {

    public void payment(View V)
    {
        Intent i = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(i);
    }
    public void aadhar(View V)
    {
        Intent i = new Intent(getApplicationContext() , aadhar_input.class);
        startActivity(i);
    }

    public void about(View v)
    {
        ImageView pi = findViewById(R.id.abt);
        Intent i = new Intent(getApplicationContext() , About.class);
        startActivity(i);

    }
    public void pan(View v)
    {
        Toast.makeText(this, "Under Development, Coming soon", Toast.LENGTH_SHORT).show();
    }
    public void gst(View v)
    {
        Toast.makeText(this, "Under Development, Coming soon!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
    }
}
