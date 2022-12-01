package com.example.currencyconverterapi;

import com.google.gson.annotations.SerializedName;

public class Converter {

        @SerializedName("base_currency_name")
        private String base_currency_name;

        @SerializedName("currency_name")
        private String currency_name;

        @SerializedName("rate")
        private double rate;

        public Converter(String base_currency_name, String currency_name, double rate) {
            setBase_currency_name(base_currency_name);
            setCurrency_name(currency_name);
            setRate(rate);
        }

    public String getBase_currency_name() {
        return base_currency_name;
    }

    public void setBase_currency_name(String base_currency_name) { //validation
        if(!base_currency_name.isBlank())
        {
            this.base_currency_name = base_currency_name;
        }
        else
        {
            throw new IllegalArgumentException("Invalid base currency name");
        }
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        if(!currency_name.isBlank())
        {
            this.currency_name = currency_name;
        }
        else
        {
            throw new IllegalArgumentException("Invalid currency name");
        }
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) { //validation
        if(rate>=0)
        {
            this.rate = rate;
        }
        else
        {
            throw new IllegalArgumentException("Rate must be greater than 0");
        }
    }

}
