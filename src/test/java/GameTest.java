import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Tanya", 10);
    Player player2 = new Player(2, "Masha", 8);
    Player player3 = new Player(3, "Petya", 8);

    @Test
    public void shouldRegisterNewPlayer() {
        Game game = new Game();
        boolean registrationResult = game.register(player1);
        Assertions.assertTrue(registrationResult);
    }

    @Test
    public void shouldNotRegisterNewPlayerTwice() {
        Game game = new Game();
        boolean firstRegistrationResult = game.register(player1);
        Assertions.assertTrue(firstRegistrationResult);
        boolean secondRegistrationResult = game.register(player1);
        Assertions.assertFalse(secondRegistrationResult);
    }

    @Test
    public void shouldRegisterTwoDifferentPlayers() {
        Game game = new Game();
        boolean firstPlayerRegistrationResult = game.register(player1);
        Assertions.assertTrue(firstPlayerRegistrationResult);
        boolean secondPlayerRegistrationResult = game.register(player2);
        Assertions.assertTrue(secondPlayerRegistrationResult);
    }

    @Test
    public void shouldReturnZeroIfStrengthEqual() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        int roundResult = game.round("Masha", "Petya");
        Assertions.assertEquals(0, roundResult);
    }

    @Test
    public void shouldReturnOneIfFirstPlayerStronger() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int roundResult = game.round("Tanya", "Masha");
        Assertions.assertEquals(1, roundResult);
    }

    @Test
    public void shouldReturnTwoIfSecondPlayerStronger() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int roundResult = game.round("Masha", "Tanya");
        Assertions.assertEquals(2, roundResult);
    }

    @Test
    public void shouldThrowNotRegisteredExceptionIfPlayerNotRegistered() {
        Game game = new Game();
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Tanya", "Masha");
        });
    }

}
