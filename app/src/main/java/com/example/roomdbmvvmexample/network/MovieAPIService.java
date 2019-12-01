package com.example.roomdbmvvmexample.network;

import com.example.roomdbmvvmexample.model.Movie;
import com.example.roomdbmvvmexample.model.MovieList;
import com.example.roomdbmvvmexample.utils.AppConfig;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieAPIService {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/";

    public static final String BACKDROP_BASE_URL = "https://image.tmdb.org/t/p/w780/";

    private static MovieAPIService instance;

   private MovieApi mMovieApi = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MovieApi.class);

    public MovieAPIService() {
    }

    public static MovieAPIService getInstance(){
        if (instance == null){
            instance = new MovieAPIService();
        }
        return instance;
    }

    public Single<Movie> getMoviesList(){
        return mMovieApi.getMoviesList(AppConfig.API_KEY);
    }
}
