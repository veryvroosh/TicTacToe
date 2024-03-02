import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {

    Image bgImage;
    JButton PLAY;
    JButton SWITCH;
    JButton QUIT;
    WindowQuitter windowQuitter;

    mainPanel(WindowQuitter windowQuitter){

        this.windowQuitter = windowQuitter;

        this.setLayout(null);
        bgImage = new ImageIcon("bg.png").getImage();

        PLAY = new JButton("Play");
        SWITCH = new JButton("Switch");
        QUIT = new JButton("Quit");

        PLAY.setBounds(256,360,100,50);
        SWITCH.setBounds(256,420,100,50);
        QUIT.setBounds(256,480,100,50);
        PLAY.setFocusable(false);
        SWITCH.setFocusable(false);
        QUIT.setFocusable(false);

        PLAY.addActionListener(
                (e) -> {
                    windowQuitter.quitstartupWindow();
                    new Game();
                }
        );

        QUIT.addActionListener(
                (e) -> windowQuitter.quitstartupWindow()
        );

        this.add(PLAY);
        this.add(SWITCH);
        this.add(QUIT);

    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bgImage,0,0,null);
    }

}
