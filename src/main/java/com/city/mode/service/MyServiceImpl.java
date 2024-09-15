package com.city.mode.service;

import com.city.mode.dao.MyDao;
import com.city.mode.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyDao myDao;

    @Override
    public List<MyModel> getAllItems() {
        return myDao.findAll();
    }

    @Override
    public MyModel createItem(MyModel myModel) {
        // Perform any business logic or validation here
        return myDao.save(myModel);
    }
}