package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Team;
import com.paola.ligabetplay.models.Tech;

public class TechController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Tech> techs = new ArrayList<>();

    public ArrayList<Tech> registerTech(String techType, int idTeam) {
        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);
        Tech tech = new Tech();
        Boolean exists = true;
        if (techs.isEmpty()) {
            int id = menuController.verifyValue("Ingrese el ID: ");
            tech.setId(id);
        } else {
            do {
                int id = menuController.verifyValue("Ingrese el ID: ");
                for (int i = 0; i <= techs.size() - 1; i++) {
                    Tech t = techs.get(i);
                    int idTech = t.getId();
                    if (idTech == id) {
                        System.out.println("***");
                        System.out.println("El ID ya se encuentra registrado");
                        System.out.println("***");
                        exists = true;
                        break;
                    } else if (i == techs.size() - 1) {
                        tech.setId(id);
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
        tech.setName(name);
        tech.setAge(age);
        tech.setNationality(nation);
        tech.setIdTeam(idTeam);
        tech.setTechType(techType);
        techs.add(tech);
        System.out.println("###");
        System.out.println("REGISTRADO");
        System.out.println("###");
        /* for (int i = 0; i <= techs.size() - 1; i++) {
            System.out.println(techs.get(i).getTechType());
            System.out.println(techs.get(i).getIdTeam());
        } */
        return techs;
    }
}
