import javax.swing.*;

public class startupWindow extends JFrame implements WindowQuitter{

    mainPanel panel;
    ImageIcon icon = new ImageIcon("icon.png");

    startupWindow(){
        this.setTitle("TicTacToe");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(612,612);
        this.setResizable(false);

        panel = new mainPanel(this);

        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void quitstartupWindow() {
        setVisible(false);
        dispose();
    }
}
