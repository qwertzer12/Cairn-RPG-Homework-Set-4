# Cairn-RPG-Homework-Set-4

## Overview

Cairn-RPG-Homework-Set-4 is a simple text-based RPG game implemented in Java. The game allows players to create a hero character, fight enemies, use items, and level up.

## Features

- Create and customize a hero character.
- Fight against enemies and bosses.
- Use items to heal and enhance abilities.
- Level up and improve character stats.
- Simple text-based user interface.

## Classes

### World

Represents the game world, including the game name and publisher.

### Character

Base class for all characters in the game, including hero and enemies. Contains attributes like name, health, attack power, and alive status.

### Hero

Extends `Character` and includes additional attributes like level, experience, money, and inventory. Provides methods for fighting, using items, leveling up, and managing inventory.

### Enemy

Extends `Character` and includes additional attributes like magic power. Provides methods for fighting.

### Boss

Extends `Enemy` and represents a boss enemy with enhanced abilities.

### Item

Represents an item that can be used by the hero. Contains attributes like name and healing power.

## How to Play

1. Run the `Main` class to start the game.
2. Enter your hero's name when prompted.
3. Choose actions during your turn:
   - Attack: Fight the enemy.
   - Run Away: Attempt to escape from the battle.
   - Check Info: View your hero's current stats.
   - Heal: Use a healing item.
   - Exit Game: Quit the game.
4. Defeat enemies to gain experience and level up.
5. Manage your inventory and use items strategically to survive.

## Requirements

- Java 11 or higher
- IntelliJ IDEA or any other Java IDE

## Running the Game

1. Clone the repository:
   ```sh
   git clone https://github.com/qwertzer12/Cairn-RPG-Homework-Set-4.git
   ```
