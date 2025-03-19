import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    Boss boss = new Boss("Boss", 100, 30, true);
    Hero hero = new Hero("test", 100, 20, true);

    @Test
    void fight() {
        boss.fight(hero);
    }
}