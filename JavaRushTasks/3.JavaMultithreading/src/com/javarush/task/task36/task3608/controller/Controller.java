package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

import java.util.List;

/**
 * Created by Alex on 22.03.2020.
 */
public class Controller{
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;
    public void setModel(Model model){
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        ModelData modelData = model.getModelData();
        usersView.refresh(modelData);
    }

    public void onShowAllDeletedUsers(){
        model.loadDeletedUsers();
        usersView.refresh((ModelData) model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh((ModelData) model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh((ModelData) model.getModelData());
    }

    public void onUserChange(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh((ModelData) model.getModelData());
    }

}
