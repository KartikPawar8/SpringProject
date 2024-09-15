package com.city.mode.threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

//String reverse
//String reverseArray
//String reverse word
//number reverse

//add 2 arrays  use while and addidtion i++ j++ k++















public class StringReverse {

    public static String reverseString(String reversableString) {

        String doRevers = "";


        for (int i = reversableString.length(); i > 0; i--) {


            doRevers += reversableString.charAt(i - 1);
        }

        return doRevers;
    }


    public static void main(String[] args) {

        String reversableString = "erutneccA";


        String storeReversed = reverseString(reversableString);

        System.out.println("storeReversed-->" + storeReversed);

    }
}


    class ReverseArray {


    public static int[] reverseArray(int[] reversibleArray){

    int left=0;
    int right=reversibleArray.length-1;

    while(left<right){

        int temproryStor=reversibleArray[left];
        reversibleArray[left]=reversibleArray[right];
        reversibleArray[right]=temproryStor;



        left++;
        right--;

    }
    return reversibleArray;

    }

    public static void main(String [] args){

       int [] reversibleArray={1,2,3,4,5,6,7};
        int [] reversedArray=reverseArray(reversibleArray);

        System.out.println("reversedArray-->"+java.util.Arrays.toString(reversedArray));


    }
    }



class reverseAnArray{

    public static void main (String [] args){



        int [] array={1,2,3};

        int left=0;

        int right =array.length-1;

        while(left<right){

            int temprotyStore=array[left];

             array[left]=array[right];
             array[right]=temprotyStore;

             left++;
             right--;




        }

        System.out.println("array"+java.util.Arrays.toString(array));








    }


}























class ReverseNumber{



  public static int reverse(int number){

      int reverse=0;

      while(number!=0){

         reverse=reverse*10+number%10;

         number /=10;

      }

      return  reverse;

  }


    public static void main(String [] args){

        int number=123456;

        int reverse=ReverseNumber.reverse(number);

        System.out.println("reverse"+reverse);

    }

}

class reverseNumbers{


    public static void main(String [] args){

    }
}




class ReverseList{


    public static void main (String [] args){

        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);


        List<String> stringList= Arrays.asList("cam","ros","sap");


        Collections.reverse(stringList);

        System.out.println("list"+stringList);



    }

}

class ReverseWordString {


    private static String reverse(String original) {

        String[] splitString = original.split(" ");


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = splitString.length - 1; i > 0; i--) {

            stringBuilder.append(splitString[i]).append(" ");


        }
        return stringBuilder.toString();


    }
    public static void main(String []args){


        String  word="hello World";


        String reverseWord=reverse(word);

        System.out.println("reverseWord-->"+reverseWord);



    }
}



    class reverseWord{

public static String reverseWordmethod(String word){

    String [] splitWord=word.split(" ");


    StringBuilder stringBuilder=new StringBuilder();
    for (int i=splitWord.length-1;i>=0;i--){

      stringBuilder.append(splitWord[i]).append(" ");

    }
    return stringBuilder.toString();


}


    public static void main(String [] args){


        String initialWord="Hello Json";

        String reversedWord=reverseWordmethod(initialWord);


        System.out.println("reversedWord-->"+reversedWord);




        }
    }







    class ListNode{

    int value;
    ListNode next;


    ListNode(int value){
        this.value=value;
        
        
    }
    



}

class ReversedLinkedlist{



    public static  ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }


    public static void main (String [] args){

        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next=new ListNode(3);
        head.next=new ListNode(4);
        head.next=new ListNode(5);

System.out.println("Original List");
        printList(head);

ListNode reversedHead=reverse(head);
        System.out.print("Reversed List: ");
        printList(reversedHead);


    }

    private static void printList(ListNode head) {


        ListNode current=head;

        while(current!=null){
            System.out.print(current.value + " ");
            current = current.next;

        }
        System.out.println();
    }
}



    class

    addSortedArray {

        public static void main(String[] args) {

            int[] arrayA = {1, 2, 3, 4, 5};
            int[] arrayB = {5, 6, 7, 8, 9};

            int[] mergeArray = new int[arrayA.length + arrayB.length];


            int i = 0, j = 0, k = 0;


            while (i < arrayA.length && j < arrayB.length) {

                if (arrayA[i] < arrayB[j]) {

                    mergeArray[k] = arrayA[i];
                    i++;


                } else {
                    mergeArray[k] = arrayB[j];
                    j++;

                }
                k++;
            }

            while (i < arrayA.length) {

                mergeArray[k] = arrayA[i];

                i++;
                k++;

            }

            while (j < arrayB.length) {

                mergeArray[k] = arrayB[j];
                j++;
                k++;
            }

            System.out.println("merged array-->" + java.util.Arrays.toString(mergeArray));


        }
    }


        //  int[] mergeAray = new int[arrayA.length + arrayB.length];

        // int i = 0, j = 0, k = 0;
