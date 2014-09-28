package pl.zgora.jug.bowlinggame;

public class Game {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll ++] = pins;
    }

    public int countScore() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(firstInFrame)) {
                score += 10 + twoNextBallsForStrike(firstInFrame);
                firstInFrame ++;
            } else if (isSpare(firstInFrame)) {
                score += 10 + nextBallForSpare(firstInFrame);
                firstInFrame += 2;
            } else {
                score += twoNextBalls(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private int nextBallForSpare(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int twoNextBallsForStrike(int firstInFrame) {
        return twoNextBalls(firstInFrame + 1);
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    private int twoNextBalls(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private boolean isSpare(int firstInFrame) {
        return twoNextBalls(firstInFrame) == 10;
    }
}
