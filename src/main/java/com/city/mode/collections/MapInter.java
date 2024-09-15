package com.city.mode.collections;

import java.util.HashMap;
import java.util.Map;

public class MapInter {


    public static void main (String [] args){


        Map<String ,Integer> map=new HashMap<>();



        map.put("Id",11);
        map.put("Code",212);
        map.put("age",35);



        //The statement for (Map.Entry<String, Integer> entry : map.entrySet())
        // { is a for-each loop in Java used to iterate over each entry in a Map

        for (Map.Entry<String,Integer>entry:map.entrySet()){

            map.remove("Id");
            System.out.println("Key-->"+entry.getKey()+" ,"+ "value-->"+entry.getValue());


        }





    }
}
