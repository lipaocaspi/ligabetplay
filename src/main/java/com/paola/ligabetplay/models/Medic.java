package com.paola.ligabetplay.models;

public class Medic extends Person {
    int idTeam;
    String medicType;
    String degree;
    int experience;

    public Medic () {}

    public Medic(int id, String name, int age, String nationality, int idTeam, String medicType, String degree, int experience) {
        super(id, name, age, nationality);
        this.idTeam = idTeam;
        this.medicType = medicType;
        this.degree = degree;
        this.experience = experience;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getMedicType() {
        return medicType;
    }

    public void setMedicType(String medicType) {
        this.medicType = medicType;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
