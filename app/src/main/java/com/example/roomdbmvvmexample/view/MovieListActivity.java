package com.example.roomdbmvvmexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.roomdbmvvmexample.R;
import com.example.roomdbmvvmexample.model.Movie;
import com.example.roomdbmvvmexample.model.MovieList;
import com.example.roomdbmvvmexample.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends AppCompatActivity {

    @BindView(R.id.movieRecyclerView)
    RecyclerView movieRecyclerView;

    @BindView(R.id.loading)
    ProgressBar loading;

    MovieListViewModel mMovieListViewModel;

    MoviesAdapter mMoviesAdapter = new MoviesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        mMovieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);


        mMovieListViewModel.getData();

        observeViewModel();

    }

    private void observeViewModel() {

        mMovieListViewModel.movies.observe(this, new Observer<List<MovieList>>() {
            @Override
            public void onChanged(List<MovieList> movies) {
                if (movies != null && movies instanceof List){
                    movieRecyclerView.setVisibility(View.VISIBLE);
                    mMoviesAdapter.updateList(movies);
                    loading.setVisibility(View.GONE);
                }
            }
        });


        mMovieListViewModel.loading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading != null && isLoading instanceof Boolean){
                    loading.setVisibility(isLoading ? View.VISIBLE : View.GONE);

                    if (isLoading){
                        loading.setVisibility(View.VISIBLE);
                        movieRecyclerView.setVisibility(View.GONE);
                    }
                }
            }
        });


    }
}
