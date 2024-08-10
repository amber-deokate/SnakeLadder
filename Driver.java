import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    private static int numberOfSnakes;
    private static int numberOfLadders;
    private static int numberOfPlayers;

    public static void main(String[] args) throws IOException {

        // take user input
        takeUserInput();

        // initialize the board
        Board board = new Board(100, numberOfSnakes, numberOfLadders, numberOfPlayers);

        // start the game
        board.startGame();
    }

    private static void takeUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // take input for number of players
        System.out.println("Please enter the number of players.");
        numberOfPlayers = 0;
        do {
            String line = reader.readLine();
            try {
                numberOfPlayers = Integer.parseInt(line);
                if (numberOfPlayers <= 0) {
                    System.out.println("Please enter a positive intger.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive intger.");
            }
        } while (numberOfPlayers <= 0);

        // take input for number of snakes
        System.out.println("Please enter the number of snakes.");
        numberOfSnakes = -1;
        do {
            String line = reader.readLine();
            try {
                numberOfSnakes = Integer.parseInt(line);
                if (numberOfSnakes < 0) {
                    System.out.println("Please enter a non negative intger.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a non negative intger.");
            }
        } while (numberOfSnakes < 0);

        // take input for number of ladders
        System.out.println("Please enter the number of ladders.");
        numberOfLadders = -1;
        do {
            String line = reader.readLine();
            try {
                numberOfLadders = Integer.parseInt(line);
                if (numberOfLadders < 0) {
                    System.out.println("Please enter a non negative intger.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a non negative intger.");
            }
        } while (numberOfLadders < 0);
    }

}
