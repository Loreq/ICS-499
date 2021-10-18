package tech.teamfour.services;

import tech.teamfour.model.Player;
import java.util.List;

public interface PlayerService {
    public abstract void addPlayer(Player player);
    public void updatePlayerPassword(String newPassword, Player player);
    public void deleterPlayer(long id);
    public List<Player> getPlayers();
    public Player getPlayer(Long id);
    public List<Player> getHighScores();
}
