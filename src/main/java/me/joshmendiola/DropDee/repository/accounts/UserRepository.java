package me.joshmendiola.DropDee.repository.accounts;

import me.joshmendiola.DropDee.model.accounts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
    User findByUsername(String Username);
}
