# Pirate Game

![Pirate Game Screenshot](https://github.com/Yashi11/PirateGame/assets/73705143/e41cb762-31f4-4243-b1de-3c5b7beb9033)

Welcome to Pirate Game, a thrilling platformer game built entirely in Java, with no external libraries! In this exciting adventure, you'll take on the role of a brave pirate, navigating through five challenging levels filled with enemies, obstacles, and hidden treasures.
## ScreenShots
![image](https://github.com/Yashi11/PirateGame/assets/73705143/84d1b0f1-9e34-44f7-a29b-4904c3e569e8)
![image](https://github.com/Yashi11/PirateGame/assets/73705143/44d84690-b0a2-4104-8999-55403a31f21f)
![image](https://github.com/Yashi11/PirateGame/assets/73705143/650fc24d-d604-47e8-a6b1-2a8a71055a6b)
![image](https://github.com/Yashi11/PirateGame/assets/73705143/9269099f-988f-4529-b0b7-394b901d0bac)
![image](https://github.com/Yashi11/PirateGame/assets/73705143/0a360d6e-2c9e-4055-9c2b-c856d91b5567)



## Playing Instructions

- Use **A** to move left and **D** to move right.
- Press **SPACE** to jump over gaps and obstacles.
- Use **X** to perform a regular attack against enemies.
- Unleash the powerful **Z** attack to defeat stronger foes.

## Game Features

### Java Libraries and Classes Used

- **BufferedImage**: Used for handling images and sprites, creating visual elements for characters, enemies, and backgrounds.
- **Clip**: Utilized for handling sound effects and background music, enhancing the gaming experience.
- **FloatControls**: Implemented to adjust the volume of the sound effects and music in the game.

### Levels and Gameplay

- The game features five challenging levels, each with its unique design, enemies, and obstacles.
- The gameplay revolves around a game loop, ensuring smooth rendering, updating, and input handling during runtime.
- Collision detection is implemented to manage interactions between the player, enemies, and the environment, allowing for dynamic gameplay.

### Class Hierarchy

The game is built using object-oriented principles, with the following class hierarchy:

- **Entity**: Serves as the base class for all characters in the game, including the player and enemies.
    - **Player**: Represents the player-controlled pirate character, inheriting from `Entity`.
    - **Enemy**: Represents various enemy types, inheriting from `Entity`.
        - **Crabby**: Represents the `Enemy` crab. Other enemy types can also be added in a similar manner.

- **AudioPlayer**: Handles audio and sound effects in the game.

- **State**: Represents different states of the game.
    - **Menu**: Manages the main menu of the game.
    - **Playing**: Controls the gameplay state.
    - **GameOptions**: Allows the player to customize game settings.

- **Objects**: Represents various objects and entities present in the game world.
    - **Cannon**: Represents a cannon that the player can interact with.
    - **GameContainer**: Represents a container with hidden treasures or power-ups.
    - **Potion**: Represents a health potion that the player can collect to restore health.
    - **Spikes**: Represents dangerous spikes that the player needs to avoid.

### Animations

- Animations are used to bring characters and objects to life, creating a more immersive experience.
- Characters have animations for walking, jumping, attacking, and taking damage.

## Contribute and Play

Feel free to explore the repository, analyze the code, and use it as a foundation to build your own games or simply play the Pirate Game. The code is designed to be beginner-friendly while demonstrating essential Java concepts, making it a great learning resource for aspiring game developers.

Get ready for an adventure of a lifetime. Set sail, fight enemies, and uncover hidden treasures in Pirate Game! Enjoy the journey and may the wind be in your favor!
