package com.hnnh.engrinterview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hnnh.engrinterview.R;
import com.hnnh.engrinterview.model.User;
import com.hnnh.engrinterview.utils.Fibonacci;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.imgEmoji)
    ImageView imgEmoji;

    User user = new User();
    ArrayList<Integer> series = new ArrayList<>();
    String TAG = ResultActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        setup();
        action();
    }

    void setup() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user = (User) intent.getSerializableExtra("user");
        series = Fibonacci.getFibonacciNumbers();

        if (series.contains(user.getFavNumber())) {
            tvResult.setText(getString(R.string.hello)+"  " + user.getFirstName() + ", today is your lucky day with your favorite number " + user.getFavNumber() + ".");
            imgEmoji.setImageResource(R.drawable.luckyday);
        } else {
            tvResult.setText(getString(R.string.hello) + " Mr/Ms " + user.getLastName() + " I love " + user.getFavFoodName() + " too. Lets go get that for lunch today.");
            imgEmoji.setImageResource(R.drawable.lunch);
        }
    }

    void action(){
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
