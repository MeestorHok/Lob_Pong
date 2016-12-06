import exceptions.RoundCompleteException;

class GameManager {
    private static final int STARTING_TIME = 30000; // 30 seconds
    private static final int SCORE_TIME = 5; // Reward for surviving some time
    private static final int SCORE_BONUS = 100; // Reward for special events
    private static final double DIFFICULTY_FACTOR = 1.1; // how quickly to scale difficulty between levels

    private double multiplier;
    private int score;
    private int round;
    private int timeLeft;
    private int lives;

    GameManager() {
        multiplier = 1.0;
        score = 0;
        round = 1;
        timeLeft = STARTING_TIME;
        lives = 3;
    }

    // Move on to the next round
    void nextRound() {
        round++;

        awardBonus();
        resetTimer();
    }

    // Countdown timer
    void countdown() throws RoundCompleteException {
        timeLeft--;
        if (timeLeft == 0) {
            throw new RoundCompleteException();
        }
    }

    // Reset timer
    private void resetTimer() {
        multiplier *= DIFFICULTY_FACTOR;

        timeLeft = (int) Math.round(STARTING_TIME * multiplier);
    }

    // Give the user points for time
    private void awardTimeBonus() {
        score += SCORE_TIME;
    }

    // Give the user bonus points
    private void awardBonus() {
        score += SCORE_BONUS;
    }

    // Check if we have extra lives
    private boolean hasLives() {
        return lives > 0;
    }

    // Decrement lives when player fails
    private void loseLife() {
        lives--;
    }

    // Award extra life to user
    private void gainLife() {
        lives++;
    }

    // Getters
    private int getLives() { return lives; }
    private int getScore() { return score; }
    private int getRound() { return round; }
}
