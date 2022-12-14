package com.example.shopping_api.Service.Implement;

import com.example.shopping_api.Repository.UserRepository;
import com.example.shopping_api.Service.UserService;
import com.example.shopping_api.model.Request.SignUpRequest;
import com.example.shopping_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository ;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public Boolean isAuthenticated(String name, String password) {
        User user = userRepository.findUserByName(name.trim());
        if (user == null ) return false;
        if (user.getPassword().equals(password.trim())){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Boolean signUp(User user) {
        User k = userRepository.findUserByName(user.getName().trim());
        if (user == null )  {
            userRepository.save(user);
            return true;
        }

        return false;
    }
}