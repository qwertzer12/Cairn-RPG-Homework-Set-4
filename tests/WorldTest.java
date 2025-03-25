import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void getGameName() {
        World world = new World();
        world.setGameName("Adventure World");
        assertEquals("Adventure World", world.getGameName(), "Game name should be 'Adventure World'");
    }

    @Test
    void setGameName() {
        World world = new World();
        world.setGameName("Mystic Quest");
        assertEquals("Mystic Quest", world.getGameName(), "Game name should be 'Mystic Quest'");
    }

    @Test
    void getPublisher() {
        World world = new World();
        world.setPublisher("Game Studio");
        assertEquals("Game Studio", world.getPublisher(), "Publisher should be 'Game Studio'");
    }

    @Test
    void setPublisher() {
        World world = new World();
        world.setPublisher("Epic Games");
        assertEquals("Epic Games", world.getPublisher(), "Publisher should be 'Epic Games'");
    }
}
