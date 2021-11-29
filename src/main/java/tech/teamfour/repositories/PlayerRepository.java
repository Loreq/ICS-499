package tech.teamfour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.teamfour.model.Player;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
     Player findByUserName(String userName);
}
