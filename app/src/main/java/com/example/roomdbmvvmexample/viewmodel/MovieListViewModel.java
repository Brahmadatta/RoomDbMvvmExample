package com.example.roomdbmvvmexample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.roomdbmvvmexample.model.Movie;
import com.example.roomdbmvvmexample.model.MovieList;
import com.example.roomdbmvvmexample.network.MovieAPIService;
import com.example.roomdbmvvmexample.network.MovieApi;
import com.example.roomdbmvvmexample.utils.AppConfig;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieListViewModel extends AndroidViewModel {

    public MutableLiveData<List<MovieList>> movies = new MutableLiveData<List<MovieList>>();

    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    MovieAPIService mMovieAPIService = new MovieAPIService();

    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    MovieApi mMovieApi;

    Single<Movie> movieSingle;


    public MovieListViewModel(@NonNull Application application) {
        super(application);
    }

    public void getData() {


       // MovieAPIService movieAPIService = mMovieApi.getMoviesList(AppConfig.API_KEY);




        mCompositeDisposable.add(
                mMovieAPIService.getMoviesList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Movie>() {
                    @Override
                    public void onSuccess(Movie movie) {
                        List<MovieList> movieLists = movie.getMovie_results();
                        movies.setValue(movieLists);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                })
        );

    }
}
