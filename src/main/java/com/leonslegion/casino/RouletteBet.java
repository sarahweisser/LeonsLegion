package com.leonslegion.casino;

/**
 * Created by markbrown on 5/10/17.
 */
public class RouletteBet {



    private String betType;
    private double betValue;



    public RouletteBet (String betType, double betValue) {
        this.betType = betType;
        this.betValue = betValue;
    }



    public String getBetType() {return betType;}
    public double getBetValue() {return betValue;}



}
