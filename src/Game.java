import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    JButton box1;
    JButton box2;
    JButton box3;
    JButton box4;
    JButton box5;
    JButton box6;
    JButton box7;
    JButton box8;
    JButton box9;


    Game(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(612,612);
        this.setResizable(false);
        this.setLayout(new GridLayout(3,3,3,3));

        box1 = new JButton();
        box2 = new JButton();
        box3 = new JButton();
        box4 = new JButton();
        box5 = new JButton();
        box6 = new JButton();
        box7 = new JButton();
        box8 = new JButton();
        box9 = new JButton();


        this.add(box1);
        this.add(box2);
        this.add(box3);
        this.add(box4);
        this.add(box5);
        this.add(box6);
        this.add(box7);
        this.add(box8);
        this.add(box9);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
