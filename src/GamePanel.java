import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static final int screenWidth = 600;
    static final int screenHeight = 600;
    static final int unitSize = 25; // Size of items in the game.
    static final int gameUnits = (screenWidth * screenHeight / unitSize); // Calculates how many items we can have in our game.
    static final int delay = 75; // The higher the number, the slower the game.
    final int x[] = new int[gameUnits]; // X coordinates (including head) of snake's body parts.
    final int y[] = new int [gameUnits]; // Y coordinates (including head) of snake's body parts.
    int bodyParts = 6; // Initial length of the snake (i.e. how many "body parts" you start with).
    int applesEaten; // This is the count of apples eaten. Initialized at 0.
    int appleX; // Random X coordinate of the apple that the snake eats. Becomes random every time the snake eats an apple.
    int appleY; // Random Y coordinate of the apple that the snake eats. Becomes random every time the snake eats an apple.
    char direction = 'R'; // Snake begins by going right. R = right; L = left; U = up; D = down.
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); // Set color of game board.
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = false;
        timer = new Timer(delay, this); // Timer has two parameters, "delay" and "actionListener". We put "this" as the value for the actionListener argument because we are implementing the actionListener interface. 
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        for(int i = 0; i < screenHeight/unitSize; i++) {
            g.drawLine(i * unitSize, 0, i * unitSize, screenHeight);
        }

    }

    public void newApple() {

    }

    public void move() {

    }

    public void checkApple() {

    }

    public void checkCollisions() {

    }

    public void gameOver(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Fill in Method here
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

        }
    }
}