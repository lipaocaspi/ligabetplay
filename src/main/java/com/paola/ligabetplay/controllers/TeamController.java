package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.paola.ligabetplay.models.Match;
import com.paola.ligabetplay.models.Player;
import com.paola.ligabetplay.models.Team;

public class TeamController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> matchs = new ArrayList<>();
    int scoreOne;
    int scoreTwo;

    public ArrayList<Team> registerTeam() {
        InputController inputController = new InputController();
        Scanner sc = new Scanner(System.in);
        Team team = new Team();
        Boolean exists = false;
        if (teams.isEmpty()) {
            int id = inputController.verifyValue("Ingrese el código del equipo: ");
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
                int id = inputController.verifyValue("Ingrese el código del equipo: ");
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

    public int checkTeam(ArrayList<Team> teams, ArrayList<Player> players, int teamNumber, String name, Match match) {
        int in = 0;
        int count = 0;
        for (int i = 0; i <= teams.size() - 1; i++) {
            Team team = teams.get(i);
            String teamName = team.getName();
            in = team.getId();
            if (teamName.equals(name)) {
                if (teamNumber == 1) {
                    for (int j = 0; j <= players.size() - 1; j++) {
                        int idT = players.get(j).getIdTeam();
                        if (idT == in) {
                            count = count + 1;
                        }
                    }
                    if (count >= 2) {
                        match.setTeamOne(name);
                    } else {
                        System.out.println("***");
                        System.out.println("No hay suficientes jugadores registrados en el equipo");
                        System.out.println("***");
                        in = -2;
                        break;
                    }
                } else if (match.getTeamOne().equals(name)) {
                    System.out.println("***");
                    System.out.println("Un equipo no puede enfrentarse consigo mismo");
                    System.out.println("***");
                    in = -1;
                    break;
                } else {
                    for (int j = 0; j <= players.size() - 1; j++) {
                        int idT = players.get(j).getIdTeam();
                        if (idT == in) {
                            count = count + 1;
                        }
                    }
                    if (count >= 2) {
                        match.setTeamTwo(name);
                    } else {
                        System.out.println("***");
                        System.out.println("No hay suficientes jugadores registrados en el equipo");
                        System.out.println("***");
                        in = -2;
                        break;
                    }
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

    public void showTable(ArrayList<Team> teams) {
        Comparator<Team> comparator = Comparator.comparing(Team::getTotalPoints).thenComparing(Team::getGoalsScored);
        Collections.sort(teams, comparator.reversed());
        System.out.printf("%-5s %-15s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s%n", "Cod", "Nombre", "PJ", "PG", "PP", "PE", "TG", "GA", "GC", "TP");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i <= teams.size() - 1; i++) {
            System.out.println(teams.get(i));
        }
    }
}