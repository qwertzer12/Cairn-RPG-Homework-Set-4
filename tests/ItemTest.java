import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Potion", 50);
    }

    @Test
    void info() {
        String expected = "Item{name='Potion', healingPower=50}";
        assertEquals(expected, item.Info());
    }

    @Test
    void getName() {
        assertEquals("Potion", item.getName());
    }

    @Test
    void setName() {
        item.setName("Elixir");
        assertEquals("Elixir", item.getName());
    }

    @Test
    void getHealingPower() {
        assertEquals(50, item.getHealingPower());
    }

    @Test
    void setHealingPower() {
        item.setHealingPower(100);
        assertEquals(100, item.getHealingPower());
    }
}
