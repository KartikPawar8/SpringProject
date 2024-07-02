package com.city.mode.threads;

public class StringReverse {




    public static String reverseString (String str){


     String reverse="";


     for(int i=str.length()-1;i>=0;i--) {

          reverse += str.charAt(i);
     }
     return reverse;


     }
    public static void main(String [] args){


        String str ="hello world";
        System.out.println("reverse --->"+reverseString(str));
    }







}
