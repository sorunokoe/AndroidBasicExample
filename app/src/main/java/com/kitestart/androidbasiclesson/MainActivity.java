package com.kitestart.androidbasiclesson;

import android.app.Application;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout starsView;
    TextView resultTextView, loginLabel;
    Button btn1, btn2, btn3, btn4;
    ArrayList<Button> allBtn = new ArrayList();
    Random random = new Random();
    Integer number1, number2;
    char symbol;

    ArrayList<ImageView> allStars = new ArrayList();

    int level;

    String correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

        if(getIntent() != null && getIntent().getExtras() != null){
            String login = getIntent().getExtras().getString("login");
            if(login != null){
                loginLabel.setText(login);
            }
        }

        updateRandom();

        for(Button btn : allBtn){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button btn = (Button) v;
                    if(correctAnswer!=null && btn.getTag().equals(correctAnswer)){



                        ImageView star = new ImageView(MainActivity.this);
                        starsView.addView(star);
                        star.getLayoutParams().height = 100;
                        star.getLayoutParams().width = 100;
                        star.setAlpha(0.1f);
                        star.setImageResource(R.drawable.star);
                        allStars.add(star);
                        for(ImageView new_star : allStars){
                            new_star.setRotation(0);
                            new_star.animate().alpha(1.0f).rotation(360).setDuration(1000);
                        }
                        














                        updateRandom();
                    }else{
                        Toast.makeText(getApplicationContext(), "Mistake, choose another option.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




    }

    void updateRandom(){

        number1 = random.nextInt(10)+1;
        number2 = random.nextInt(10)+1;


        switch (random.nextInt(4)+1){
            case 1:
                symbol='+';
                break;
            case 2:
                symbol='-';
                break;
            case 3:
                symbol='*';
                break;
            default:
                symbol='/';
                break;
        }


        resultTextView.setText(number1.toString()+" "+symbol+" "+number2.toString()+" = ?");

        int randomOption = random.nextInt(4)+1;


        for(Button btn: allBtn){
            if( (randomOption) == new Integer(btn.getTag().toString())) {
                Integer result = new Integer(calculate(number1, number2, symbol));
                btn.setText(result.toString());
                correctAnswer = btn.getTag().toString();
            }else{
                int randNum = random.nextInt(number1*number2) + number1/number2;
                Integer result = new Integer(randNum);
                btn.setText(result.toString());
            }
        }

    }
    void setViews(){
        starsView = findViewById(R.id.starsLayout);
        resultTextView = findViewById(R.id.resultTextVIew);
        loginLabel =  findViewById(R.id.loginLabel);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        allBtn.add(btn1);
        allBtn.add(btn2);
        allBtn.add(btn3);
        allBtn.add(btn4);
    }
    int calculate(int num1, int num2, char symbol){
        switch (symbol){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            default:
                return num1/num2;
        }
    }

}
