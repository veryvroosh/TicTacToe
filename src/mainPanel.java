import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {

    Image bgImage;
    JButton START;
    JButton PLAYERS;
    JButton QUIT;
    WindowQuitter windowQuitter;
    public static int playerIndicator = 2;
    public static String player1 = "Player 1";
    public static String player2 = "Player 2";

    mainPanel(WindowQuitter windowQuitter){

        this.windowQuitter = windowQuitter;

        setLayout(null);
        bgImage = new ImageIcon("bg.png").getImage();

        START = new JButton("Start");
        PLAYERS = new JButton("Players");
        QUIT = new JButton("Quit");

        START.setBounds(256, 360, 100, 50);
        PLAYERS.setBounds(256, 420, 100, 50);
        QUIT.setBounds(256, 480, 100, 50);
        START.setFocusable(false);
        PLAYERS.setFocusable(false);
        QUIT.setFocusable(false);

        START.addActionListener(
                (e) -> {
                    windowQuitter.quitstartupWindow();
                    new Game();
                }
        );

        PLAYERS.addActionListener(
                (e) -> {
                    player1 = JOptionPane.showInputDialog(null, "What is Player 1's name?");
                    player2 = JOptionPane.showInputDialog(null, "What is Player 2's name?");
                }
        );

        QUIT.addActionListener(
                (e) -> windowQuitter.quitstartupWindow()
        );

        add(START);
        add(PLAYERS);
        add(QUIT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);  // Draw image using panel dimensions
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(612, 712);  // Set preferred size for the panel
    }
}
