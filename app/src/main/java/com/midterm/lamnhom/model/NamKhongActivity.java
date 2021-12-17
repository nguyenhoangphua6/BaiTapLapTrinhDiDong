package com.midterm.lamnhom.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.midterm.lamnhom.R;

public class NamKhongActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nam_khong);

        Intent i = getIntent();
        String text = i.getStringExtra("text");

        img = findViewById(R.id.imgByText);










        if(text.equals("namkhong")){
            img.setImageResource(R.drawable.namkhongimg);
        } else if (text.equals("trieuchung")){
            img.setImageResource(R.drawable.trieuchung);
        }
    }
}