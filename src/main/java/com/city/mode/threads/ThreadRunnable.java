package com.city.mode.threads;

public class ThreadRunnable implements  Runnable{


    @Override
    public void run() {


        for (int i=1;i<=5;i++){

            System.out.println("Thread Executing::"+i);

            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }



        }
    }


    public static void main(String [] args){

        ThreadRunnable threadRunnable=new ThreadRunnable();
        ThreadRunnable threadRunnable1=new ThreadRunnable();


        threadRunnable.run();
        threadRunnable1.run();
    }
}
