package match.game.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import match.game.entities.Player;
import match.game.service.PlayerService;

@Controller
public class HomeController {

	
	@Autowired
	PlayerService playerService;
	@RequestMapping(value="/wagner",
			method = RequestMethod.GET)
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView("home");
		List<Player> players = playerService.getAllPlayers(); 
		model.addObject("players", players);
		int size = players.size();
		return model;
	}
}
