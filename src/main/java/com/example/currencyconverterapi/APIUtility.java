package com.example.currencyconverterapi;

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

    /**
     * This method will call the OMDB API with the specified
     * search term
     * @return ApiResponse is the Java object created from the JSON
     */
    public static void getConverterFromRapidAPI() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient(); //client
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://currency-converter5.p.rapidapi.com/currency/convert?format=json&from=AUD&to=CAD&amount=1")) //uri
                .header("X-RapidAPI-Key", "522e680d0cmsh846c9955ff01059p1bb5f4jsnaa88a71355c7") //api Key
                .header("X-RapidAPI-Host", "currency-converter5.p.rapidapi.com") //api host
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();


        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json"))); //create json file
    }
}