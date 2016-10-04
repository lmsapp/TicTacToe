import javax.swing.*;
import java.awt.*;

public class TicTacToeGui {
    // declaration of variables below

    // a frame is a window with minimize, restore, and close buttons
    private JFrame f;
    // a panel is like a mini-frame used for layout
    private JPanel p1, p2;
    // buttons are for clicking! :)
    // one has [] beside the name, making it an array, or a group of buttons
    private JButton newB, quitB, b[];
    // boolean values can either be true or false
    // isXturn determines player's turn (X for true, O for false)
    // isGameFinished determines whether the game is over
    // isAITurn is used for playing against the computer
    private boolean isXturn, isGameFinished, isAITurn;
    // int have integer values
    private int numberOfBoxesLeft, playerMode;
    // myAction is another class which defines the behavior
    // of the buttons when clicked
    private myAction action;

    // instantiation of the variables declared above
    public TicTacToeGui() {
        // defines the frame's title bar name
        f = new JFrame("Tic-Tac-Toe");

        p1 = new JPanel();
        p2 = new JPanel();

        // defines the names of the buttons
        newB = new JButton("New");
        quitB = new JButton("Quit");

        // instantiates 10 buttons within the array b[]
        b = new JButton[10];
        for (int i = 0; i < 10; i++) {
            // these buttons will be marked as X or O during play
            // hence, their names are left blank using ""
            b[i] = new JButton("");
        }

        // by default, X is first to play
        isXturn = true;
        isGameFinished = false;
        numberOfBoxesLeft = 9;
    }

    public void launchFrame() {

        // instantiate the actions for the buttons, etc.
        action = new myAction(this);

        // layout, defining how the GUI should appear
        f.setLayout(new BorderLayout());
        f.add(p1, BorderLayout.CENTER);
        f.add(p2, BorderLayout.SOUTH);

        // defining 3 row, 3 column layout of buttons
        p1.setLayout(new GridLayout(3, 3));
        for (int i = 1; i < 10; i++) {
            p1.add(b[i]);
            // adding action to the buttons
            b[i].addActionListener(action);
            // buttons are disabled first, will need to select game mode
            b[i].setEnabled(false);
        }

        // second panel contains New game, Quit game, and game status
        p2.setLayout(new FlowLayout());
        p2.add(newB);
        p2.add(b[0]);
        p2.add(quitB);

        // b[0] is an unclickable button
        // that merely shows whose turn it is
        b[0].setText("X Turn");
        b[0].setEnabled(false);

        // size of the frame window
        f.setSize(280, 350);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding action to new and quit buttons
        newB.addActionListener(action);
        quitB.addActionListener(action);
    }

    // the following are methods to get values of the variables above
    // when using them outside this class
    // some methods are also setters, which replaces values of variables
    // that must be done outside this class
    public JButton getButton(int i) {
        return b[i];
    }

    public JButton[] getButtonA() {
        return b;
    }

    public boolean getXTurn() {
        return isXturn;
    }

    public void setXTurn(boolean i) {
        isXturn = i;
    }

    public boolean getComplete() {
        return isGameFinished;
    }

    public void setComplete(boolean i) {
        isGameFinished = i;
    }

    public int getLeftBoxes() {
        return numberOfBoxesLeft;
    }

    public void setLeftBoxes(int i) {
        numberOfBoxesLeft = i;
    }

    public void reduceLeftBoxes() {
        numberOfBoxesLeft--;
    }

    public int getPlayerMode() {
        return playerMode;
    }

    public void setPlayerMode(int i) {
        playerMode = i;
    }

    public boolean getIsAITurn() {
        return isAITurn;
    }

    public void setIsAITurn(boolean turn) {
        isAITurn = turn;
    }
}






