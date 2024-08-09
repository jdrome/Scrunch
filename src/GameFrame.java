import javax.swing.JFrame;

public class GameFrame extends JFrame{
    GameFrame() {

        this.add(new GamePanel());
        this.setTitle("Scrunch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); // Fits JFrame around all components added to frame
        this.setVisible(true);
        this.setLocationRelativeTo(null); // Game will appear centered on computer screen
        
    }
}