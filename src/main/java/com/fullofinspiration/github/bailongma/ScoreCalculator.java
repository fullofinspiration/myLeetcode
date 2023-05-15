package com.fullofinspiration.github.bailongma;

import java.time.LocalDate;

public class ScoreCalculator {
    private long calcScore(int timestamp, int score) {
        long newScore = ((long) score) << 32;
        long _2050 = LocalDate.of(2050, 12, 31).toEpochDay() * 1000;
        return newScore + _2050 - timestamp;
    }
}
