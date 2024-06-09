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
            System.out.println("###");
            System.out.println("EQUIPO REGISTRADO");
            System.out.println("###");
        } else {
            do {
                int id = menuController.verifyValue("Ingrese el código del equipo: ");
                for (int i = 0; i <= teams.size() - 1; i++) {
                    Team t = teams.get(i);
                    int idTeam = t.getId();
                    if (idTeam == id) {
                        System.out.println("***");
                        System.out.println("El código ya se encuentra registrado");
                        System.out.println("***");
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
                        System.out.println("###");
                        System.out.println("EQUIPO REGISTRADO");
                        System.out.println("###");
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
                System.out.println("***");
                System.out.println("No se encontró equipo registrado con ese código");
                System.out.println("***");
            }
        }
		return result;
    }

    public int checkTeam(ArrayList<Team> teams, int teamNumber, String name, Match match) {
        int in = 0;
        for (int i = 0; i <= teams.size() - 1; i++) {
            Team team = teams.get(i);
            String teamName = team.getName();
            if (teamName.equals(name)) {
                if (teamNumber == 1) {
                    match.setTeamOne(name);
                    in = team.getId();
                } else if (match.getTeamOne().equals(name)) {
                    System.out.println("***");
                    System.out.println("Un equipo no puede enfrentarse consigo mismo");
                    System.out.println("***");
                    in = -1;
                } else {
                    match.setTeamTwo(name);
                    in = team.getId();
                }
                break;
            } else if (i == teams.size() - 1) {
                System.out.println("***");
                System.out.println("El equipo no se encuentra registrado");
                System.out.println("***");
                in = -1;
                break;
            }
        }
        return in;
    }
}