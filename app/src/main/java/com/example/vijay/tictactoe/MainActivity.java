package com.example.vijay.tictactoe;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player1=1;
    int[] noDoubleClick={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameState=true;
    public void clicked (View view)
    {
        Button anyButton = (Button) view;

        //player1=x  and player2 = o


        int Tag=Integer.parseInt(anyButton.getTag().toString());
        if (noDoubleClick[Tag-1]==2&&gameState) {
            noDoubleClick[Tag-1]=player1;


            if (player1 == 1) {
                anyButton.setBackgroundResource(R.drawable.x);
                anyButton.animate().rotation(360f);
                player1 = 0;
            } else {
                anyButton.setBackgroundResource(R.drawable.o);
                anyButton.animate().rotation(360f);
                player1 = 1;

            }
        }
        for (int[] winningposition : winningPositions)
        {
            if(noDoubleClick[winningposition[0]]==noDoubleClick[winningposition[1]] && noDoubleClick[winningposition[1]]==noDoubleClick[winningposition[2]]&&noDoubleClick[winningposition[0]] !=2){
                TextView text = findViewById(R.id.editText2);
                text.animate().scaleY(2f).scaleX(1.5f).setDuration(2000);
                text.setVisibility(View.VISIBLE);
                if (noDoubleClick[winningposition[0]]==1)
                    text.setText("X has won");
                else text.setText("O has won");

                ImageView Layout = findViewById(R.id.layout1);
                Layout.setVisibility(View.VISIBLE);


                ImageView exit = findViewById(R.id.exit);
                exit.setVisibility(View.VISIBLE);
                gameState=false;




            }


            }

                if (noDoubleClick[0]!=2&&noDoubleClick[1]!=2&&noDoubleClick[2]!=2&&noDoubleClick[3]!=2&&noDoubleClick[4]!=2&&noDoubleClick[5]!=2&&noDoubleClick[6]!=2&&noDoubleClick[7]!=2&&noDoubleClick[8]!=2){
                    ImageView Image = findViewById(R.id.layout1);
                    Image.setVisibility(View.VISIBLE);
                    TextView text = findViewById(R.id.editText2);
                    text.animate().scaleY(2f).scaleX(1.5f).setDuration(2000);
                    text.setVisibility(View.VISIBLE);
                    text.setText("It is a tie");

                    ConstraintLayout Clayout = findViewById(R.id.reDraw);
                    Clayout.animate().alpha(0.2f);
                    Image.animate().alpha(1f);

                    ImageView exit = findViewById(R.id.exit);
                    exit.setVisibility(View.VISIBLE);
                    gameState=false;
                }
            }






    public void playAgain (View view){
        gameState=true;

        ImageView exit = findViewById(R.id.exit);
        exit.setVisibility(View.INVISIBLE);
        TextView text = findViewById(R.id.editText2);
        text.setVisibility(View.INVISIBLE);
        text.animate().scaleX(1f).scaleY(1f);
        ImageView Layout = findViewById(R.id.layout1);
        Layout.setVisibility(View.INVISIBLE);
        player1=1;
        for (int i=0;i<noDoubleClick.length;i++) {
            noDoubleClick[i] = 2;
        }
        ConstraintLayout Clayout=findViewById(R.id.reDraw);
        Clayout.animate().alpha(1f);
        for (int i=0;i<Clayout.getChildCount();i++) {
            Clayout.getChildAt(i).setBackgroundResource(0);
            Clayout.getChildAt(i).setBackgroundColor(0);

        }


    }

    public void exit (View view){
        finish();
        System.exit(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
