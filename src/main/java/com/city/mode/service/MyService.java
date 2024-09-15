package com.city.mode.service;

import com.city.mode.model.MyModel;

import java.util.List;

public interface MyService {


    List<MyModel> getAllItems();
    MyModel createItem(MyModel myModel);
}


