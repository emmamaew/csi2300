import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private String[][] board = new String[5][5]; //initializing a 5x5 board with 2D array
    private String currentPlayer = "X";
    private Text statusText = new Text("Player X's turn");

	@Override
	public void start(Stage primaryStage) {
        initializeBoard();
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        grid.setStyle("-fx-background-color: papayawhip;"); //setting the background to be papayawhip

        Button[][] buttons = new Button[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setMinSize(50, 50);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].setOnAction(_ -> handleButtonClick(finalI, finalJ, buttons));
                grid.add(buttons[i][j], j, i);
            }
        }

        grid.add(statusText, 0, 5, 5, 1);
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setTitle("5x5 Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

    // initializing the tictactoe board with empty strings
    private void initializeBoard(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = "";
            }
        }
    }

    private void handleButtonClick(int i, int j, Button[][] buttons) {
        //see if the cell is already used
        if (!board[i][j].equals("")) {
            return; // Cell already used, do nothing
        }
        board[i][j] = currentPlayer; //set the cell to the current player
        String symbol;
        if (currentPlayer.equals("X")) {
            symbol = ";)";
        } else {
            symbol = "♡";
        } //custom symbols for X and O
        buttons[i][j].setText(symbol);
        buttons[i][j].setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
        if (currentPlayer.equals("X")){
            buttons[i][j].setStyle("-fx-background-color: powderblue;"); //;) will be powderblue
        } else {
            buttons[i][j].setStyle("-fx-background-color: plum;"); //♡ will be plum
        }

        //check for a win
        if (checkWin()) {
            statusText.setText("Player " + currentPlayer + " wins!");
            statusText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
            if (currentPlayer.equals("X")) {
                statusText.setFill(javafx.scene.paint.Color.LIGHTBLUE); //winner will be announced in the color of the player that won
            } else {
                statusText.setFill(javafx.scene.paint.Color.PLUM);
            }
            return;
        }

        //switch player turn
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
        statusText.setText("Player " + currentPlayer + "'s turn");
    }

    private boolean checkWin() {
        //Check rows and columns for a win
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j].equals("")) {
                    continue; //skip empty cells
                }
                String player = board[i][j];

                if (i <= 0 && checkLine(i, j, 1, 0, player)) {
                    return true; // Check row
                }
                if (j <= 0 && checkLine(i, j, 0, 1, player)) {
                    return true; // Check column
                }
                if (i <= 0 && j <= 0 && checkLine(i, j, 1, 1, player)) {
                    return true; // Check diagonal
                }
                if (i <= 0 && j >= 4 && checkLine(i, j, 1, -1, player)) {
                    return true; // Check anti-diagonal
                }
            }
        }
        return false; // No win found
    }

    private boolean checkLine(int row, int col, int rowDir, int colDir, String player) {
        for (int k = 0; k < 5; k++) {
            int r = row + k * rowDir;
            int c = col + k * colDir;
            if (r < 0 || r >= 5 || c < 0 || c >= 5 || !board[r][c].equals(player)) {
                return false; // Out of bounds or not the same player
            }
        }
        return true; // All cells in line match the player
    }

    public static void main(String[] args) {
        launch(args);
    }
}