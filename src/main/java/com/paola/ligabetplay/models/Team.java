package com.paola.ligabetplay.models;

public class Team {
    int id;
    String name;
    int playedMatches;
    int wonMatches;
    int lostMatches;
    int tiedMatches;
    int totalGoals;
    int goalsScored;
    int goalsAgainst;
    int totalPoints;

    public Team () {}

    public Team(int id, String name, int playedMatches, int wonMatches, int lostMatches, int tiedMatches, int totalGoals, int goalsScored, int goalsAgainst, int totalPoints) {
        this.id = id;
        this.name = name;
        this.playedMatches = playedMatches;
        this.wonMatches = wonMatches;
        this.lostMatches = lostMatches;
        this.tiedMatches = tiedMatches;
        this.totalGoals = totalGoals;
        this.goalsScored = goalsScored;
        this.goalsAgainst = goalsAgainst;
        this.totalPoints = totalPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(int playedMatches) {
        this.playedMatches = playedMatches;
    }

    public int getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    public int getTiedMatches() {
        return tiedMatches;
    }

    public void setTiedMatches(int tiedMatches) {
        this.tiedMatches = tiedMatches;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-5d %-5d %-5d %-5d %-5d %-5d %-5d %-5d", id, name, playedMatches, wonMatches, lostMatches, tiedMatches, totalGoals, goalsScored, goalsAgainst, totalPoints);
    }
}
