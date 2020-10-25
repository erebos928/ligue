package match.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import match.game.dao.PlayerRepository;
import match.game.entities.Player;
import match.game.service.PlayerService;
@Service("PlayerService")
public class PlayerServiceImpl implements PlayerService{
@Autowired
PlayerRepository playerRepository;
	@Override
	public List<Player> getAllPlayers() {
		List<Player> players =  playerRepository.findAll();
		return players;
		
	}

}
