package com.paola.ligabetplay.models;

public class Tech extends Person {
    int idTeam;

    public Tech(int id, String name, int age, String nationality, int idTeam) {
        super(id, name, age, nationality);
        this.idTeam = idTeam;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }
}