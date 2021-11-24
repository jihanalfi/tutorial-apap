package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getAllUser();
    void deleteUser(UserModel user);

    UserModel getUser(String username);

    void updatePassword(UserModel user, String password);

    boolean checkPassword(String password);
}
