package com.example.roomdbmvvmexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("page")
    public String page;

    @SerializedName("total_results")
    public String total_results;

    @SerializedName("total_pages")
    public String total_pages;

    @SerializedName("results")
    public List<MovieList> movie_results;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieList> getMovie_results() {
        return movie_results;
    }

    public void setMovie_results(List<MovieList> movie_results) {
        this.movie_results = movie_results;
    }
}
