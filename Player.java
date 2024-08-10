public class Player {

    private String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void play(Board board) {
        int diceOutcome = Dice.rollDice();
        int intitialPosition = position;
        int boardSize = board.getBoardSize();
        System.out.println(name + " rolls " + diceOutcome + ".");
        if (intitialPosition + diceOutcome > boardSize) {
            System.out.println(name + " has has to wait!!");
            System.out.println("");
            return;
        }
        if (intitialPosition + diceOutcome == boardSize) {
            board.setGameOver(true);
            System.out.println(name + " has won the game!!");
            System.out.println("");
            return;
        }
        position = diceOutcome + intitialPosition;
        updateFinalPositionBecauseOfSnakesAndladder(board);
        System.out.println(name + " goes from " + intitialPosition + " to " + position + ".");
        System.out.println("");
    }

    private void updateFinalPositionBecauseOfSnakesAndladder(Board board) {

        for (Snake snake : board.getSnakes()) {
            if (snake.getIntitialPosition() == position) {
                System.out.println("Snake is here!! " + name + " goes from " + snake.getIntitialPosition()
                        + " to " + snake.getFinalPosition() + ".");
                position = snake.getFinalPosition();
                return;
            }
        }
        for (Ladder ladder : board.getLadders()) {
            if (ladder.getIntitialPosition() == position) {
                System.out.println("Ladder is here!! " + name + " goes from " + ladder.getIntitialPosition()
                        + " to " + ladder.getFinalPosition() + ".");
                position = ladder.getFinalPosition();
                return;
            }
        }
    }
}
