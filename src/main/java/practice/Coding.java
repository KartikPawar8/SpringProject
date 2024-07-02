package practice;

public class Coding {





    public static String reversString(String input){

        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String [] args){

        String input="hello";

        String output=reversString(input);

        System.out.println("output"+output);

    }
}


 class Factorial{

public static int factorial(int input){
    if(input==0){
        return 1;
    }
    return input*factorial(input-1);


}

    public static void main(String [] args)
    {

       int input =5;
       int output=factorial(input);
       System.out.println("output"+output);
       System.out.println(3*3.5f);




    }







}
