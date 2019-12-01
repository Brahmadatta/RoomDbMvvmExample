package com.example.roomdbmvvmexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.roomdbmvvmexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends AppCompatActivity {

    @BindView(R.id.movieRecyclerView)
    RecyclerView movieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }
}
