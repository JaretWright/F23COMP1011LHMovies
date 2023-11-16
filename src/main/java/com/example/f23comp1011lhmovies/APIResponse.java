package com.example.f23comp1011lhmovies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Class names are always PascalCase, everything else is camelCase
 *
 * to make this class work with the GSON dependency, we updated the pom.xml with the GSON
 * maven dependency and updated the module-info.java file
 */
public class APIResponse {
    private String totalResults;

    @SerializedName("Response")  //The annotation "@SerializedName" allows us to reference what the field is called in the json file
    private String response;

    @SerializedName("Search")
    private ArrayList<MovieInfo> search;

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public ArrayList<MovieInfo> getMovies() {
        return search;
    }
}
