package me.joshmendiola.DropDee.repository.accounts;

import me.joshmendiola.DropDee.model.accounts.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, UUID>
{
    List<UserAccount> findByUsername(String Username);
}
