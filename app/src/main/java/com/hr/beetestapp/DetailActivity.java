package com.hr.beetestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String hola = getIntent().getStringExtra("img");
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        ImageView image = findViewById(R.id.imageView2);
        TextView tv = findViewById(R.id.textView3);
        TextView tv2 = findViewById(R.id.textView4);
        Glide.with(this).load(hola).into(image);
        tv.setText(name);
        tv2.setText(desc);
    }
}