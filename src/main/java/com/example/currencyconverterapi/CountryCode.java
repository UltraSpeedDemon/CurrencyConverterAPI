package com.example.currencyconverterapi;

import com.google.gson.annotations.SerializedName;

public class CountryCode {

    @SerializedName("CAD")
    private Converter CAD;

    @SerializedName("USD")
    private Converter USD;

    @SerializedName("EUR")
    private Converter EUR;

    @SerializedName("AUD")
    private Converter AUD;

    @SerializedName("GBP")
    private Converter GBP;

    public CountryCode(Converter CAD, Converter USD, Converter EUR, Converter AUD, Converter GBP) {
        setCAD(CAD);
        setUSD(USD);
        setEUR(EUR);
        setAUD(AUD);
        setGBP(GBP);
    }

    public Converter getCAD() {
        return CAD;
    }

    public void setCAD(Converter CAD) {
        if(CAD!=null)
        {
            this.CAD = CAD;
        }
        else
        {
            throw new IllegalArgumentException("Invalid CAD");
        }
    }

    public Converter getUSD() {
        return USD;
    }

    public void setUSD(Converter USD) {
        if(USD!=null)
        {
            this.USD = USD;
        }
        else
        {
            throw new IllegalArgumentException("Invalid USD");
        }
    }

    public Converter getEUR() {
        return EUR;
    }

    public void setEUR(Converter EUR) {
        if(EUR!=null)
        {
            this.EUR = EUR;
        }
        else
        {
            throw new IllegalArgumentException("Invalid EUR");
        }
    }

    public Converter getAUD() {
        return AUD;
    }

    public void setAUD(Converter AUD) {
        if(AUD!=null)
        {
            this.AUD = AUD;
        }
        else
        {
            throw new IllegalArgumentException("Invalid AUD");
        }
    }

    public Converter getGBP() {
        return GBP;
    }

    public void setGBP(Converter GBP) {
        if(GBP!=null)
        {
            this.GBP = GBP;
        }
        else
        {
            throw new IllegalArgumentException("Invalid GBP");
        }
    }

    public Converter allCountryCodes(String countryCode){
        if (countryCode == "CAD"){
            return CAD;
        }
        else if (countryCode == "USD"){
            return USD;
        }
        else if (countryCode == "EUR"){
            return EUR;
        }
        else if (countryCode == "AUD"){
            return AUD;
        }
        else if (countryCode == "GBP"){
            return GBP;
        }
        else{
            throw new IllegalArgumentException("Invalid country code");
        }
    }
}
