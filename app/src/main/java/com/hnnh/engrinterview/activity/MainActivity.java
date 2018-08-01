package com.hnnh.engrinterview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hnnh.engrinterview.R;
import com.hnnh.engrinterview.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.etFirstName)
    EditText etFirstName;
    @BindView(R.id.tvErrFirstName)
    TextView tvErrorFirstName;
    @BindView(R.id.etLastName)
    EditText etLastName;
    @BindView(R.id.tvErrLastName)
    TextView tvErrLastName;
    @BindView(R.id.etFavFood)
    EditText etFavFood;
    @BindView(R.id.tvErrFavFood)
    TextView tvErrFavFood;
    @BindView(R.id.etFavNumber)
    EditText etFavNumber;
    @BindView(R.id.tvErrFavNumber)
    TextView tvErrFavNumber;
    @BindView(R.id.btnContinue)
    Button btnContinue;
    String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onContinueClickListener(View v) {
        Log.d(TAG, "continue Click Listener");
        if (checkError()) {
            User user = new User();
            user.setFirstName(etFirstName.getText().toString());
            user.setLastName(etLastName.getText().toString());
            user.setFavFoodName(etFavFood.getText().toString());
            user.setFavNumber(Integer.parseInt(etFavNumber.getText().toString()));
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }

    public boolean checkError() {
        if (etFirstName.getText().length() == 0 | etLastName.getText().length() == 0 | etFavNumber.getText().length() == 0 | etFavFood.getText().length() == 0) {
            if (etFirstName.getText().length() == 0) {
                tvErrorFirstName.setVisibility(View.VISIBLE);
            } else {
                tvErrorFirstName.setVisibility(View.INVISIBLE);
            }

            if (etLastName.getText().length() == 0) {
                tvErrLastName.setVisibility(View.VISIBLE);
            } else {
                tvErrLastName.setVisibility(View.INVISIBLE);
            }

            if (etFavFood.getText().length() == 0) {
                tvErrFavFood.setVisibility(View.VISIBLE);
            } else {
                tvErrFavFood.setVisibility(View.INVISIBLE);
            }

            if (etFavNumber.getText().length() == 0) {
                tvErrFavNumber.setVisibility(View.VISIBLE);
            } else {
                tvErrFavNumber.setVisibility(View.INVISIBLE);
            }
            return false;
        } else {
            tvErrorFirstName.setVisibility(View.INVISIBLE);
            tvErrLastName.setVisibility(View.INVISIBLE);
            tvErrFavFood.setVisibility(View.INVISIBLE);
            tvErrFavNumber.setVisibility(View.INVISIBLE);
            return true;
        }
    }
}
