package com.city.mode.oops;

public class Inheritance {

      private String brand;

      public  Inheritance(String brand){
          this.brand=brand;
      }



      public  String getBrand(){

          return  brand;
      }

      public  void displayDetails(){

          System.out.println("displayDetails"+brand);
      }
}


 class Subclass1 extends Inheritance{

    private  String name;

    public Subclass1(String brand,String name){
        super(brand);
this.name=name;


    }


}


