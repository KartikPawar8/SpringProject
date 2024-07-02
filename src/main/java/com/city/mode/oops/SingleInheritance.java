package com.city.mode.oops;

public class SingleInheritance {

void eat(){

}

}

class SingleInheritSub extends SingleInheritance{
    void bark() {

    }


}

class Main{

public static void main (String [] args) {

SingleInheritance parent=new SingleInheritance();

    SingleInheritSub subClass= new SingleInheritSub();

    subClass.bark();
    subClass.eat();

}
}
