package com.example.currencyconverterapi;

import com.google.gson.annotations.SerializedName;

public class Converter {

        @SerializedName("base_currency_name")
        private String base_currency_name;

        @SerializedName("amount")
        private int amount;

        @SerializedName("currency_name")
        private String currency_name;

        @SerializedName("rate")
        private int rate;

        public Converter(String base_currency_name, int amount, String currency_name, int rate) {
            setBase_currency_name(base_currency_name);
            setAmount(amount);
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) { //validation
        if (amount>=0){
            this.amount = amount;
        }
        else
        {
            throw new IllegalArgumentException("Amount must be greater than 0");
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) { //validation
        if(rate>=0)
        {
            this.rate = rate;
        }
        else
        {
            throw new IllegalArgumentException("Rate must be greater than 0");
        }
    }

    /**
     *  This method will return the converted amount
     * @return
     */
    //returns finalAmount after the exchange
    public int getFinalAmount() {
        int finalAmount = amount * rate;
        return finalAmount;
    }

}
