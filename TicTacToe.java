import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe {

    //Used to see whose turn and what symbol they use
   private static int turnCounter = 0;
    private static final JLabel turnAnnouncement = new JLabel("Player One's (X) turn", JLabel.CENTER);


    private static int playerOneWins = 0;
    private static int playerTwoWins = 0;

    //Stores placement of Xs and Os
    private static int[][] xArray = new int[3][3];
    private static int[][] oArray = new int[3][3];

   private static int playerNumWinner = 0;

   private static final JLabel playerScores = new JLabel("Player One Wins: " + playerOneWins + " v Player Two Wins: " + playerTwoWins, JLabel.CENTER);


    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        //create object to use gui method
        ticTacToe.createGUI();
    }

    //Create GUI method
    public void createGUI()
    {
        //Create frame
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(400,600);
        gameFrame.setTitle("Tic Tac Toe");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setBackground(Color.RED);
        gameFrame.getContentPane().setBackground(new Color(255,127,127));


        //Create panel to put scoreboard and turn announcement labels on
        JPanel gameInfoPanel = new JPanel();
        gameInfoPanel.setSize(400,50);
        gameInfoPanel.setBackground(Color.GRAY);

        //Designs for labels
        turnAnnouncement.setForeground(Color.WHITE);
        turnAnnouncement.setFont(new Font("Verdana", Font.BOLD, 15));
        playerScores.setForeground(Color.WHITE);
        playerScores.setFont(new Font("Verdana", Font.BOLD, 10));

        //Set layout for info Panel

        GridBagLayout layout = new GridBagLayout();
        gameInfoPanel.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;

        gameInfoPanel.add(turnAnnouncement,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        gameInfoPanel.add(playerScores,gbc);


        //Create panel to add button components to
        JPanel gameBoardPanel = new JPanel();
        gameBoardPanel.setSize(300,500);

        //Use grid layout for gameboardpanel

        gameBoardPanel.setLayout(layout);

        //Create 9 buttons and put in on the panel 3X3

        //Button 1

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 5;
        gbc.ipady = 40;

        JButton button1 = new JButton("");
        gameBoardPanel.add(button1,gbc);

        //Button 2
        gbc.gridx = 1;
        gbc.gridy = 0;
        JButton button2 = new JButton("");
        gameBoardPanel.add(button2,gbc);

        //Button 3
        gbc.gridx = 2;
        gbc.gridy = 0;
        JButton button3 = new JButton("");
        gameBoardPanel.add(button3,gbc);

        //Button 4
        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton button4 = new JButton("");
        gameBoardPanel.add(button4,gbc);

        //Button 5
        gbc.gridx = 1;
        gbc.gridy = 1;
        JButton button5 = new JButton("");
        gameBoardPanel.add(button5,gbc);

        //Button 6
        gbc.gridx = 2;
        gbc.gridy = 1;
        JButton button6 = new JButton("");
        gameBoardPanel.add(button6,gbc);

        //Button 7
        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton button7 = new JButton("");
        gameBoardPanel.add(button7,gbc);

        //Button 8
        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton button8 = new JButton("");
        gameBoardPanel.add(button8,gbc);

        //Button 9
        gbc.gridx = 2;
        gbc.gridy = 2;
        JButton button9 = new JButton("");
        gameBoardPanel.add(button9,gbc);

        //Restart Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        JButton restart = new JButton("RESTART");
        restart.setFont(new Font("Verdana", Font.BOLD, 15));
        restart.setForeground(Color.GRAY);
        gameBoardPanel.add(restart,gbc);

        //Set Action commands for button
        button1.setActionCommand("button1pressed");
        button2.setActionCommand("button2pressed");
        button3.setActionCommand("button3pressed");
        button4.setActionCommand("button4pressed");
        button5.setActionCommand("button5pressed");
        button6.setActionCommand("button6pressed");
        button7.setActionCommand("button7pressed");
        button8.setActionCommand("button8pressed");
        button9.setActionCommand("button9pressed");
        restart.setActionCommand("restartpressed");

        //Cannot press restart unless game is finished
        restart.setEnabled(false);



        //Create Listener for Buttons when they are clicked on

        class ButtonClickListener implements ActionListener {
            @Override

            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                    //Latter part is used to ensured that the button text can only be changed once
                    if (command.equals("button1pressed") && button1.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button1.setText("X");
                            button1.setFont(new Font("Kanit", Font.BOLD, 16));
                            button1.setForeground(new Color(255,127,127));
                            xArray[0][0] = 1;
                        } else {
                            button1.setText("0");
                            button1.setFont(new Font("Kanit", Font.BOLD, 16));
                            button1.setForeground(Color.GRAY);
                            oArray[0][0] = 1;
                        }

                        turnCounter++;


                    } else if (command.equals("button2pressed") && button2.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button2.setText("X");
                            button2.setFont(new Font("Kanit", Font.BOLD, 16));
                            button2.setForeground(new Color(255,127,127));
                            xArray[0][1] = 1;
                        } else {
                            button2.setText("0");
                            button2.setFont(new Font("Kanit", Font.BOLD, 16));
                            button2.setForeground(Color.GRAY);
                            oArray[0][1] = 1;
                        }

                        turnCounter++;


                    } else if (command.equals("button3pressed") && button3.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button3.setText("X");
                            button3.setFont(new Font("Kanit", Font.BOLD, 16));
                            button3.setForeground(new Color(255,127,127));
                            xArray[0][2] = 1;
                        } else {
                            button3.setText("0");
                            button3.setFont(new Font("Kanit", Font.BOLD, 16));
                            button3.setForeground(Color.GRAY);
                            oArray[0][2] = 1;
                        }

                        turnCounter++;


                    } else if (command.equals("button4pressed") && button4.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button4.setText("X");
                            button4.setFont(new Font("Kanit", Font.BOLD, 16));
                            button4.setForeground(new Color(255,127,127));
                            xArray[1][0] = 1;
                        } else {
                            button4.setText("0");
                            button4.setFont(new Font("Kanit", Font.BOLD, 16));
                            button4.setForeground(Color.GRAY);
                            oArray[1][0] = 1;
                        }

                        turnCounter++;


                    } else if (command.equals("button5pressed") && button5.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button5.setText("X");
                            button5.setFont(new Font("Kanit", Font.BOLD, 16));
                            button5.setForeground(new Color(255,127,127));
                            xArray[1][1] = 1;
                        } else {
                            button5.setText("0");
                            button5.setFont(new Font("Kanit", Font.BOLD, 16));
                            button5.setForeground(Color.GRAY);
                            oArray[1][1] = 1;
                        }

                        turnCounter++;


                    } else if (command.equals("button6pressed") && button6.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button6.setText("X");
                            button6.setFont(new Font("Kanit", Font.BOLD, 16));
                            button6.setForeground(new Color(255,127,127));
                            xArray[1][2] = 1;
                        } else {
                            button6.setText("0");
                            button6.setFont(new Font("Kanit", Font.BOLD, 16));
                            button6.setForeground(Color.GRAY);
                            oArray[1][2] = 1;
                        }

                        turnCounter++;

                    } else if (command.equals("button7pressed") && button7.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button7.setText("X");
                            button7.setFont(new Font("Kanit", Font.BOLD, 16));
                            button7.setForeground(new Color(255,127,127));
                            xArray[2][0] = 1;
                        } else {
                            button7.setText("0");
                            button7.setFont(new Font("Kanit", Font.BOLD, 16));
                            button7.setForeground(Color.GRAY);
                            oArray[2][0] = 1;
                        }

                        turnCounter++;


                    } else if (command.equals("button8pressed") && button8.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button8.setText("X");
                            button8.setFont(new Font("Kanit", Font.BOLD, 16));
                            button8.setForeground(new Color(255,127,127));
                            xArray[2][1] = 1;
                        } else {
                            button8.setText("0");
                            button8.setFont(new Font("Kanit", Font.BOLD, 16));
                            button8.setForeground(Color.GRAY);
                            oArray[2][1] = 1;
                        }

                        turnCounter++;

                    } else if (command.equals("button9pressed") && button9.getText().equals("")) {
                        //Sees whether its player 1(X) or 2(O)
                        if (turnCounter % 2 == 0) {
                            button9.setText("X");
                            button9.setFont(new Font("Kanit", Font.BOLD, 16));
                            button9.setForeground(new Color(255,127,127));
                            xArray[2][2] = 1;
                        } else {
                            button9.setText("0");
                            button9.setFont(new Font("Kanit", Font.BOLD, 16));
                            button9.setForeground(Color.GRAY);
                            oArray[2][2] = 1;
                        }

                        turnCounter++;

                    }
                    else if (command.equals("restartpressed")){
                        //Restart entire game and clear out winner
                        turnCounter =0;
                        playerNumWinner = 0;
                        xArray = new int[3][3];
                        oArray = new int[3][3];


                        //Turn back on all the buttons
                        button1.setEnabled(true);
                        button2.setEnabled(true);
                        button3.setEnabled(true);
                        button4.setEnabled(true);
                        button5.setEnabled(true);
                        button6.setEnabled(true);
                        button7.setEnabled(true);
                        button8.setEnabled(true);
                        button9.setEnabled(true);

                        //Clears board
                        button1.setText("");
                        button2.setText("");
                        button3.setText("");
                        button4.setText("");
                        button5.setText("");
                        button6.setText("");
                        button7.setText("");
                        button8.setText("");
                        button9.setText("");

                        restart.setEnabled(false);

                    }


                    //After a player goes, looks to see if they won and stops game if it there is one
                   if (checkWinner() == 1){
                       //JLabel prints out that player one is the winner
                       turnAnnouncement.setText("Player One Won!");

                       //Add to player ones total wins and update score board
                       playerOneWins++;
                       playerScores.setText("Player One Wins: " + playerOneWins + " v Player Two Wins: " + playerTwoWins);

                       //Turns off all buttons except restart
                       button1.setEnabled(false);
                       button2.setEnabled(false);
                       button3.setEnabled(false);
                       button4.setEnabled(false);
                       button5.setEnabled(false);
                       button6.setEnabled(false);
                       button7.setEnabled(false);
                       button8.setEnabled(false);
                       button9.setEnabled(false);
                       restart.setEnabled(true);

                   }
                   else if (checkWinner() == 2){
                       //JLabel prints out that player two is the winner
                       turnAnnouncement.setText("Player Two Won!");

                       //Add to player two total wins
                       playerTwoWins++;
                       playerScores.setText("Player One Wins: " + playerOneWins + " v Player Two Wins: " + playerTwoWins);

                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                    restart.setEnabled(true);
                }
                   else if (checkWinner() == 3){
                       //JLabel prints out that there is a tie
                       turnAnnouncement.setText("Player Tie!");
                       button1.setEnabled(false);
                       button2.setEnabled(false);
                       button3.setEnabled(false);
                       button4.setEnabled(false);
                       button5.setEnabled(false);
                       button6.setEnabled(false);
                       button7.setEnabled(false);
                       button8.setEnabled(false);
                       button9.setEnabled(false);
                       restart.setEnabled(true);
                   }


                //Announces which player's turn it is

                if (turnCounter % 2 == 0 && checkWinner() != 1 && checkWinner() != 2 && checkWinner() != 3 ){
                    turnAnnouncement.setText("Player One's (X) turn");
                }
                else if (turnCounter % 2 != 0 && checkWinner() != 1 && checkWinner() != 2 && checkWinner() != 3)
                {
                    turnAnnouncement.setText("Player Two's (0) turn");
                }






            }
        }

        //Use add actionListener to instantiate listener object
        button1.addActionListener(new ButtonClickListener());
        button2.addActionListener(new ButtonClickListener());
        button3.addActionListener(new ButtonClickListener());
        button4.addActionListener(new ButtonClickListener());
        button5.addActionListener(new ButtonClickListener());
        button6.addActionListener(new ButtonClickListener());
        button7.addActionListener(new ButtonClickListener());
        button8.addActionListener(new ButtonClickListener());
        button9.addActionListener(new ButtonClickListener());
        restart.addActionListener(new ButtonClickListener());

        //Add Windows Adapter to handle listening to user interaction
        gameFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });



        //Set a layout for the JFrame to organize the panels
       GridBagLayout layout2 = new GridBagLayout();
       gameFrame.setLayout(layout2);

       GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;

        gbc2.gridx = 0;
        gbc2.gridy = 0;


        //Add panels to frame
        gameFrame.getContentPane().add(gameInfoPanel, gbc2);

        gbc2.fill = GridBagConstraints.HORIZONTAL;

        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gameFrame.getContentPane().add(gameBoardPanel,gbc2);

        //Make frame visible
        gameFrame.setVisible(true);



    }


    public static int checkWinner(){

        //Decides winner by looking at what array indexes are filled

        //Check Horizontal buttons X for winners
        if (xArray[0][0] == 1 && xArray[0][1] == 1 && xArray[0][2] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        } else if (xArray[1][0] == 1 && xArray[1][1] == 1 && xArray[1][2] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        } else if (xArray[2][0] == 1 && xArray[2][1] == 1 && xArray[2][2] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        }

        //Check Horizontal buttons Os for winners
        if (oArray[0][0] == 1 && oArray[0][1] == 1 && oArray[0][2] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        } else if (oArray[1][0] == 1 && oArray[1][1] == 1 && oArray[1][2] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        } else if (oArray[2][0] == 1 && oArray[2][1] == 1 && oArray[2][2] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        }

        //Check Vertical buttons Xs for winner
        if (xArray[0][0] == 1 && xArray[1][0] == 1 && xArray[2][0] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        } else if (xArray[0][1] == 1 && xArray[1][1] == 1 && xArray[2][1] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        } else if (xArray[0][2] == 1 && xArray[1][2] == 1 && xArray[2][2] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        }

        //Check Vertical buttons Os for winner
        if (oArray[0][0] == 1 && oArray[1][0] == 1 && oArray[2][0] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        } else if (oArray[0][1] == 1 && oArray[1][1] == 1 && oArray[2][1] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        } else if (oArray[0][2] == 1 && oArray[1][2] == 1 && oArray[2][2] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        }

        //Check Diagonal Winner for Xs
        if (xArray[0][0] == 1 && xArray[1][1] == 1 && xArray[2][2] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        } else if (xArray[0][2] == 1 && xArray[1][1] == 1 && xArray[2][0] == 1) {
            playerNumWinner = 1; //1 for player 1, 2 for player 2;
        }


        //Check Diagonal Winner for Os
        if (oArray[0][0] == 1 && oArray[1][1] == 1 && oArray[2][2] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        } else if (oArray[0][2] == 1 && oArray[1][1] == 1 && oArray[2][0] == 1) {
            playerNumWinner = 2; //1 for player 1, 2 for player 2;
        }


        //Check for tie
        if (playerNumWinner == 0 && turnCounter == 9 ){
            playerNumWinner = 3;
        }
        return playerNumWinner;
    }
}
