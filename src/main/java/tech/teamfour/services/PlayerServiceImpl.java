package tech.teamfour.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.teamfour.model.Player;
import tech.teamfour.repositories.PlayerRepository;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    private PlayerRepository playerRepo;

    @Autowired
    public PlayerServiceImpl(PlayerRepository pr){
        this.playerRepo = pr;
    }

    @Override
    public void addPlayer(Player player) {
        if(player.playerID != null && player.getUserName() != null){
            playerRepo.save(player);
        }
    }

    @Override
    public void updatePlayerPassword(String newPassword, Player player) {
        Player updatedPlayer = playerRepo.getById(player.getPlayerID());
        updatedPlayer.setPassword(newPassword);
        playerRepo.deleteById(player.playerID);
        addPlayer(updatedPlayer);
    }

    @Override
    public void deleterPlayer(long id) {
        if(checkExistance(id)) playerRepo.deleteById(id);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepo.getById(id);
    }

    @Override
    public List<Player> getHighScores(){
        List<Player> sortedPlayers = getPlayers();
        sortedPlayers.sort((p1, p2)
                -> ((Integer)p1.getBestScore()).compareTo((Integer)p2.getBestScore()));
        return sortedPlayers;
    }

    private boolean checkExistance(long id){
        if(playerRepo.existsById(id)){
            return true;
        }
        return false;
    }
}
