package com.example.tictactoegame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);
        btn7=findViewById(R.id.button7);
        btn8=findViewById(R.id.button8);
        btn9=findViewById(R.id.button9);
    }

    public void onClick(View view) {
        Button btnSelected=(Button)view;
        btnSelected.setClickable(false);

        int cellID = 0;
        switch ((view.getId())){
            case R.id.button1:
                cellID=1;
                break;
            case R.id.button2:
                cellID=2;
                break;
            case R.id.button3:
                cellID=3;
                break;
            case R.id.button4:
                cellID=4;
                break;
            case R.id.button5:
                cellID=5;
                break;
            case R.id.button6:
                cellID=6;
                break;
            case R.id.button7:
                cellID=7;
                break;
            case R.id.button8:
                cellID=8;
                break;
            case R.id.button9:
                cellID=9;
                break;
                default:
                    break;
        }

        playGame(cellID, btnSelected);
    }
    int activePlayer=1;    // 1 for player1 and 2 for player 2
    ArrayList<Integer> player1=new ArrayList<Integer>();  //hold player 1 data
    ArrayList<Integer> player2=new ArrayList<Integer>();  //hold player 2 data

    void playGame(int cellId, final Button btnSelected){


        if(checkWinner()==-1);
        if(activePlayer==1){
            player1.add(cellId);
            btnSelected.setText("X");
            btnSelected.setBackgroundColor(Color.YELLOW);
            activePlayer=2;
        }
        else if (activePlayer==2){
            player2.add(cellId);
            btnSelected.setText("O");
            btnSelected.setBackgroundColor(Color.BLUE);
            activePlayer=1;
        }
        if(checkWinner()==1 || checkWinner()==2){
            final AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Game Over");
            builder.setMessage("Player "+ winner+" Wins.");

            builder.setPositiveButton("Play again?", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    restartGame();
                }
            });
            builder.setNegativeButton("Exit?", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    System.exit(0);
                }
            });
            final AlertDialog alertDialog=builder.show();
        }
    }
    int winner=-1;
    int checkWinner(){
                //rows
                if(player1.contains(1) && player1.contains(2) && player1.contains(3)
                || player1.contains(4) && player1.contains(5) && player1.contains(6)
                || player1.contains(7) && player1.contains(8) && player1.contains(9)
                 //rows
                || player1.contains(1) && player1.contains(4) && player1.contains(7)
                || player1.contains(2) && player1.contains(5) && player1.contains(8)
                || player1.contains(3) && player1.contains(6) && player1.contains(9)
                  //diagonals
                || player1.contains(1) && player1.contains(5) && player1.contains(9)
                || player1.contains(3) && player1.contains(5) && player1.contains(7)){
                    winner=1;
        }  else if(player2.contains(1) && player2.contains(2) && player2.contains(3)
                || player2.contains(4) && player2.contains(5) && player2.contains(6)
                || player2.contains(7) && player2.contains(8) && player2.contains(9)
                //rows
                || player2.contains(1) && player2.contains(4) && player2.contains(7)
                || player2.contains(2) && player2.contains(5) && player2.contains(8)
                || player2.contains(3) && player2.contains(6) && player2.contains(9)
                //diagonals
                || player2.contains(1) && player2.contains(5) && player2.contains(9)
                || player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2;
        }
                else
                {
                    winner=-1;
                }
                return winner;
    }

    private void restartGame(){
        activePlayer=1;
        winner=-1;
        player1.clear();
        player2.clear();

        btn1.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn2.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn3.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn4.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn5.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn6.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn7.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn8.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));
        btn9.setBackgroundColor(getResources().getColor(R.color.backgrounColor2));


        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        btn1.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        btn5.setClickable(true);
        btn6.setClickable(true);
        btn7.setClickable(true);
        btn8.setClickable(true);
        btn9.setClickable(true);
    }

    public void playAgain(View view) {
        restartGame();
    }
    public void quitGame(View view) {
        System.exit(0);
    }
    public void palyAgainClick(View v){
        restartGame();
    }
}

