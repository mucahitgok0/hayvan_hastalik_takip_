package com.mucahit.newpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mucahit.newpproject.data.entity.Hayvanlar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}