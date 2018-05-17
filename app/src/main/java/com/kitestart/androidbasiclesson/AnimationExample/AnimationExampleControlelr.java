package com.kitestart.androidbasiclesson.AnimationExample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kitestart.androidbasiclesson.R;

public class AnimationExampleControlelr extends AppCompatActivity implements View.OnClickListener {

    Button clickBtn;
    ImageView googleImage;
    int height, width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_example_controlelr);
        setViews();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        clickBtn.setOnClickListener(this);
        googleImage.setOnClickListener(this);


    }
    void setViews(){
        clickBtn = findViewById(R.id.clickBtn);
        googleImage = findViewById(R.id.googleImage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clickBtn:
                googleImage.animate().rotation(360).setDuration(5000);
                break;
            case R.id.googleImage:
                googleImage.animate().rotation(360).y(200).setDuration(2500);
                googleImage.animate().rotation(-360).y(-200).setDuration(2500);
                break;
        }
    }
}
