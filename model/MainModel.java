package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;


public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    // эти методы работают с UserService(который в свою очередь работает с DAO, которая в свою очередь работает с данными)
    // Controller вызывает эти методы, тем самым "просит" Model сформитовать нужные данные и "упаковать" их объект класса ModelData

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id){
        userService.deleteUser(id);
        loadUsers();
    }

    // эти методы возвращают данные.
    // Controller вызывает эти методы, и получает запрашиваемые данные
    private List<User> getAllUsers(){
        List<User> list = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(list);
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);
        loadUsers();
    }

}
