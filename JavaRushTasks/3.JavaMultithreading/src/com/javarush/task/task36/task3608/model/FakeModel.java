package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 22.03.2020.
 */
public class FakeModel implements Model{
    private ModelData modelData = new ModelData();
    List<User> users = new ArrayList<>();
    public void loadUsers(){
        users.add(new User("name A", 1, 1));
        users.add(new User("name B", 2, 2));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void deleteUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    /*    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException();
    }*/
}
