import java.util.ArrayList;
import java.util.List;

public class Board {
    private int boardSize;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;
    private boolean isGameOver;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders, int numberOfPlayers) {
        isGameOver = false;
        this.boardSize = boardSize;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        players = new ArrayList<>();
        initializeBoard(numberOfSnakes, numberOfLadders, numberOfPlayers);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    private void initializeBoard(int numberOfSnakes, int numberOfLadders, int numberOfPlayers) {
        RandomUtil.clearUsableNumbers();
        initializeSnakes(numberOfSnakes);
        initializeLadders(numberOfLadders);
        initializePlayers(numberOfPlayers);
    }

    private void initializeSnakes(int numberOfSnakes) {
        while (numberOfSnakes-- > 0) {
            int[] randomNumbers = RandomUtil.getTwoRandomNumbers(1, boardSize - 1);
            snakes.add(new Snake(randomNumbers[1], randomNumbers[0]));
        }
    }

    private void initializeLadders(int numberOfLadders) {
        while (numberOfLadders-- > 0) {
            int[] randomNumbers = RandomUtil.getTwoRandomNumbers(1, boardSize - 1);
            ladders.add(new Ladder(randomNumbers[0], randomNumbers[1]));
        }
    }

    private void initializePlayers(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player" + i, 0));
        }
    }

    public void startGame() {
        System.out.println("The game starts.");
        System.out.println("");
        int i = 0;
        int numberOfPlayers = players.size();
        while (!isGameOver) {
            players.get(i).play(this);
            i = (i + 1) % numberOfPlayers;
        }
        System.out.println("Number of times the dice was rolled: " + Dice.getNumberOfDiceRolls());
        System.out.println("");
    }

}