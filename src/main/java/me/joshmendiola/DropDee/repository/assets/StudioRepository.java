package me.joshmendiola.DropDee.repository.assets;

import me.joshmendiola.DropDee.model.assets.PracticeRoom;
import me.joshmendiola.DropDee.model.assets.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer>
{
}
