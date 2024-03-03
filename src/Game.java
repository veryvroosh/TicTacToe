import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    JButton[] boxes = new JButton[9];
    JPanel buttonPanel;
    JPanel winPanel;

    Game(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(612,612);
        this.setResizable(false);
        buttonPanel = new JPanel(new GridLayout(3,3,3,3));
        winPanel = new JPanel();

        winPanel.setBounds(0,256,612,100);
        winPanel.setBackground(Color.BLACK);
        winPanel.setVisible(false);

        for(int i = 0; i<boxes.length; i++) {
            boxes[i] = new JButton();
            boxes[i].setFocusable(false);
            boxes[i].setFont(new Font("Pacifico",Font.PLAIN,69));
            final int Index = i;
            boxes[i].addActionListener(
                    (e) -> {
                        if(mainPanel.playerIndicator%2==0) {
                            boxes[Index].setText("X");
                            checkWin("X");
                        }
                        else {
                            boxes[Index].setText("O");
                            checkWin("O");
                        }
                        mainPanel.playerIndicator++;
                        boxes[Index].setEnabled(false);
                    }
            );
            buttonPanel.add(boxes[i]);
        }

        this.add(winPanel);
        this.add(buttonPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void checkWin(String letter) {
        if (    (boxes[0].getText().equals(letter) && boxes[1].getText().equals(letter) && boxes[2].getText().equals(letter)) ||
                (boxes[3].getText().equals(letter) && boxes[4].getText().equals(letter) && boxes[5].getText().equals(letter)) ||
                (boxes[6].getText().equals(letter) && boxes[7].getText().equals(letter) && boxes[8].getText().equals(letter)) ||
                (boxes[0].getText().equals(letter) && boxes[3].getText().equals(letter) && boxes[6].getText().equals(letter)) ||
                (boxes[1].getText().equals(letter) && boxes[4].getText().equals(letter) && boxes[7].getText().equals(letter)) ||
                (boxes[2].getText().equals(letter) && boxes[5].getText().equals(letter) && boxes[8].getText().equals(letter)) ||
                (boxes[0].getText().equals(letter) && boxes[4].getText().equals(letter) && boxes[8].getText().equals(letter)) ||
                (boxes[2].getText().equals(letter) && boxes[4].getText().equals(letter) && boxes[6].getText().equals(letter)) ) {

            System.out.println(letter+" wins");
            winPanel.setVisible(true);
            for (int i = 0; i<boxes.length; i++) {
                boxes[i].setEnabled(false);
            }

        }
    }

}
