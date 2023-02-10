package me.joshmendiola.DropDee.controller.accounts;

import me.joshmendiola.DropDee.model.accounts.UserAccount;
import me.joshmendiola.DropDee.model.assets.Band;
import me.joshmendiola.DropDee.repository.accounts.UserAccountRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserAccountController
{
    @Autowired
    UserAccountRepository repository;

    //GET MAPPINGS

    //gets all bands
    @GetMapping("/useraccounts")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserAccount> getAllUserAccounts()
    {
        return repository.findAll();
    }

    //gets band by singular ID
    @GetMapping("/useraccount/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserAccount geUserAccountById(@PathVariable UUID id)
    {
        Optional<UserAccount> returnUserAccount = repository.findById(id);
        if(returnUserAccount.isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that ID found !");
        }
        return returnUserAccount.orElse(null);
    }

    //gets band by name
    @GetMapping("/user/username/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserAccount> getUserAccountByUsername(@PathVariable String username)
    {
        if(repository.findByUsername(username).isEmpty())
        {
            throw new NullPointerException("ERROR: No entities with that name found !");
        }
        return repository.findByUsername(username);
    }

    //POST MAPPINGS

    //adds a single band to the database
    @PostMapping("/useraccount")
    @ResponseStatus(HttpStatus.CREATED)
    public UserAccount addUserAccount(@RequestBody UserAccount userAccount)
    {
        if(repository.existsById(userAccount.getUserID()))
        {
            throw new IllegalArgumentException("ERROR: An entity with that ID already exists in the database");
        }
        return repository.save(userAccount);
    }
    //UPDATE MAPPINGS

    //updates by ID
    @PutMapping("/useraccount/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserAccount(@RequestBody @NotNull UserAccount newUserAccount, @PathVariable UUID id)
    {
        UserAccount userAccount = geUserAccountById(id);
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
    @DeleteMapping("/useraccount/{id}")
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
