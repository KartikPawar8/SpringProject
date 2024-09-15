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

        String str="level";



        System.out.println("palidrom check  true"+isPalidrome(str));


    }
}


class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "level";
        boolean isPalindrome = isPalindrome(input);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}



class CheckPalidrome{


    public static boolean checkPalidrome(String name ){


        int left=0;
        int right =name.length()-1;


        while(left<right){

            if(name.charAt(left)!=name.charAt(right)){

                return false;
            }
            left++;
            right--;


        }

        return true;



    }






    public static void main(String [] args){

      String name="level";


      boolean isPalidromeTrueOrNot=checkPalidrome(name);
      System.out.println("isPalidromeTrueOrNot-->"+isPalidromeTrueOrNot);


    }



}