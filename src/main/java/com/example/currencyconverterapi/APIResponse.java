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

    @SerializedName("rates")
    private CountryCode rates;

    @SerializedName("amount")
    private double amount;

    public String getError()
    {
        return error;
    }

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

    public APIResponse(String totalResults, String status) {
        setTotalResults(totalResults);
        setStatus(status);
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CountryCode getRates() {
        return rates;
    }

    public void setRates(CountryCode rates) {
        this.rates = rates;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString()
    {
        return "APIResponse{" +
                "totalResults='" + totalResults + '\'' +
                ", status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", rates=" + rates +
                '}';
    }
}
