package com.example.alejo_i7.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    //se crean variables privadas TextView
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //se relacionan vbles con los textview del layout
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);

        // obtener mensaje del intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(MyActivity.EXTRA_MESSAGE2);
        String message3 = intent.getStringExtra(MyActivity.EXTRA_MESSAGE3);

            tv1.setText(message);
            tv2.setText(message2);

            //sumar dos numeros que se captan en el EditText
            int suma = (Integer.parseInt(message2) + Integer.parseInt(message3));
             String msg4 = String.valueOf(suma);
            tv3.setText(msg4);
        }
}
