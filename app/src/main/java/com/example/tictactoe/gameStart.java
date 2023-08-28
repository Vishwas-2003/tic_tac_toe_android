package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class gameStart extends AppCompatActivity {
    int flag=0,count=0;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView p1_ch,p2_ch;

    TextView p1_score,p2_score;

    String plr_1,plr_2,b1_txt,b2_txt,b3_txt,b4_txt,b5_txt,b6_txt,b7_txt,b8_txt,b9_txt;

    int player1_score=0;
    int player2_score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        try{
            ColorDrawable colorActionBar=new ColorDrawable(Color.parseColor("blue"));
            getSupportActionBar().setBackgroundDrawable(colorActionBar);
        }
        catch(Exception e){}
        init();
    }

    public void init(){
        b1=findViewById(R.id.gb1);
        b2=findViewById(R.id.gb2);
        b3=findViewById(R.id.gb3);
        b4=findViewById(R.id.gb4);
        b5=findViewById(R.id.gb5);
        b6=findViewById(R.id.gb6);
        b7=findViewById(R.id.gb7);
        b8=findViewById(R.id.gb8);
        b9=findViewById(R.id.gb9);

        p1_ch=findViewById(R.id.pl1_c);
        p2_ch=findViewById(R.id.pl2_c);

        Intent fromMain=getIntent();
        plr_1=fromMain.getStringExtra("player1_name");
        plr_2=fromMain.getStringExtra("player2_name");

        p1_score=findViewById(R.id.scr_p1);
        p2_score=findViewById(R.id.scr_p2);

        p1_ch.setText(plr_1 + ": X");
        p2_ch.setText(plr_2 + ": O");

        player1_score=0;
        player2_score=0;

        p1_score.setText(plr_1+": "+player1_score);
        p2_score.setText(plr_2+": "+player2_score);
    }
    public void check(View v){
        Button b= (Button) v;

        if (b.getText().toString().isEmpty()) {
            if (flag==0) {
                b.setText("X");
                flag = 1;
            }
            else{
                b.setText(("O"));
                flag = 0;
            }
            count++;
        }

        if(count>4){
            b1_txt=b1.getText().toString();
            b2_txt=b2.getText().toString();
            b3_txt=b3.getText().toString();
            b4_txt=b4.getText().toString();
            b5_txt=b5.getText().toString();
            b6_txt=b6.getText().toString();
            b7_txt=b7.getText().toString();
            b8_txt=b8.getText().toString();
            b9_txt=b9.getText().toString();


//        Conditons

            if(b1_txt.equals(b2_txt) && b2_txt.equals(b3_txt) && !b1_txt.equals("")){
                setColor(b1,b2,b3);
                if(b1_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b4_txt.equals(b5_txt) && b5_txt.equals(b6_txt) && !b6_txt.equals("")){
                setColor(b4,b5,b6);
                if(b4_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b7_txt.equals(b8_txt) && b8_txt.equals(b9_txt) && !b9_txt.equals("")){
                setColor(b7,b8,b9);
                if(b7_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b1_txt.equals(b4_txt) && b4_txt.equals(b7_txt) && !b7_txt.equals("")){
                setColor(b1,b4,b7);
                if(b1_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b2_txt.equals(b5_txt) && b5_txt.equals(b8_txt) && !b8_txt.equals("")){
                setColor(b2,b5,b8);
                if(b2_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b3_txt.equals(b6_txt) && b6_txt.equals(b9_txt) && !b6_txt.equals("")){
                setColor(b3,b6,b9);
                if(b3_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b1_txt.equals(b5_txt) && b5_txt.equals(b9_txt) && !b9_txt.equals("")){
                setColor(b1,b5,b9);
                if(b1_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(b3_txt.equals(b5_txt) && b5_txt.equals(b7_txt) && !b7_txt.equals("")){
                setColor(b3,b5,b7);
                if(b7_txt.equals("X"))
                    player1Win();
                else
                    player2Win();
            }
            else if(count==9){
                Toast.makeText(this, "Match Draw", Toast.LENGTH_SHORT).show();
                newGame();
            }
        }
    }
    public void setColor(View v1,View v2,View v3){
        v1.setBackgroundColor(Color.YELLOW);
        v2.setBackgroundColor(Color.YELLOW);
        v3.setBackgroundColor(Color.YELLOW);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                v1.setBackgroundColor(Color.rgb(187,134,252));
                v2.setBackgroundColor(Color.rgb(187,134,252));
                v3.setBackgroundColor(Color.rgb(187,134,252));
            }
        },1000);
    }
    public void player1Win(){
        player1_score+=1;
        p1_score.setText(plr_1+": "+player1_score);
        p2_score.setText(plr_2+": "+player2_score);
        checkFinalResult(1);
    }
    public void player2Win(){
        player2_score+=1;
        p1_score.setText(plr_1+": "+player1_score);
        p2_score.setText(plr_2+": "+player2_score);
        checkFinalResult(2);
    }
    public void checkFinalResult(int Winner){
        if(player1_score==3){
            Toast.makeText(this, "Winner is " + plr_1 + "\nThankyou for playing", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            },2000);
        }
        else if (player2_score==3) {
            Toast.makeText(this, "Winner is " + plr_2 + "\nThankyou for playing", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            },2000);
        }
        else if(Winner==1){
            Toast.makeText(this, plr_1+" won this round", Toast.LENGTH_SHORT).show();
            newGame();
        }
        else if (Winner==2){
            Toast.makeText(this, plr_2+" won this round", Toast.LENGTH_SHORT).show();
            newGame();
        }
    }
    public void newGame(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");
            }
        },1000);

        flag=0;
        count=0;
    }
}