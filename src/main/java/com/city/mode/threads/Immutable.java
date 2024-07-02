package com.city.mode.threads;

public class Immutable {

    public static void main(String[] args) {
        String str = "hello";

        String str1 = "hello";

        String obNew=new String("Hello");

        System.out.println("check-->" + (str == str1));
        System.out.println("check-->" + (str == obNew));

    }
}

