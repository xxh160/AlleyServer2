package com.edu.nju.alley.util;

public class DoubleUtil {

    public static double format(Double num, int digit) {
        String s = String.format("%." + digit + "f", num);
        return Double.parseDouble(s);
    }

    public static void main(String[] args) {
        System.out.println(DoubleUtil.format(3.2454, 2));
    }

}
