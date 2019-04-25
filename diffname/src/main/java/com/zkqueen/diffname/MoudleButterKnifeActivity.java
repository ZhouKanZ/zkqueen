package com.zkqueen.diffname;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoudleButterKnifeActivity extends AppCompatActivity {

    @BindView(R2.id.button)
    Button button;
    @BindView(R2.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moudle_butter_knife);
        ButterKnife.bind(this);
    }
}
