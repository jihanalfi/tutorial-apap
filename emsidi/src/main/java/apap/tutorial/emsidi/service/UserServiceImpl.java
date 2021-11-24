package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getAllUser() {
        return userDb.findAll();
    }

    @Override
    public void deleteUser(UserModel user){
        userDb.delete(user);
    }

    @Override
    public UserModel getUser(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public void updatePassword(UserModel user, String password){
        String newPassword = encrypt(password);
        user.setPassword(newPassword);
        userDb.save(user);
    }

    @Override
    public boolean checkPassword(String password){
        boolean angka = false;
        boolean upper = false;
        boolean lower = false;
        boolean simbol = false;
        boolean count = password.length() >= 8 ;

        for (char c : password.toCharArray()){
            if (Character.isDigit(c))
                angka = true;

            if (Character.isUpperCase(c))
                upper = true;

            if (Character.isLowerCase(c))
                lower = true;

            if (String.valueOf(c).matches("[^A-Za-z0-9]"))
               simbol = true;
        }

        return angka && upper && lower && simbol && count;
    }
}
