package com.city.mode.threads;

public class palidrome {


    public static boolean isPalidrome(String s){

        int n=s.length();


        for (int i=0;i<(n/2);++i){


            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }

        }
        return true;

    }


    public static void main(String[] args){

        String str="levwel";



        System.out.println("palidrom check  true"+isPalidrome(str));


    }
}
