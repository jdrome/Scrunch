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

    GamePanel() {

    }

    public void startGame() {

    }
    
    public void paintComponent(Graphics g) {

    }

    public void draw(Graphics g) {

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