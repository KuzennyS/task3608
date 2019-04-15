package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    /* получили команду через промежуточное звено в View */
    public void onShowAllUsers(){
        /* через model загрузили пользователй FakeModel (в реальности будет работа с DAO) */
        model.loadUsers();
        /* вывод на экран (View) свежих данных */
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

}
