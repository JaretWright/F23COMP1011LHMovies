package com.example.f23comp1011lhmovies;

import com.google.gson.annotations.SerializedName;

public class Ratings {
    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public String toString()
    {
        return String.format("%s-%s",source,value);
    }
}
