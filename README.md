# Cairn-RPG-Homework-Set-4

## Overview

Cairn RPG is a text-based role-playing game where players can choose a character class, fight enemies, and use various items. The game is developed in Java and includes several classes to manage the game world, player, and enemies.

## Project Structure

- `src/Data/Player.java`: Defines the `Player` class, which extends the `Character` class and includes player-specific attributes.
- `src/Main.java`: Contains the main game loop, handles user input, and manages the game flow.
- `src/GUI.java`: Works as a GUI port of `Main.java`.
- `src/Data/World.java`: Defines the `World` class, which initializes the game world with weapons and healing items.

## Classes

### Player

The `Player` class represents the player character in the game. It includes attributes such as level, experience, and money.

### World

The `World` class initializes the game world with a list of weapons and healing items. It also provides methods to retrieve random weapons and healing items.

### Main

The `Main` class contains the main game loop, handles user input, and manages the game flow. It allows players to choose their character class, fight enemies, and use items.

## How to Run

1. Compile the Java files:
   ```sh
   javac src/Data/*.java src/Main.java
   ```
