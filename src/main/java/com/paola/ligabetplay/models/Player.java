package com.paola.ligabetplay.models;

public class Player extends Person {
    int idTeam;
    int shirtNumber;
    String role;
    String dateOfArrival;
    int goalsScored;
    int yellowCards;
    int redCards;

    public Player () {}

    public Player(int id, String name, int age, String nationality, int idTeam, int shirtNumber, String role, String dateOfArrival, int goalsScored, int yellowCards, int redCards) {
        super(id, name, age, nationality);
        this.idTeam = idTeam;
        this.shirtNumber = shirtNumber;
        this.role = role;
        this.dateOfArrival = dateOfArrival;
        this.goalsScored = goalsScored;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}