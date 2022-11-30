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
     * This method will call the CurrencyConverter API with the specified
     * amount, from currency, and to currency
     * @return ApiResponse is the Java object created from the JSON
     */
    public static APIResponse getConverterFromRapidAPI(int amount, String currencyFrom, String currencyTo) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient(); //client
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://currency-converter5.p.rapidapi.com/currency/convert?format=json&from="+currencyFrom+"&to="+currencyTo+"&amount="+amount)) //uri ** CHANGE AUD, CAD, 1 as variables
                .header("X-RapidAPI-Key", "522e680d0cmsh846c9955ff01059p1bb5f4jsnaa88a71355c7") //api Key
                .header("X-RapidAPI-Host", "currency-converter5.p.rapidapi.com") //api host
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json"))); //create json file
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), APIResponse.class);
    }
    public static Converter[] getCurrencyFromJsonFile() //getting from Jsom File
    {
        //create a GSON object
        Gson gson = new Gson();
        Converter[] converter = null;

        //try with resources...what ever is in the ( ) will automatically be closed
        try(
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            //jsonReader - the object that is parsing through the json file
            //APIResponse.class - this is what ever type of object you want the JSON
            //                    to be converted into
            converter = gson.fromJson(jsonReader, Converter[].class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return converter;
    }
}