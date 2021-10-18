package tech.teamfour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.teamfour.model.Player;
import tech.teamfour.services.PlayerService;
import tech.teamfour.services.PlayerServiceImpl;

@RestController
public class PlayerController {

    final
    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @GetMapping("player/{id}")
    public ResponseEntity getPlayer(@PathVariable("id") Long id){
        return new ResponseEntity(playerService.getPlayer(id), HttpStatus.OK);
        //return new ResponseEntity<>(playerService.getPlayer(id), HttpStatus.OK);
    }

    @GetMapping("player/all")
    public ResponseEntity getAllPlayers(){
        return new ResponseEntity(playerService.getPlayers(), HttpStatus.OK);
    }

    @RequestMapping(path = "player/add" )
    public ResponseEntity<Player> createPlayer(@RequestParam String username, @RequestParam String password){
       playerService.addPlayer(new Player(
               0L, username, password, 999
       ));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("player/highscores")
    public ResponseEntity getSortedScores(){ return new ResponseEntity(playerService.getHighScores(), HttpStatus.OK);}

    @RequestMapping(path = "player/delete")
    public ResponseEntity<Player> deletePlayer(@RequestParam long id){
        playerService.deleterPlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
