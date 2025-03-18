import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Hero hero = new Hero("goblin", 50, 50, false);
    Enemy enemy = new Enemy(4, 4, true);

    @Test
    void fight() {
        enemy.fight(hero);
    }

    @Test
    void getMagicPower() {
        assertEquals(30, enemy.getMagicPower());
    }

    @Test
    void setMagicPower() {
        enemy.setMagicPower(40);
        assertEquals(40, enemy.getMagicPower());
    }
}