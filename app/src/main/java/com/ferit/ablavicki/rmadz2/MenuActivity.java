package com.ferit.ablavicki.rmadz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.llLength)
    LinearLayout bLength;

    @BindView(R.id.llTemperature)
    LinearLayout bTemperature;

    @BindView(R.id.llSpeed)
    LinearLayout bSpeed;

    @BindView(R.id.llWeight)
    LinearLayout bWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.llLength)
    public void clickLength(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("value", 0);
        startActivity(intent);
    }

    @OnClick(R.id.llSpeed)
    public void clickSpeed(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("value", 1);
        startActivity(intent);
    }

    @OnClick(R.id.llTemperature)
    public void clickTemperature(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("value", 2);
        startActivity(intent);
    }



    @OnClick(R.id.llWeight)
    public void clickWeight(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("value", 3);
        startActivity(intent);
    }
}
