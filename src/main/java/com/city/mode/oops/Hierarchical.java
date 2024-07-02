package com.city.mode.oops;

public class Hierarchical {


    // Superclass
        void eat() {
            System.out.println("Animal is eating");
        }
    }

    // Subclass inheriting from Animal
    class Dog extends Hierarchical {
        void bark() {
            System.out.println("Dog is barking");
        }
    }

    // Another subclass inheriting from Animal
    class Cat extends Hierarchical {
        void meow() {
            System.out.println("Cat is meowing");
        }
    }

class Main2 {
        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.eat(); // Inherited method from Animal
            dog.bark(); // Method of subclass Dog

            Cat cat = new Cat();
            cat.eat(); // Inherited method from Animal
            cat.meow(); // Method of subclass Cat
        }
    }

