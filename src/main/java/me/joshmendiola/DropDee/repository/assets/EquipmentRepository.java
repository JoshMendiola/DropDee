package me.joshmendiola.DropDee.repository.assets;

import me.joshmendiola.DropDee.model.assets.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>
{
    List<Equipment> findByBrand(String brand);
}
