package com.ferit.ablavicki.rmadz2;

public class Conversions {

    private final static double[] LENGTH_FACTORS = {0.001, 0.01, 1, 1000, 0.0254, 0.3048, 0.9144, 1609.344}; //from unit to meter
    private final static double[] SPEED_FACTORS = {0.1, 1, 0.2778, 0.3408,  0.4770,  0.5144}; //from unit to m/s
    private final static double[] WEIGHT_FACTORS = {0.000001, 0.001, 1, 1000, 0.028495, 0.45359237, 6.35029}; //from unit to kilogram

    public static double convertLength(int sFromPosition, int sToPosition, double value){
        value = value * LENGTH_FACTORS[sFromPosition]/LENGTH_FACTORS[sToPosition];
        return value;
    }

    public static double convertSpeed(int sFromPosition, int sToPosition, double value){
        value = value * SPEED_FACTORS[sFromPosition]/SPEED_FACTORS[sToPosition];
        return value;
    }

    public static double fromFahrenheit(int sToPosition, double value){
        switch(sToPosition){
            case 0: //celsius
                value = (value - 32)/1.8;
                break;
            case 1: //fahrenheit
                break;
            case 2: //kelvin
                value = (value - 32)/1.8 + 273.15;
                break;
        }
        return value;
    }

    public static double fromCelsius(int sToPosition, double value){
        switch(sToPosition){
            case 0:
                break;
            case 1:
                value = value * 1.8 + 32;
                break;
            case 2:
                value = value + 273.15;
                break;
        }
        return value;
    }

    public static double fromKelvin(int sToPosition, double value){
        switch(sToPosition){
            case 0:
                value = value - 273.15;
                break;
            case 1:
                value = value * 1.8 - 459.67;
                break;
            case 2:
                break;
        }
        return value;
    }

    public static double convertWeight(int sFromPosition, int sToPosition, double value){
        value = value * WEIGHT_FACTORS[sFromPosition]/WEIGHT_FACTORS[sToPosition];
        return value;
    }

}
