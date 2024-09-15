package com.city.mode.threads;

public class fibonacci {



    /*public static int fibonacci(int number) {


        int a = 0;
        int b = 1;

        System.out.print(a + "" + b);


        for (int i = 2; i < number; i++) {

            int nextNumber = a + b;

            System.out.println("" + nextNumber);


            a = b;
            b = nextNumber;


        }
        return a;
    }*/



    public static int fibonacci(int number){

        int a=0;
        int b=1;



        for(int i=2;i<number;i++){

            int temproryNumber=a+b;

System.out.print(" ,"+temproryNumber);
            a=b;
            b=temproryNumber;




        }
        return a;

    }

        public static void main(String[] args){


        int number=10;

            System.out.print("First " + number + " numbers in Fibonacci sequence: ");
            fibonacci(number);



        }



    }

