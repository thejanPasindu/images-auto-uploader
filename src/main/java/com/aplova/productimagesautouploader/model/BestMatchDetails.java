package com.aplova.productimagesautouploader.model;

public class BestMatchDetails {
    private String string;
    private int score;
    private  int index;

    public BestMatchDetails() {
    }

    public BestMatchDetails(String string, int score, int index) {
        this.string = string;
        this.score = score;
        this.index = index;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "BestMatchDetails{" +
                "string='" + string + '\'' +
                ", score=" + score +
                ", index=" + index +
                '}';
    }
}
