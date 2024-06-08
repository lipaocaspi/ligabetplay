package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Match;
import com.paola.ligabetplay.models.Team;

public class TeamController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> matchs = new ArrayList<>();
    int scoreOne;
    int scoreTwo;

    public ArrayList<Team> registerTeam() {
        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);
        Team team = new Team();
        Boolean exists = false;
        if (teams.isEmpty()) {
            int id = menuController.verifyValue("Ingrese el código del equipo: ");
            System.out.println("Ingrese el nombre del equipo: ");
            String name = sc.nextLine();
            team.setId(id);
            team.setName(name);
            team.setPlayedMatches(0);
            team.setWonMatches(0);
            team.setLostMatches(0);
            team.setTiedMatches(0);
            team.setTotalGoals(0);
            team.setGoalsScored(0);
            team.setGoalsAgainst(0);
            team.setTotalPoints(0);
            teams.add(team);
            System.out.println("---");
            System.out.println("Equipo registrado");
            System.out.println("---");
        } else {
            do {
                int id = menuController.verifyValue("Ingrese el código del equipo: ");
                for (int i = 0; i <= teams.size() - 1; i++) {
                    Team t = teams.get(i);
                    int idTeam = t.getId();
                    if (idTeam == id) {
                        System.out.println("---");
                        System.out.println("El código ya se encuentra registrado");
                        System.out.println("---");
                        exists = true;
                        break;
                    } else if (i == teams.size() - 1) {
                        System.out.println("---");
                        System.out.println("Ingrese el nombre del equipo: ");
                        System.out.println("---");
                        String name = sc.nextLine();
                        team.setId(id);
                        team.setName(name);
                        team.setPlayedMatches(0);
                        team.setWonMatches(0);
                        team.setLostMatches(0);
                        team.setTiedMatches(0);
                        team.setTotalGoals(0);
                        team.setGoalsScored(0);
                        team.setGoalsAgainst(0);
                        team.setTotalPoints(0);
                        teams.add(team);
                        System.out.println("---");
                        System.out.println("Equipo registrado");
                        System.out.println("---");
                        exists = true;
                        break;
                    }
                }
            } while (exists == false);
        }
        return teams;
    }

    public Boolean searchTeam(ArrayList<Team> teams, int idTeam) {
        Boolean result = true;
        for (int i = 0; i <= teams.size() - 1; i++) {
            Team t = teams.get(i);
            int id = t.getId();
            if (idTeam == id) {
                result = false;
                break;
            }
            else if (i == teams.size() - 1) {
                System.out.println("No se encontró equipo registrado con ese código");
            }
        }
		return result;
    }
}
