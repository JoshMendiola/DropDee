package me.joshmendiola.DropDee.repository.assets;

import me.joshmendiola.DropDee.model.assets.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository<Band, Integer>
{
    List<Band> findByName(String name);
}
