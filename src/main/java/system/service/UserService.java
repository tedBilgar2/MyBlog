package system.service;

import system.model.User;

import java.util.List;

public interface UserService {
    /* CRUD options*/
    void addUser(User user);
    User loadUserById(String id);
    User loadUserByEmail(String email);
    List<User> loadAllUser();
    void updateUser(User user);
    void deleteUserById(String id);
}