/*
        while (i<arrayA.length && j< arrayB.length) {



            if(arrayA[i]<arrayB[j]) {

                   mergeAray[k]=arrayA[i];
                i++;
            }else{
               mergeAray[k]=arrayB[j];

                j++;
            }

            k++;
        }

        while (i < arrayA.length) {

            mergeAray[k]=arrayA[i];

            i++;
            k++;

        }
        while (j < arrayB.length) {

            mergeAray[k]=arrayB[j];

            j++;
            k++;
        }


        System.out.println("getReversedArray" + java.util.Arrays.toString(mergeAray));





    }*/


class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] result = removeDuplicates(array);

        System.out.println("Array after removing duplicates:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int value : array) {
            set.add(value);
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int value : set) {
            result[i++] = value;
        }

        return result;
    }
}

class MaximumElement{



    public static  void main(String [] args){

    int[] array = {10, 15, 78, 96, 17, 20, 65, 14, 36, 18, 20};

    int max=findMax(array);

    System.out.println("Arry of max element-->"+max);


}
public  static int  findMax(int [] array){

        int max=array[0];


        for(int i=1;i<array.length;i++){

            if(array[i]>max){
                max=array[i];
            }

        }
    return max;

    }
}


/*class MissingArray{


    public static  void main (String [] args){

int array[]={1,2,3,5,6,8};

int missing[]=missingArray(array);

    }

    public  static int[] missingArray(int [] array){

int n=array.length+1;

int totalSum=n*(n+1)/2;

int sumarray=0;

for (int value:array){

    sumarray +=value;
}

return array;
    }
        }*/



class BinarySearch{



    public static int findBinarySerach(int array[] ,int key) {

        int low = 0;

        int high = array.length - 1;

        while (low <= high) {

            int mid = low + (high - low)/2;

            if (array[mid] == key) {
                return mid;


            } else if (array[mid] < key) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }


        }
        return -1;
    }




    public static void main (String [] args){



        int array[] = {1, 2, 3, 4, 6,5,3}; // Sorted array

        int key=10;

        int findBinary=findBinarySerach(array,key);
if(findBinary==-1){
    System.out.println("Key not found in the array");
}

        System.out.println("findBinary--->"+findBinary);

    }




        }

        class LinearSearch{

    public static int findLinear(int array[],int search){

        for(int i=0;i<array.length;i++){


            boolean flag=false;
            if(array[i]==search){

                return i;

            }

        }
        return -1;


    }


    public static void main(String [] args){

        int [] array={20,30,40,50,60};

        int search=50;

        int index=findLinear(array,search);
        if(index==-1){
            System.out.println("Key not found in the array");
        }else {
            System.out.println("index"+index);


        }



    }
        }


class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;

    // Method to insert a new node
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to print the LinkedList
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to reverse the LinkedList
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev and current one step forward
            current = next;
        }

        head = prev; // Update head to the new first node
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting nodes
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original List:");
        list.printList();

        // Reversing the list
        list.reverse();

        System.out.println("Reversed List:");
        list.printList();
    }
}


class CharacterCount {
    public static void main(String[] args) {
        String inputString = "Hello, World!";

        // Create a map of character counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Iterate over each character in the input string
        for (char c : inputString.toCharArray()) {
            // Update the count for the current character
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        // Display the repeated characters
        System.out.println("Repeated characters:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
            }
        }
    }
}





class SwapTwoNumber{


    public static void main(String [] args){

int a=5;
int b=6;


System.out.println("Before swaping-->a"+a+"and b"+b);



a=a+b;
b=a-b;
a=a-b;

        System.out.println("after swaping-->a"+a+" and b"+b);

    }


}


