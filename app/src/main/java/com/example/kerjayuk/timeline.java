package com.example.kerjayuk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class timeline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
    }

    public void klikGabung(View v) {
        Intent i;
        switch(v.getId())
        {
            case R.id.btncreatejob :
                i = new Intent(this, CreateJob.class);
                startActivity(i);
                break;
            case R.id.btnviewjob :
                i = new Intent(this, ViewJob.class);
                startActivity(i);
                break;
            case R.id.btnbckHome :
                i = new Intent(this, home.class);
                startActivity(i);
                break;
        }
    }
}