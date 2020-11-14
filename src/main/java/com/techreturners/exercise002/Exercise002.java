package com.techreturners.exercise002;

public class Exercise002 {

    // The clock shows 'h' hours, 'm' minutes and 's' seconds after midnight.
    // Your task is to make the 'past' function return time past midnight converted to milliseconds.

    public int past(int h, int m, int s) {
        // Your code here!
        int milliseconds = 0;
        milliseconds += h * 3_600_000;
        milliseconds += m * 60_000;
        milliseconds += s * 1_000;

        return milliseconds;
    }
}