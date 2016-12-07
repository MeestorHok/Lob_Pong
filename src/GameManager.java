import exceptions.RoundCompleteException;

import java.awt.*;

class GameManager {
    private static final int STARTING_TIME = 3000; // 30 seconds (time is amplified bc/ animation timer is fast)
    private static final int SCORE_TIME = 5; // Reward for surviving some time
    private static final int SCORE_BONUS = 100; // Reward for special events
    private static final double DIFFICULTY_FACTOR = 1.1; // how quickly to scale difficulty between levels

    private double multiplier;
    private int timeBonusCountdown;
    private int score;
    private int round;
    private int timeLeft;
    private int lives;

    GameManager() {
        multiplier = 1.0;
        timeBonusCountdown = 0;
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

    // Draw the timer
    void drawRound(Graphics g, int canvasWidth) {
        g.drawString("Round: " + round, canvasWidth - 80, 40);
    }

    // Countdown timer
    void countdown() throws RoundCompleteException {
        timeLeft--;
        timeBonusCountdown++;

        // every second
        if (timeBonusCountdown >= 100) {
            awardTimeBonus();
            timeBonusCountdown = 0;
        }

        // If you survive the full time
        if (timeLeft == 0) {
            throw new RoundCompleteException();
        }
    }

    // Reset timer
    private void resetTimer() {
        multiplier *= DIFFICULTY_FACTOR;

        timeLeft = (int) Math.round(STARTING_TIME * multiplier);
    }

    // Draw the timer
    void drawTimer(Graphics g, int canvasWidth) {
        String formattedTime = "" + (timeLeft / 100.0);
        g.drawString("Remaining Time: " + formattedTime, canvasWidth - 180, 20);
    }

    // Give the user points for time
    private void awardTimeBonus() {
        score += SCORE_TIME;
    }

    // Give the user bonus points
    private void awardBonus() {
        score += (int) Math.round(SCORE_BONUS * Math.pow(DIFFICULTY_FACTOR, round - 1)); // Increases after each round
    }

    // Draw the timer
    void drawScore(Graphics g) {
        g.drawString("Score: " + score, 20, 20);
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

    // Draw the dots for lives
    void drawLives(Graphics g) {
        for(int i = 1; i <= lives; i++) {
            g.fillOval(20 * i, 40, 10, 10);
        }
    }
}
