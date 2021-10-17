package tech.dunny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.dunny.model.Player;
import tech.dunny.repositories.PlayerRepository;
import tech.dunny.services.PlayerService;
import tech.dunny.services.PlayerServiceImpl;


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

    @RequestMapping(path = "player/add" )
    public ResponseEntity<Player> createPlayer(@RequestParam String username, @RequestParam String password){
       playerService.addPlayer(new Player(
               0L, username, password, 999
       ));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "player/delete")
    public ResponseEntity<Player> deletePlayer(@RequestParam long id){
        playerService.deleterPlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
