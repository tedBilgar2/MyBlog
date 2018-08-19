package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.model.User;
import system.repositories.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepo userRepo;

    public void addUser(User user) {
        userRepo.addUser(user);
    }

    public User loadUserById(String id) {
        return userRepo.loadUserById(id);
    }

    public List<User> loadAllUser() {
        return userRepo.loadAllUser();
    }

    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    public void deleteUserById(String id) {
        userRepo.deleteUserById(id);
    }
}
