package com.example.android.mobilevisionprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mImageView;
    Button mProcessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image);
        mProcessButton = (Button) findViewById(R.id.button);

        mProcessButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())  {
            case R.id.button:
                Toast.makeText(this, "Process button clicked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
