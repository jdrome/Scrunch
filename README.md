# Scrunch

Scrunch is a remix of the classic snake game. Rather than your snake growing after eating a fruit, your snake gets smaller (i.e., scrunched) after eating a fruit. If you don't eat, your snake will grow larger over time until you're tangled in your own tail, so eat quickly!

---

## Features
- **Classic Snake Gameplay**: Control the snake as it moves across the screen.
- **Unique Mechanic**: The snake shrinks when it eats an apple, but grows larger if no apples are consumed for too long.
- **Scoring System**: Earn points for each apple eaten.
- **Challenging Gameplay**: The snake grows over time, making it harder to avoid collisions.

## Getting Started

### Prerequisites
To run this project, you'll need:
- Java JDK 8 or higher installed.
- An IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/), or you can run the game via the terminal.

### How to Launch the Game

#### Option 1: Using an IDE
1. Download and install an IDE like IntelliJ IDEA or Eclipse.
2. Open the project in the IDE.
3. Ensure all dependencies are installed.
4. Run the `ScrunchGame.java` file to launch the game.

#### Option 2: Running from Terminal
1. Compile the Java files by navigating to the project directory and running:
    ```bash
    javac ScrunchGame.java GameFrame.java GamePanel.java
    ```
2. Run the compiled code with:
    ```bash
    java ScrunchGame
    ```

---

## How to Play

- Use the arrow keys to control the direction of the snake:
  - `Left Arrow`: Move left
  - `Right Arrow`: Move right
  - `Up Arrow`: Move up
  - `Down Arrow`: Move down
- The objective is to eat the green apple without crashing into the walls or the snake's own body.
- Each time the snake eats an apple, it will shrink. If no apples are eaten, the snake will grow over time.
- The game ends when the snake crashes into itself or the edge of the screen.

---

## Screenshots

Include a few screenshots of your game here. For example:
1. **Gameplay Screen**: (Insert screenshot of the game in action).
2. **Game Over Screen**: (Insert screenshot of the Game Over screen).
   
---

## Future Improvements

- **Restart Button**: A button to quickly restart the game without needing to close and reopen the application.
- **High Score Tracking**: Keep track of the highest score achieved during gameplay.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.