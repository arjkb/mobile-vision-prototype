package com.example.android.mobilevisionprototype;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mImageView;
    Button mProcessButton;

    final String TAG = "MV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image);
        mProcessButton = (Button) findViewById(R.id.button);

        mProcessButton.setOnClickListener(this);

        getPics();
    }

    private void getPics() {
        Field[] drawables = R.drawable.class.getFields();

        for (Field f: drawables)    {
            try {
                Log.v(TAG, "getPics(): R.drawable." + f.getName());
            } catch (Exception E)   {
                Log.v(TAG, "getPics() EXCEPTION: " + E);
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())  {
            case R.id.button:
                Toast.makeText(this, "Process button clicked!", Toast.LENGTH_SHORT).show();
                detectText();
                break;
        }
    }

    public void detectText() {
        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();

        if(!textRecognizer.isOperational()) {
            Log.w(TAG, "Detector dependencies are not yet available!");

            IntentFilter lowStorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
            boolean hasLowStorage = registerReceiver(null, lowStorageFilter) != null;

            if (hasLowStorage)  {
                Toast.makeText(this, "Low storage! ", Toast.LENGTH_SHORT).show();
                Log.w(TAG, "Low storage!");
            }
        }

        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                                                     R.drawable.pic01_party);

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<TextBlock> textBlockSparseArray = textRecognizer.detect(frame);

        String detectedText = "";
        for (int i = 0; i < textBlockSparseArray.size(); i++) {
            TextBlock textBlock = textBlockSparseArray.valueAt(i);
            detectedText += textBlock.getValue();
            Log.v(TAG, " Text! " + textBlock.getValue());
        }

        Toast.makeText(this, detectedText, Toast.LENGTH_LONG).show();
    }
}

