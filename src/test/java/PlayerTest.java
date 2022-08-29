import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player = new Player(1, "Ivan", 10);

    @Test
    public void shouldGetId() {
        Assertions.assertEquals(player.getId(), 1);
    }

    @Test
    public void shouldGetName() {
        Assertions.assertEquals(player.getName(), "Ivan");
    }

    @Test
    public void shouldGetStrength() {
        Assertions.assertEquals(player.getStrength(), 10);
    }

}
