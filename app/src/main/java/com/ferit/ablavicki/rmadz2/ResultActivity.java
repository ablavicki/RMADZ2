package com.ferit.ablavicki.rmadz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    static double valueInput;
    static double valueResult;
    static int convertFrom;
    static int convertTo;
    static int fragmentPosition;
    static String unitArrayFrom;
    static String unitArrayTo;

    @BindView(R.id.tvValueInput)
    TextView tvValueInput;

    @BindView(R.id.tvValueResult)
    TextView tvValueResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);


        final Intent intent = new Intent(getIntent());
        fragmentPosition = intent.getIntExtra("fragmentPosition", fragmentPosition);
        valueInput = intent.getDoubleExtra("valueInput", valueInput);
        valueResult = intent.getDoubleExtra("valueResult", valueResult);
        convertFrom = intent.getIntExtra("convertFrom", convertFrom);
        convertTo = intent.getIntExtra("convertTo", convertTo);
        switch(fragmentPosition){
            case 0:
                unitArrayFrom = getResources().getStringArray(R.array.length_units)[convertFrom];
                unitArrayTo = getResources().getStringArray(R.array.length_units)[convertTo];
                break;
            case 1:
                unitArrayFrom = getResources().getStringArray(R.array.speed_units)[convertFrom];
                unitArrayTo = getResources().getStringArray(R.array.speed_units)[convertTo];
                break;
            case 2:
                unitArrayFrom = getResources().getStringArray(R.array.temperature_units)[convertFrom];
                unitArrayTo = getResources().getStringArray(R.array.temperature_units)[convertTo];
                break;
            case 3:
                unitArrayFrom = getResources().getStringArray(R.array.weight_units)[convertFrom];
                unitArrayTo = getResources().getStringArray(R.array.weight_units)[convertTo];
                break;
        }

        tvValueInput.setText(Double.toString(valueInput) + " " + unitArrayFrom);
        tvValueResult.setText(Double.toString(valueResult) + " " + unitArrayTo);
    }
}
