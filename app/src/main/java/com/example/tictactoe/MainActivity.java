package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            ColorDrawable colorActionBar=new ColorDrawable(Color.parseColor("blue"));
            getSupportActionBar().setBackgroundDrawable(colorActionBar);
        }
        catch(Exception e){}

        Intent startGame=new Intent(MainActivity.this,gameStart.class);

        EditText edt1=findViewById(R.id.edt_1);
        EditText edt2=findViewById(R.id.edt_2);

        Button bt=findViewById(R.id.ent_btn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edt1.getText().toString().isEmpty() && !edt2.getText().toString().isEmpty()){
                    String ply1=edt1.getText().toString().toUpperCase();
                    String ply2=edt2.getText().toString().toUpperCase();
                    startGame.putExtra("player1_name",ply1);
                    startGame.putExtra("player2_name",ply2);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            edt1.setText("");
                            edt2.setText("");
                        }
                    },1000);
                    startActivity(startGame);
                }
            }
        });

    }
}