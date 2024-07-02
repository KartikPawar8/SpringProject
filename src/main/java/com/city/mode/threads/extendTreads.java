package com.city.mode.threads;

public class extendTreads extends  Thread{


    @Override

    public void run(){


        for (int i=1;i<=5;i++){
            System.out.println("Thread" +
                    ""+i);
            try{
                 Thread.sleep(1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String [] args){

        extendTreads extendTreads=new extendTreads();
        extendTreads extendTreads1=new extendTreads();

        extendTreads.run();
        extendTreads1.run();
    }


}
