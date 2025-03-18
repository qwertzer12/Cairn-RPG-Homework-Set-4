package Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void getGameName_returnsCorrectName() {
        World world = new World();
        assertEquals("Cairn RPG", world.getGameName());
    }

    @Test
    void getPublisher_returnsCorrectPublisher() {
        World world = new World();
        assertEquals("AJ Chabin, Samuel Chapin", world.getPublisher());
    }

    @Test
    void getWeapons_returnsNonEmptyList() {
        World world = new World();
        assertFalse(world.getWeapons().isEmpty());
    }

    @Test
    void randomWeapon_returnsWeaponFromList() {
        World world = new World();
        Weapon randomWeapon = world.randomWeapon();
        assertTrue(world.getWeapons().contains(randomWeapon));
    }

    @Test
    void getHealingItems_returnsNonEmptyList() {
        World world = new World();
        assertFalse(world.getHealingItems().isEmpty());
    }

    @Test
    void randomHealingItem_returnsHealingItemFromList() {
        World world = new World();
        HealingItem randomHealingItem = world.randomHealingItem();
        assertTrue(world.getHealingItems().contains(randomHealingItem));
    }
}