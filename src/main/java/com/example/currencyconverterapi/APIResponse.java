package com.example.currencyconverterapi;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {
    private String totalResults;

    @SerializedName("status")
    private String status;

    @SerializedName("Error")
    private String error;

    public boolean resultsReturned()
    {
        if (status.equals("success"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public APIResponse() {

    }
}
