import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Hero hero = new Hero("Hero", 100f, 20f, true);
    Enemy enemy = new Enemy(4,4,true);

    @Test
    void fight() {
        hero.fight(enemy);
    }

    @Test
    void useItem() {
        hero.useItem(0);

    }

    @Test
    void levelUp() {
        hero.setExperience(101);
        hero.levelUp();
        assertEquals(2, hero.getLevel());
    }

    @Test
    void addToInventory() {
        Item item = new Item("Health Potion", 20);
        assertTrue(hero.addToInventory(item));
    }

    @Test
    void showInventory() {
        Item item = new Item("Health Potion", 20);
        hero.addToInventory(item);
        hero.showInventory();
    }

    @Test
    void getLevel() {
        assertEquals(1, hero.getLevel());
    }

    @Test
    void setLevel() {
        hero.setLevel(2);
        assertEquals(2, hero.getLevel());
    }

    @Test
    void getExperience() {
        assertEquals(0, hero.getExperience());
    }

    @Test
    void setExperience() {
        hero.setExperience(10);
        assertEquals(10, hero.getExperience());
    }

    @Test
    void getMoney() {
        assertEquals(0, hero.getMoney());
    }

    @Test
    void setMoney() {
        hero.setMoney(100);
        assertEquals(100, hero.getMoney());
    }

    @Test
    void getInventory() {
        assertNotNull(hero.getInventory());
    }

    @Test
    void setInventory() {
        Item[] newInventory = new Item[5];
        hero.setInventory(newInventory);
        assertArrayEquals(newInventory, hero.getInventory());
    }
}