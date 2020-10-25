package match.game.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import match.game.entities.Player;



@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{
	List<Player> findAll();
}
