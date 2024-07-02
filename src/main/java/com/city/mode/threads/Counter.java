package com.city.mode.threads;

public class Counter {

    private int count=0;

    public synchronized  void  increment(){
        count ++;

    }

    public  int  getCount(){
        return  count;
    }


}

class CounterThread extends Thread{
    private Counter counter;

public CounterThread (Counter counter){
    this.counter=counter;
}




@Override
    public void run(){

    for (int i=0;i<1000;i++){

        counter.increment();

    }
}


public static void main(String [] args){

    Counter counter=new Counter();


    CounterThread thread=new CounterThread(counter);
    CounterThread thread1=new CounterThread(counter);



    thread.start();
    thread1.start();

try{
    thread.join();
    thread1.join();
} catch (InterruptedException e) {
    e.printStackTrace();
}


    System.out.println("Final Count"+counter.getCount());
}


}
