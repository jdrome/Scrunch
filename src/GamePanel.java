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
    static final int delay = 75; // The higher the number, the slower the game. Originally 75.
    final int x[] = new int[gameUnits]; // X coordinates (including head) of snake's body parts.
    final int y[] = new int [gameUnits]; // Y coordinates (including head) of snake's body parts.
    int bodyParts = 3; // Initial length of the snake (i.e. how many "body parts" you start with). Was 6, changed to 3. 
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
        running = true;
        timer = new Timer(delay, this); // Timer has two parameters, "delay" and "actionListener". We put "this" as the value for the actionListener argument because we are implementing the actionListener interface. 
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if(running) {
            // Draw grid lines in game panel.
            for(int i = 0; i < screenHeight / unitSize; i++) {
                g.setColor(new Color(60, 60, 60, 255));
                g.drawLine(i * unitSize, 0, i * unitSize, screenHeight); // Vertical lines
                g.drawLine(0, i * unitSize, screenWidth, i * unitSize); // Horizontal lines
            }

            // Draws apple on game panel
            g.setColor(new Color(0, 255, 0));
            g.fillOval(appleX, appleY, unitSize, unitSize);

            // Draw snake
            for (int i = 0; i < bodyParts; i++) {
                // Draw head of snake
                if(i == 0) {
                    g.setColor(new Color(0, 218, 255));
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
                // Draw body of snake
                else {
                    g.setColor(new Color(0, 80, 255));
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
            }

            // Display score when apple is eaten
            g.setColor(Color.red);
            g.setFont(new Font("Noteworthy", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont()); // Used to center text
            g.drawString("Score: " + applesEaten, (screenWidth - metrics.stringWidth("Score" + applesEaten)) / 2, g.getFont().getSize()); // Puts "Game Over" in center of screen

        }
        else {
            gameOver(g);
        }
    }

    public void newApple() {

        appleX = random.nextInt((int)(screenWidth / unitSize)) * unitSize;
        appleY = random.nextInt((int)(screenHeight / unitSize)) * unitSize;

    }

    public void move() {
        for(int i = bodyParts; i > 0 ; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        switch(direction) {
            case 'U':
                y[0] = y[0] - unitSize;
                break;
            case 'D':
                y[0] = y[0] + unitSize;
                break;
            case 'L':
                x[0] = x[0] - unitSize;
                break;
            case 'R':
                x[0] = x[0] + unitSize;
                break;
        }
    }

    public void checkApple() {

        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
        
    }

    public void checkCollisions() {
        for(int i = bodyParts; i > 0; i--) {
            // If head collides with body
            if((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
            // If head collides with left border
            if(x[0] < 0) {
                running = false;
            }
            // if head collides with right border
            if(x[0] > screenWidth) {
                running = false;
            }
            // if head collides with top border
            if(y[0] < 0) {
                running = false;
            }
            // if head collides with bottom border
            if(y[0] > screenHeight) {
                running = false;
            }

            if(!running) {
                timer.stop();
            }
        }
    }

    public void gameOver(Graphics g) {

        // Game Over Text
        g.setColor(Color.red);
        g.setFont(new Font("Noteworthy", Font.BOLD, 75));
        FontMetrics metricsGameOver = getFontMetrics(g.getFont()); // Used to center text
        g.drawString("Game Over", (screenWidth - metricsGameOver.stringWidth("Game Over")) / 2, screenHeight / 2); // Puts "Game Over" in center of screen

        // Score
        g.setColor(Color.red);
        g.setFont(new Font("Noteworthy", Font.BOLD, 40));
        FontMetrics metricsScore = getFontMetrics(g.getFont()); // Used to center text
        g.drawString("Score: " + applesEaten, (screenWidth - metricsScore.stringWidth("Score" + applesEaten)) / 2, g.getFont().getSize()); // Puts "Game Over" in center of screen

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}