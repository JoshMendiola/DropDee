package me.joshmendiola.DropDee.service.utils;

import me.joshmendiola.DropDee.model.accounts.User;
import me.joshmendiola.DropDee.repository.accounts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password)
    {
        User user = userRepository.findByUsername(username);
        if (user == null)
        {
            return false; // user not found
        }
        return (password.equals(user.getPassword()));
    }
}
