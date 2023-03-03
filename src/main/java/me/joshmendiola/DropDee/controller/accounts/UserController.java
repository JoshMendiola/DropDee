package me.joshmendiola.DropDee.controller.accounts;

import me.joshmendiola.DropDee.model.accounts.User;
import me.joshmendiola.DropDee.repository.accounts.UserRepository;
import me.joshmendiola.DropDee.service.utils.AuthService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public class UserController
{
    @Autowired
    UserRepository repository;

    //GET MAPPINGS

    //gets all bands
    @GetMapping("/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getAllUserAccounts()
    {
        return repository.findAll();
    }

    //gets user by name
    @GetMapping("/user/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserAccountByUsername(@PathVariable String username)
    {
        return repository.findByUsername(username);
    }

    //logs in with password checking
    @GetMapping("/user/login/{username}/{password}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User loginUserAccount(@PathVariable String username, @PathVariable String password)
    {
        AuthService authService = new AuthService(repository);
        boolean loginSuccess = authService.authenticate(username, password);
        if(loginSuccess)
        {
            return repository.findByUsername(username);
        }
        else
        {
            throw new NullPointerException("No account with that username/password found !");
        }
    }

    //gets user by singular ID
    @GetMapping("/user/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User geUserAccountById(@PathVariable UUID id)
    {
        Optional<User> returnUserAccount = repository.findById(id);
        if(returnUserAccount.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnUserAccount.orElse(null);
    }

    //POST MAPPINGS

    //adds a single band to the database
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUserAccount(@RequestBody User userAccount)
    {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        userAccount.setUserID(uuid);


        if(repository.existsById(userAccount.getUserID()))
        {
            throw new IllegalArgumentException("ERROR: An entity with that ID already exists in the database");
        }
        return repository.save(userAccount);
    }
    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserAccount(@RequestBody @NotNull User newUserAccount, @PathVariable UUID id)
    {
        User userAccount = geUserAccountById(id);
        userAccount.setBio(newUserAccount.getBio());
        userAccount.setEmail(newUserAccount.getEmail());
        userAccount.setUsername(newUserAccount.getUsername());
        userAccount.setPhoneNumber(newUserAccount.getPhoneNumber());
        userAccount.setPassword(newUserAccount.getPassword());
        userAccount.setPhoneNumber(newUserAccount.getPhoneNumber());
        repository.save(userAccount);
    }

    //DELETE MAPPINGS

    //deletes by ID
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserAccount(@PathVariable UUID id)
    {
        if(repository.findById(id).isEmpty())
        {
            throw new NullPointerException("ERROR: No user accounts with that ID found !");
        }
        repository.deleteById(id);
    }
}
