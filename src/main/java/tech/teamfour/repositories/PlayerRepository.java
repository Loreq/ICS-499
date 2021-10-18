package tech.teamfour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.teamfour.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
