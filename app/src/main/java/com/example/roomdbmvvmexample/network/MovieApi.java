package com.example.roomdbmvvmexample.network;

import com.example.roomdbmvvmexample.model.Movie;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApi {

    @GET("discover/movie?api_key={key}")
    Single<Movie> getMoviesList(@Path("key") String key);
}
