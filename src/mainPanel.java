import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mainPanel extends JPanel {

    ImageIcon mute = new ImageIcon("mute.png");
    ImageIcon unmute = new ImageIcon("unmute.png");
    File bgMusic = new File("bgmusic.wav");
    Clip clip;
    Image bgImage;
    JButton START;
    JButton PLAYERS;
    JButton QUIT;
    JButton MUTE;
    WindowQuitter windowQuitter;
    public static int playerIndicator = 2;
    public static String player1 = "Player 1";
    public static String player2 = "Player 2";

    mainPanel(WindowQuitter windowQuitter) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.windowQuitter = windowQuitter;

        setLayout(null);
        bgImage = new ImageIcon("bg.png").getImage();

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(bgMusic);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        final boolean[] isMuted = {false};

        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        volumeControl.setValue(-40.0f);

        START = new JButton("Start");
        PLAYERS = new JButton("Players");
        QUIT = new JButton("Quit");
        MUTE = new JButton();

        START.setBounds(256, 360, 100, 50);
        PLAYERS.setBounds(256, 420, 100, 50);
        QUIT.setBounds(256, 480, 100, 50);
        MUTE.setBounds(555, 535, 30, 30);
        START.setFocusable(false);
        PLAYERS.setFocusable(false);
        QUIT.setFocusable(false);
        MUTE.setFocusable(false);
        MUTE.setIcon(unmute);

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

        MUTE.addActionListener(
                (e) -> {
                    if (!isMuted[0]) {
                        volumeControl.setValue(Float.NEGATIVE_INFINITY);
                        isMuted[0] = true;
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        MUTE.setIcon(mute);
                    } else {
                        volumeControl.setValue(-40.0f);
                        isMuted[0] = false;
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        MUTE.setIcon(unmute);
                    }
                }
        );

        add(START);
        add(PLAYERS);
        add(QUIT);
        add(MUTE);
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
