package com.example.alejo_i7.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.alejo_i7.myfirstapp.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "com.example.alejo_i7.myfirstapp.MESSAGE2";
    public final static String EXTRA_MESSAGE3 = "com.example.alejo_i7.myfirstapp.MESSAGE3";

    @Bind(R.id.edit_message) EditText etmsg1;
    @Bind(R.id.edit_message2) EditText etmsg2;
    @Bind(R.id.edit_message3) EditText etmsg3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_send)
    public void btnsend(View view){
        String msg1 = etmsg1.getText().toString().trim();
        String msg2 = etmsg2.getText().toString().trim();
        String msg3 = etmsg3.getText().toString().trim();

        //esconder el teclado al presionar el boton
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        //para mirar que todos los campos esten llenos
        if(msg1.length() > 0 && msg2.length() > 0 && msg3.length() > 0){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //primer dato
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString().trim();
        intent.putExtra(EXTRA_MESSAGE, msg1);

        //2do dato
        //EditText editText2 = (EditText) findViewById(R.id.edit_message2);
        //String message2 = editText2.getText().toString().trim();
        intent.putExtra(EXTRA_MESSAGE2, msg2);

        //3er dato
        //EditText editText3 = (EditText) findViewById(R.id.edit_message3);
        //String message3 = editText3.getText().toString().trim();
        intent.putExtra(EXTRA_MESSAGE3, msg3);

        //comienza actividad
        startActivity(intent);}
        else{
            showError("todos los campos son necesarios", view);
        }
    }

    //metodo para mostrar el error en snackbar
    private void showError(String error, View view) {
        Snackbar snackbar = Snackbar.make(view, error, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


}
