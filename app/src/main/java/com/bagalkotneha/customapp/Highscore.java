package com.bagalkotneha.customapp;

public class Highscore {
    private long[] times;

    public Highscore(long[] times){
        this.times = times;
    }

    public long[] getTimes() {
        return times;
    }

    @Override
    public String toString()
    {
        return "Highscore [times=" + times + "]";
    }
}
