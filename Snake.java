public class Snake {
    private int intitialPosition;
    private int finalPosition;

    public Snake(int intitialPosition, int finalPosition) {
        this.intitialPosition = intitialPosition;
        this.finalPosition = finalPosition;
    }

    public int getIntitialPosition() {
        return intitialPosition;
    }

    public void setIntitialPosition(int intitialPosition) {
        this.intitialPosition = intitialPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(int finalPosition) {
        this.finalPosition = finalPosition;
    }
}
