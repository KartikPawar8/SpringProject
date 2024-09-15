package com.city.mode.dao;


import com.city.mode.model.MyModel;

import java.util.List;

public interface MyDao {
    List<MyModel> findAll();
    MyModel save(MyModel myModel);
}
