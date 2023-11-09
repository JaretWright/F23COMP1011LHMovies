package com.example.f23comp1011lhmovies;

import com.google.gson.annotations.SerializedName;

public class MovieInfo {

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdgbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }
}
