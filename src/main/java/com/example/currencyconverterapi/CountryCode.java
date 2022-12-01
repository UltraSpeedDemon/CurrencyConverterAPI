package com.example.currencyconverterapi;

import com.google.gson.annotations.SerializedName;

public class CountryCode {

    @SerializedName("CAD")
    private Converter CAD;

    public CountryCode(Converter CAD) {
        setCAD(CAD);
    }

    public Converter getCAD() {
        return CAD;
    }

    public void setCAD(Converter CAD) {
        this.CAD = CAD;
    }

    public String toString()
    {
        return "CAD: "+CAD;
    }
}
