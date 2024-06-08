package com.paola.ligabetplay.models;

public class Tech extends Person {
    int idTeam;
    String techType;

    public Tech () {}

    public Tech(int id, String name, int age, String nationality, int idTeam, String techType) {
        super(id, name, age, nationality);
        this.idTeam = idTeam;
        this.techType = techType;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
    }
}