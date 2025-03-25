import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CharacterTest {
    Character character = new Character("test", 100, 20, true);

    @Test
    void runAway() {
       character.runAway();
    }

    @Test
    void info() {
        assertEquals("test: 100.0 HP, 20.0 AP.", character.Info());
    }

    @Test
    void getName() {
        assertEquals("test", character.getName());
    }

    @Test
    void setName() {
        character.setName("test2");
        assertEquals("test2", character.getName());
    }

    @Test
    void getHealth() {
        assertEquals(100, character.getHealth());
    }

    @Test
    void setHealth() {
        character.setHealth(200);
        assertEquals(200, character.getHealth());
    }

    @Test
    void getAttackPower() {
        assertEquals(20, character.getAttackPower());
    }

    @Test
    void setAttackPower() {
        character.setAttackPower(30);
        assertEquals(30, character.getAttackPower());
    }

    @Test
    void isAlive() {
        assertTrue(character.isAlive());
    }

    @Test
    void setAlive() {
        character.setAlive(false);
        assertFalse(character.isAlive());
    }
}