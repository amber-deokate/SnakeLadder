public class Dice {

    private static int numberOfDiceRolls;

    public static int getNumberOfDiceRolls() {
        return numberOfDiceRolls;
    }

    public static int rollDice() {
        numberOfDiceRolls++;
        return RandomUtil.getRandomFromTo(1, 6);
    }
}
