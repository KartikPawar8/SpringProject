package com.city.mode.lamba;




@FunctionalInterface
interface Function{

    void call();//in  @FunctionalInterface we can write only one method
    // void insert();

    //we cannot create object of an interface
}


class Impl implements Function{


    @Override
    public void call() {
        System.out.println("Object created and called");
    }
}


public class Lambda {

    public static void main(String [] args){

        //Function function=new Function();//not possible to create an object of an interface //'Function' is abstract; cannot be instantiated
   //Every class in java extends Object clas//study more on this
        Impl object=new Impl();//we can create a class implement the interface -->create an object of class by  refering the interface
        object.call();


        //Anonymous Inner class

        //Creating an object of interface without any class
        //Anonymous Inner class

        Function  function=new Function() {
            //creating a class inside a class
            @Override
            public void call() {

            }
        };

//above code toward lambda expression
        Function  function1=() -> System.out.println("lambda expression");
         function1.call();





    }
    }
