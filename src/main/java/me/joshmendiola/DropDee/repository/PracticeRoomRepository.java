package me.joshmendiola.DropDee.repository;

import me.joshmendiola.DropDee.model.PracticeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRoomRepository extends JpaRepository<PracticeRoom, Integer>
{
}
