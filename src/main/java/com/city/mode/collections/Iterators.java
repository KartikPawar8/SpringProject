package com.city.mode.collections;

import java.util.*;

public class Iterators {


    public static void main (String [] args){



        List<String> list=new ArrayList<>();

        list.add("pings");
        list.add("lattitude");
        list.add("longitude");


     Iterator<String> iterator=list.iterator();




     while (iterator.hasNext()){

String element=iterator.next();

if (element.equals("pings")){


    iterator.remove();
}


     }
     System.out.println("List print-->"+list);
    }


}


class IteratorWithMap{


    public static void main(String [] args){

        Map<String,Integer>map=new HashMap<>();
        map.put("pings",1);
        map.put("lattitude",2);
        map.put("longitude",3);


Iterator<Map.Entry<String,Integer>>iterator=map.entrySet().iterator();


while (iterator.hasNext()){

Map.Entry<String,Integer>entry=iterator.next();


if(entry.getKey().equals("pings")){

    iterator.remove();
}

}
        System.out.println("List print-->"+map);

    }



}

class Vector{

    public static void main (String [] args){



        List<String>vector=new java.util.Vector<>();


        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        System.out.println(vector); // Output: [Apple, Banana, Cherry]


    }




}
class  StackExample{

    public static void main (String [] args ){

        Stack<Integer> stack=new Stack<>();

//        Stack is having  absic opertions
//        push(E item): Pushes an item onto the top of the stack.
//         pop(): Removes the object at the top of the stack and returns that object.
//         peek(): Looks at the object at the top of the stack without removing it.
//        isEmpty(): Tests if the stack is empty.
//        search(Object o): Returns the 1-based position where an object is on the stack.

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);




        //Pop an element frm the satck
        Integer PoppedElement=stack.pop();

        //peek an element at top without removing it
          Integer peekElemetTop=stack.peek();

          //Search for the element

        int position=stack.search(3);


        //cehck is it emeoty or not

        boolean isEmpty=stack.isEmpty();

    }
}

class ArrayDequeExample{


    /*
    * Alternatives to Stack
While Stack is part of the Java Collections Framework,
*  it's generally recommended to use ArrayDeque
* for stack operations in new code because it is more efficient and flexible.*/


    public static void main (String [] args){


        Deque<Integer>stack=new ArrayDeque<>();


        stack.push(1);
        stack.push(2);
        stack.push(3);


// Display the stack
        System.out.println("Stack: " + stack);

        // Pop an element from the stack
        Integer poppedElement = stack.pop();
        System.out.println("Popped Element: " + poppedElement);

        // Peek at the top element without removing it
        Integer topElement = stack.peek();
        System.out.println("Top Element: " + topElement);

        // Check if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty? " + isEmpty);

    }


}

