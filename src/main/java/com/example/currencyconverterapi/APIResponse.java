package com.example.currencyconverterapi;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("Error")
    private String error;

    @SerializedName("rates")
    private CountryCode rates;

    @SerializedName("amount")
    private double amount;

    public String getError() {
        return error;
    }

    public boolean resultsReturned() {
        if (status.equals("success")) {
            return true;
        } else {
            return false;
        }
    }

    public APIResponse(String status, CountryCode rates, double amount) {
        setStatus(status);
        setRates(rates);
        setAmount(amount);
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
        if (rates != null) {
            this.rates = rates;
        } else {
            throw new IllegalArgumentException("Invalid rates");
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }
}
