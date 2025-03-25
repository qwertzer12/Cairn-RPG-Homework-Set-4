import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character("Hero", 100, 20);
    }

    @Test
    void runAway() {
        character.runAway();
        assertFalse(character.isAlive(), "Character should be considered as having escaped (not alive)");
    }

    @Test
    void info() {
        String expectedInfo = "Name: Hero, Health: 100, Attack Power: 20";
        assertEquals(expectedInfo, character.Info(), "Info method should return correct details");
    }

    @Test
    void getName() {
        assertEquals("Hero", character.getName(), "getName should return correct character name");
    }

    @Test
    void setName() {
        character.setName("Warrior");
        assertEquals("Warrior", character.getName(), "setName should update character name");
    }

    @Test
    void getHealth() {
        assertEquals(100, character.getHealth(), "getHealth should return correct health value");
    }

    @Test
    void setHealth() {
        character.setHealth(80);
        assertEquals(80, character.getHealth(), "setHealth should update health value");
    }

    @Test
    void getAttackPower() {
        assertEquals(20, character.getAttackPower(), "getAttackPower should return correct attack power");
    }

    @Test
    void setAttackPower() {
        character.setAttackPower(30);
        assertEquals(30, character.getAttackPower(), "setAttackPower should update attack power");
    }

    @Test
    void isAlive() {
        assertTrue(character.isAlive(), "Character should be alive by default");
    }

    @Test
    void setAlive() {
        character.setAlive(false);
        assertFalse(character.isAlive(), "setAlive should update character's alive status");
    }
}