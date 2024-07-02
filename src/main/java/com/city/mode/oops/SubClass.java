package com.city.mode.oops;

public class SubClass  extends Inheritance{

    private String model;


    public SubClass(String brand,String model){

        super(brand);
        this.model=model;

    }


    public String getModel(){
        return getModel();
    }



    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("model: " + model);


    }


    public static void main(String [] args){
        SubClass subClass=new SubClass("Toyata","Swift");
        subClass.displayDetails();

    }


    }

