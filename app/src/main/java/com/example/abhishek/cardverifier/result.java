package com.example.abhishek.cardverifier;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class result extends AppCompatActivity {

    public void luhn_checksum(char[] num, Context context , String str_num)
    {
        int integer_num[] =new int[num.length];

        for(int i = 0 ; i < num.length; i++)
        {
            integer_num[i] = Character.getNumericValue(num[i]);
        }

        //String s = Integer.toString(integer_num[2]);
        //Toast.makeText( context, s, Toast.LENGTH_SHORT).show();

        int mul=0 ,sum_even=0,sum_odd=0, total=0;

        for(int i=0;i<=14;i++)
        {
            if(i%2==0)  //if even place is encountered
            {
                mul=integer_num[i]*2;
                {
                    if(mul>9)
                    {
                        mul=mul-9;

                    }
                }
                sum_even=sum_even+mul;
            }
            else                //if even place is encountered
                sum_odd=sum_odd+integer_num[i];
        }
        total=sum_odd+sum_even+integer_num[15];

        int FLAG = 0;

        if(total % 10 == 0)
        {
            //Toast.makeText( context, "Genuine", Toast.LENGTH_SHORT).show();
            FLAG = 1;
        }
        //else
            //Toast.makeText( context, "Not Genuine", Toast.LENGTH_SHORT).show();


        //display(FLAG , str_num);

        ListView ls = findViewById(R.id.ls);

        ArrayList<String> detail = new ArrayList<>();

        detail.add("Entered Card Number :\n" + str_num);
        boolean further = false;

        if(FLAG == 1) {
            detail.add("Status : Genuine");
            further = true;
        }
        else
            detail.add("Status : Card is not Genuine");

        //Issuer:
        if(further == true)
        {
        if(integer_num[0]==5 && integer_num[1]==1 || integer_num[0]==5 && integer_num[1]==2 )
        {
            detail.add("Issuer : Master Card");
        }
        if(integer_num[0]==4)
        {
            detail.add("Issuer : Visa");
        }
        if(integer_num[0]==6 && integer_num[1]==0 || integer_num[0]==6 && integer_num[1]==5 && integer_num[2]==2)
        {
            detail.add("Issuer : RuPay");
        }
        //Major Industry Identifier

        if(integer_num[0] == 5 || integer_num[0] == 4)
        {
            detail.add("MII : Banking and financial");
        }
        if(integer_num[0] == 3)
        {
            detail.add("MII : Travel and Entertainment");
        }
        if(integer_num[0] == 6)
        {
            detail.add("MII : Merchandising and banking/financial");
        }
        if(integer_num[0] == 2)
        {
            detail.add("MII : Airlines, financial and other future industry assignments");
        }
        if(integer_num[0] == 0)
        {
            detail.add("MII : ISO/TC 68 and other industry assignments");
        }
        if(integer_num[0] == 7) {
            detail.add("MII : Petroleum and other future industry assignments");
        }
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_spinner_dropdown_item , detail);

        ls.setAdapter(adapter);

    }

    public void back(View view)
    {
        Intent i = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(i);
    }
    public void home(View v)
    {
        Intent i = new Intent(getApplicationContext() , front.class);
        startActivity(i);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String num = getIntent().getStringExtra("num");

        char[] final_num = num.toCharArray();

        luhn_checksum(final_num , getApplicationContext() , num);


    }

}
