package com.city.mode.lamba;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class JsonArrayStr {


    public static void main (String [] args){
        String jsonString = "[{\"name\":\"John\", \"age\":30}, {\"name\":\"Jane\", \"age\":22}, {\"name\":\"Mike\", \"age\":28}]";
        JSONArray jsonArray = new JSONArray(jsonString);



        // Simulate database insertions using streams
        List<String> insertedUsers = new ArrayList<>();

        jsonArray.toList().stream()  // Convert JSONArray to List and stream it
                .map(JSONObject.class::cast)  // Cast each element to JSONObject
                .forEach(obj -> {
                    String name = obj.getString("name");
                    int age = obj.getInt("age");

                    // Simulate inserting into database (print for demonstration)
                    String insertStatement = "INSERT INTO users (name, age) VALUES ('" + name + "', " + age + ")";
                    insertedUsers.add(name); // Add inserted user to list

                    // Print SQL statement (simulated insertion)
                    System.out.println("Executing SQL: " + insertStatement);
                });

        // Print inserted users for verification
        System.out.println("Inserted users: " + insertedUsers);







    }


}
