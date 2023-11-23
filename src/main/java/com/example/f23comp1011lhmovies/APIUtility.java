package com.example.f23comp1011lhmovies;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    public static APIResponse callAPI(String movieName) throws IOException, InterruptedException {
        movieName = movieName.replaceAll(" ","%20");

        //this is the search String that we used in the browser
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s="+movieName;

        //configure the environment to make a HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this will save to a file called movies.json
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
//                                                    .BodyHandlers
//                                                    .ofFile(Paths.get("movies.json")));

        //this will save the json to a HttpResponse object
        HttpResponse<String> response = client.send(httpRequest, HttpResponse
                                                .BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), APIResponse.class);
    }

    /**
     * This method will read a JSON file and create an APIResponse object
     * @param fileName - If the file is located in the root of the project, just the
     *                 filename needs to be provided.  If it is in a subdirectory, then be
     *                 sure to include the path to the file.
     * @return
     */
    public static APIResponse getAPIResponseFromJSONFile(String fileName)
    {
        Gson gson = new Gson();
        APIResponse apiResponse = null;

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }
}
