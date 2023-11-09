package com.example.f23comp1011lhmovies;

/**
 * Class names are always PascalCase, everything else is camelCase
 *
 * to make this class work with the GSON dependency, we updated the pom.xml with the GSON
 * maven dependency and updated the module-info.java file
 */
public class APIResponse {
    private String totalResults;

    @SerializedName("Response")
    private String response;

}
