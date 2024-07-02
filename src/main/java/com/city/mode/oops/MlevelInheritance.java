package com.city.mode.oops;

public class MlevelInheritance {


    void eat(){

    }

}
class FirtSubClass extends MlevelInheritance{

    void  bark(){

    }



}
class SecondSubClass extends  FirtSubClass{

    void run(){

    }


}

class Main1{

    public static void main (String [] args){

        SecondSubClass secondChild=new SecondSubClass();
        secondChild.eat();
        secondChild.run();
        secondChild.bark();



    }


}