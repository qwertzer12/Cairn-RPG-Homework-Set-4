package Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void addHealingItems() {
        World world =  new World();
        Character character = new Character("Test", 2f, 2f, true);
        character.addHealingItems(world.returnHealingItem(0), 1);
        assertEquals(1, character.getHealingItems().size());
    }

    @Test
    void removeHealingItems() {
        World world =  new World();
        Character character = new Character("Test", 2f, 2f, true);
        character.addHealingItems(world.returnHealingItem(0), 7);
        character.addHealingItems(world.returnHealingItem(1), 5);
        System.out.println(character.getHealingItems().size());
        character.removeHealingItems(world.returnHealingItem(0), 8);
        System.out.println(character.getHealingItems().size());
        assertEquals(1, character.getHealingItems().size());

    }
}