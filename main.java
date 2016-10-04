public class main {
    // any Java code will not run with the main method
    public static void main(String[] args) {
        // class main calls for another class, gui
        TicTacToeGui g = new TicTacToeGui();
        // within gui class g is launchFrame,
        // used to launch a graphical user interface
        g.launchFrame();
    }
}