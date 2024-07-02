package com.city.mode.threads;

public class BankAccount {


    private int balance=0;

    public synchronized  void deposite(int amount){

        int new_amount=balance+amount; //reads the current balance and add amount
        balance=new_amount;             //write new balance back to the account

    }


    public  int getBalance(){

        return  balance;
    }


    public static  void main (String [] args){


        BankAccount account=new BankAccount();

        Thread personA=new Thread(()->{
            account.deposite(10);
        });

        Thread personB=new Thread(()->{
            account.deposite(10);
        });



        personA.start();
        personB.start();

        try{

            personA.join();
            personB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("getBalance"+account.getBalance());


    }









}
