package com.city.mode.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class ListInter {

public static void main (String [] args) {


    //An ordered collection (also known as a sequence).
    // Lists allow duplicate elements and provide precise control over where each element is inserted.
    // Users can access elements by their integer index (position in the list) and search for elements in the list.
    List<String> list = new ArrayList<>();

    list.add("Apple");
    list.add("Banana");
    list.add("Cherry");
    list.add("Apple");//Listduplicat elements //List: [Apple, Banana, Cherry, Apple]

    System.out.println("List: " + list);//List: [Apple, Banana, Cherry, Apple] -->Order collection  form
    System.out.println("Element at index 1: " + list.get(1));


}
}


class SetInter{
// A collection that does not allow duplicate elements
    //it models the mathematical set abstraction to store elements


    public  static  void main (String []  args) {


        Set<String> set = new HashSet<>();
        ;

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");//set does not allow duplicate elements


        System.out.println("set-->" + set); //set-->[Apple, Cherry, Banana]-->( HashSet does not guarantee any specific order.)The output order may vary as }

    }
}


class QueueExample{

    //A collection used to hold multiple elements prior to processing.
    // Typically, queues order elements in FIFO (First-In-First-Out) order.

   // FIFO stands for First-In-First-Out.
    // It is a method of processing
    // where the first element added to the queue is the first one to be removed

    public static void main (String [] args){

        Queue<String> queue = new LinkedList<>();

        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");
        System.out.println("Queue: " + queue);
        System.out.println("Head of the queue: " + queue.peek());
        queue.poll();
        System.out.println("Queue after poll: " + queue);




    }
}

//Lets take an example how printer works with queue


class PrintJob{

    private String documentName;

    private  int numberOfPages;

    public PrintJob(String documentName,int numberOfPages){

        this.documentName=documentName;
        this.numberOfPages=numberOfPages;
    }


    public String getDocumentName(){
        return documentName;
    }

    public int getNumberOfPages(){

        return numberOfPages;
    }
   /* @Override
    public String toString() {
        return "PrintJob{documentName='" + documentName + "', numberOfPages=" + numberOfPages + '}';
    }*/


}

class PrinterQueue{
 public static void main(String [] args){


     Queue<PrintJob>queue=new LinkedList<>();

     queue.offer(new PrintJob("Document1.pdf", 10));
     queue.offer(new PrintJob("Document2.pdf", 5));
     queue.offer(new PrintJob("Document3.pdf", 3));
     queue.offer(new PrintJob("Document4.pdf", 7));


     while(!queue.isEmpty()){

PrintJob printJob=queue.poll();
System.out.println("Printing"+printJob.getDocumentName()+ " umber of pages"+printJob.getNumberOfPages());


try{
    Thread.sleep(1000);
}catch (InterruptedException e){
    e.printStackTrace();
}

     }




 }



}


