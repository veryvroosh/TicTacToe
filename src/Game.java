import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    JButton[] boxes = new JButton[9];
    ImageIcon icon = new ImageIcon("icon.png");
    JPanel buttonPanel;
    JPanel topPanel;
    JLabel turn;

    Game(){
        this.setTitle("TicTacToe");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(612,712);
        this.setResizable(false);
        buttonPanel = new JPanel(new GridLayout(3,3,3,3));
        buttonPanel.setBackground(new Color(6,186,170));


        turn = new JLabel();
        turn.setText(mainPanel.player1+"'s turn");
        turn.setFont(new Font ("Pacifico", Font.PLAIN, 30));
        turn.setForeground(new Color(17,33,58));
        turn.setVerticalAlignment(JLabel.CENTER);
        turn.setHorizontalAlignment(JLabel.CENTER);


        topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(100,100));
        topPanel.setBackground(new Color(6,186,170));
        topPanel.add(turn);



        for(int i = 0; i<boxes.length; i++) {
            boxes[i] = new JButton();
            boxes[i].setFocusable(false);
            boxes[i].setFont(new Font("Pacifico",Font.BOLD,69));
            boxes[i].setForeground(new Color(17,33,58));
            boxes[i].setBackground(new Color(219,171,35));
            final int Index = i;
            boxes[i].addActionListener(
                    (e) -> {
                        if(mainPanel.playerIndicator % 2 == 0) {
                            boxes[Index].setText("X");
                            checkWin("X");
                        }
                        else {
                            boxes[Index].setText("O");
                            checkWin("O");
                        }
                        mainPanel.playerIndicator++;
                        boxes[Index].setEnabled(false);

                        if(mainPanel.playerIndicator % 2 == 0) {
                            turn.setText(mainPanel.player1+"'s turn");
                        }
                        else {
                            turn.setText(mainPanel.player2+"'s turn");
                        }

                        checkDraw();
                    }
            );
            buttonPanel.add(boxes[i]);
        }

        this.add(topPanel, BorderLayout.NORTH);
        this.add(buttonPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    int displayWin_indicator;
    public void displayWin() {
        if(displayWin_indicator==0) {
            turn.setFont(new Font ("Pacifico", Font.BOLD, 40));
            turn.setText(mainPanel.player1+" WINS!!");
        }
        else if (displayWin_indicator==1){
            turn.setFont(new Font ("Pacifico", Font.BOLD, 40));
            turn.setText(mainPanel.player2+" WINS!!");
        }
    }

    public void checkDraw() {
        boolean anyEnabled = false;
        for (JButton box : boxes) {
            if (box.isEnabled()) {
                anyEnabled = true;
                break;
            }
        }
        if (!anyEnabled) {
            turn.setFont(new Font ("Pacifico", Font.BOLD, 40));
            turn.setText("DRAW");

            int answer = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "TicTacToe", JOptionPane.YES_NO_OPTION);
            if(answer == 0) {
                newGame();
            }
            else {
                setVisible(false);
                dispose();
            }
        }
    }

    public void checkWin(String letter) {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontal
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertical
                {0, 4, 8}, {2, 4, 6}             // Diagonal
        };

        for(int[] condition : winPatterns) {
            if (boxes[condition[0]].getText().equals(letter) &&
                    boxes[condition[1]].getText().equals(letter) &&
                    boxes[condition[2]].getText().equals(letter)) {

                for (int i : condition) {
                    boxes[i].setBackground(Color.yellow);
                }

                for (JButton box : boxes) {
                    box.setEnabled(false);
                }

                if(letter.equals("X")) {
                    displayWin_indicator = 0;
                }
                else{
                    displayWin_indicator = 1;
                }

                mainPanel.playerIndicator = 1;

                System.out.println(letter+" wins");

                displayWin();

                int answer = JOptionPane.showConfirmDialog(null, "Do you want to play again", "TicTacToe", JOptionPane.YES_NO_OPTION);
                if(answer == 0) {
                    newGame();
                }
                else {
                    setVisible(false);
                    dispose();
                }

                for (JButton box : boxes) {
                    box.setEnabled(true);
                }

                break;
            }
        }
    }

    public void newGame() {
        setVisible(false);
        dispose();
        new Game();
    }
}