package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Medic;
import com.paola.ligabetplay.models.Team;

public class MedicController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Medic> medics = new ArrayList<>();

    public ArrayList<Medic> registerMedic(String medicType, int idTeam) {
        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);
        Medic medic = new Medic();
        Boolean exists = true;
        if (medics.isEmpty()) {
            int id = menuController.verifyValue("Ingrese el ID: ");
            medic.setId(id);
        } else {
            do {
                int id = menuController.verifyValue("Ingrese el ID: ");
                for (int i = 0; i <= medics.size() - 1; i++) {
                    Medic t = medics.get(i);
                    int idMedic = t.getId();
                    if (idMedic == id) {
                        System.out.println("***");
                        System.out.println("El ID ya se encuentra registrado");
                        System.out.println("***");
                        exists = true;
                        break;
                    } else if (i == medics.size() - 1) {
                        medic.setId(id);
                        exists = false;
                        break;
                    }
                }
            } while (exists);
        }
        System.out.println("---");
        System.out.println("Ingrese el nombre:");
        System.out.println("---");
        String name = sc.nextLine();
        int age = menuController.verifyValue("Ingrese la edad: ");
        System.out.println("---");
        System.out.println("Ingrese la nacionalidad: ");
        System.out.println("---");
        String nation = sc.nextLine();
        System.out.println("---");
        System.out.println("Ingrese la profesión:");
        System.out.println("---");
        String degree = sc.nextLine();
        int experience = menuController.verifyValue("Ingrese los años de experiencia:");
        medic.setName(name);
        medic.setAge(age);
        medic.setNationality(nation);
        medic.setIdTeam(idTeam);
        medic.setMedicType(medicType);
        medic.setDegree(degree);
        medic.setExperience(experience);
        medics.add(medic);
        System.out.println("###");
        System.out.println("REGISTRADO");
        System.out.println("###");
        return medics;
    }
}
