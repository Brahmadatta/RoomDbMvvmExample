package com.example.roomdbmvvmexample.model;

import com.google.gson.annotations.SerializedName;

public class MovieList {

    @SerializedName("popularity")
    public String popularity;

    @SerializedName("vote_count")
    public String vote_count;

    @SerializedName("poster_path")
    public String poster_path;

    @SerializedName("id")
    public String id;

    @SerializedName("original_title")
    public String original_title;

    @SerializedName("title")
    public String title;

    @SerializedName("vote_average")
    public String vote_average;

    @SerializedName("overview")
    public String overview;

    @SerializedName("release_date")
    public String release_date;


}
