package SnakeLadderGame;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int low;
    int high;
    Random random = new Random();

    public Dice(int diceCount, int low, int high) {
        this.diceCount = diceCount;
        this.low = low;
        this.high = high;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceThrow = 0;
        while (diceThrow < diceCount) {
            totalSum = totalSum + random.nextInt(high - low) + low;
            diceThrow++;
        }
        System.out.println("Dice value: " + totalSum);
        return totalSum;
    }
}
