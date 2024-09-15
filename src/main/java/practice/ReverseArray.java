package practice;

public class ReverseArray {

public  static void main(String [] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8};

    System.out.println("a.length"+a.length);//8

    for (int i=0;i<a.length/2;i++){

        System.out.println("a.length"+a.length/2); //4
        System.out.println("a i"+i);//0

int tmp=a[i];
        System.out.println("a of i"+a[i]);//1
        System.out.println("tmp"+tmp);//1


        System.out.println("a.length"+a.length);//8
        System.out.println("-i"+i);//0
        System.out.println("a"+a.toString());//
        System.out.println("a[a.length-i-1]"+a[a.length-i-1]);//8-0-1=7


a[i]=a[a.length-i-1];
a[a.length-i-1]=tmp;

    }


    for(int t=0;t<a.length;t++){

    System.out.print(a[t]+",");
}
}
}