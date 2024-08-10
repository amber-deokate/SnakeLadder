import java.util.HashSet;
import java.util.Set;

public class RandomUtil {

    private static Set<Integer> unusableNumbers = new HashSet<>();

    public static void clearUsableNumbers() {
        unusableNumbers.clear();
    }

    public static int getRandomFromTo(int from, int to) {
        return (int) ((Math.random() * (++to - from)) + from);
    }

    public static int[] getTwoRandomNumbers(int from, int to) {
        int[] randomNumbers;

        int firstNumber = getRandomFromTo(from, to);
        while (unusableNumbers.contains(firstNumber)) {
            firstNumber = getRandomFromTo(from, to);
        }
        unusableNumbers.add(firstNumber);

        int secondNumber = getRandomFromTo(from, to);
        while (unusableNumbers.contains(secondNumber)) {
            secondNumber = getRandomFromTo(from, to);
        }
        unusableNumbers.add(secondNumber);

        randomNumbers = firstNumber < secondNumber ? new int[] { firstNumber, secondNumber }
                : new int[] { secondNumber, firstNumber };
        return randomNumbers;
    }
}
