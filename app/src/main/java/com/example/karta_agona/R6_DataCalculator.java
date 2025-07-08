package com.example.karta_agona;

public class R6_DataCalculator {

    public R6_DataCalculator(){

    }

    /** Returns the success rate of the shots */
    public String valueConverter(int made, int attempted){
        int t;
        String temp;

        if(attempted!=0) {
            t = (made * 100) / attempted;
            temp = String.valueOf(t) + "%";
        }else{
            temp="0";
        }
        return temp;
    }
}
