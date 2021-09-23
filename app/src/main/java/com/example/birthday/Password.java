package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Password extends AppCompatActivity {
    EditText et_password;
    Button b_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        et_password=findViewById(R.id.et_password);
        b_enter=findViewById(R.id.b_enter);
        b_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String input=et_password.getText().toString();
                String correct="2612";
                if(!input.equals("")){
                    if(input.equals(correct)){
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                    }
                }
                else{
                    Toast.makeText(Password.this, "You need correct password to enter the next level", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}