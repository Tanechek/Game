import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> registeredPlayers;

    public Game() {
        this.registeredPlayers = new ArrayList<>();
    }

    public boolean register(Player player) {
        for (Player registeredPlayer : registeredPlayers) {
            if (registeredPlayer.getId() == player.getId()) {
                return false;
            }
        }
        registeredPlayers.add(player);
        return true;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    private Player findByName(String playerName) {
        for (Player registeredPlayer : registeredPlayers) {
            if (registeredPlayer.getName().equals(playerName)) {
                return registeredPlayer;
            }
        }
        throw new NotRegisteredException("Player with name " + playerName + " not registered");
    }

}
