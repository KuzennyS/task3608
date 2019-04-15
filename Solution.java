package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        /* создали объекты */
        Model model = new FakeModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        /* перевязали между собой объекты */
        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        /* заупустили в работу
        * через View вызвали работу Controller, не напрямик
        * */
        usersView.fireEventShowAllUsers();
    }
}