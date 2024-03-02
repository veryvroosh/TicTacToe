import javax.swing.*;

public class startupWindow extends JFrame implements WindowQuitter{

    mainPanel panel;

    startupWindow(){
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
