package tech.teamfour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import tech.teamfour.model.Player;
import tech.teamfour.services.PlayerService;
import tech.teamfour.services.PlayerServiceImpl;

import java.security.Principal;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlayerController {

    final PlayerService playerService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService, BCryptPasswordEncoder bcpe) {
        this.playerService = playerService;
        this.bCryptPasswordEncoder = bcpe;
    }

    @GetMapping("player/{id}")
    public ResponseEntity getPlayer(@PathVariable("id") Long id){
        return new ResponseEntity(playerService.getPlayer(id), HttpStatus.OK);
        //return new ResponseEntity<>(playerService.getPlayer(id), HttpStatus.OK);
    }

    @GetMapping("player/un/{un}")
    public ResponseEntity getPlayerByName(@PathVariable("un") String un){
        return new ResponseEntity(playerService.getPlayerByName(un), HttpStatus.OK);
    }

    @RequestMapping("player/{id}/setHighScore")
    public ResponseEntity setHighSCore(@PathVariable("id") long id, @RequestParam("score") int score){
        Player p = playerService.getPlayer(id);
        if(p.getBestScore() > score) {
            playerService.setHighScore(score, id);
            return new ResponseEntity("Score updated", HttpStatus.OK);
        }else{
            return new ResponseEntity("Didn't beat highscore", HttpStatus.OK);
        }
    }

    @GetMapping("player/all")
    public ResponseEntity getAllPlayers(){
        return new ResponseEntity(playerService.getPlayers(), HttpStatus.OK);
    }

    @RequestMapping(path = "player/add" )
    public ResponseEntity<Player> createPlayer(@RequestParam String username, @RequestParam String password){
       playerService.addPlayer(new Player(
               0L, username, bCryptPasswordEncoder.encode(password), 999, true, "ROLE_USER"
       ));
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    
    @RequestMapping(path = "player/addAdmin" )
    public ResponseEntity<Player> createAdmin(@RequestParam String username, @RequestParam String password){
       playerService.addPlayer(new Player(
               0L, username, password, 999, true, "ROLE_ADMIN"
       ));
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    
    @GetMapping("player/addBatchTestData")
    public ResponseEntity<Player> createBatchOfPlayers() {   
    	
    	for( int i = 0; i < 255; i++) {
    		
    		Random rand = new Random();
    		char c = (char) ('a' + rand.nextInt(26));
    		
    		long batchId = 0L;
    		String batchName = c + String.valueOf(i);	
    		String batchPassword = "password" +String.valueOf(i);
    		int  batchScore = 100 + rand.nextInt(10000);
    	
            Player batchPlayer = new Player(batchId, batchName, bCryptPasswordEncoder.encode(batchPassword),batchScore, true, "ROLE_USER");

            playerService.addPlayer(batchPlayer);
    	}
        
    	 return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("player/addBatchAdmins")
    public ResponseEntity<Player> createBatchOfAdmins() {   
    	
    	for( int i = 0; i < 5; i++) {
    		
    		Random rand = new Random();
    		
    		
    		long batchId = 0L;
    		String batchName = "admin" + String.valueOf(i);	
    		String batchPassword = "admin" +String.valueOf(i);
    		int  batchScore = 100 + rand.nextInt(10000);
    	
            Player batchPlayer = new Player(batchId, batchName,bCryptPasswordEncoder.encode(batchPassword),batchScore, true, "ROLE_ADMIN");

            playerService.addPlayer(batchPlayer);
    	}
        
    	 return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "player/delete")
    public ResponseEntity<Player> deletePlayer(@RequestParam long id){
        playerService.deleterPlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(path = "player/changeRole")
    public ResponseEntity<Player> changePlayerRole(@RequestParam long id, @RequestParam String newRole){
        playerService.changePlayerRole(id, newRole);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
