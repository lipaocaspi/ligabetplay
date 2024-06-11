package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Match;
import com.paola.ligabetplay.models.Player;
import com.paola.ligabetplay.models.Team;

public class MatchController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> matches = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    int scoreOne;
    int scoreTwo;
    int yellowCard;
    int redCard;
    int iE1;
    int iE2;

    public ArrayList<Match> registerMatch(ArrayList<Player> players, ArrayList<Team> teams) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        TeamController teamController = new TeamController();
        PlayerController playerController = new PlayerController();
        if (teams.size() < 2) {
            System.out.println("***");
            System.out.println("No hay suficientes equipos registrados");
            System.out.println("***");
        } else {
            int i1;
            int i2;
            int shirtN;
            int code;
            Boolean notExists;
            Match match = new Match();
            System.out.println("---");
            System.out.println("Ingrese la fecha del partido: ");
            System.out.println("---");
            match.setDate(sc.nextLine());
            do {
                System.out.println("---");
                System.out.println("Ingrese el nombre del equipo local: ");
                System.out.println("---");
                String name = sc.nextLine();
                i1 = teamController.checkTeam(teams, players, 1, name, match);
            } while (i1 == -1);
            if (i1 != -2) {
                for (int i = 0; i <= teams.size() - 1; i++) {
                    int id = teams.get(i).getId();
                    if (id == i1) {
                        iE1 = i;
                        break;
                    }
                }
                do {
                    System.out.println("---");
                    System.out.println("Ingrese el nombre del equipo visitante: ");
                    System.out.println("---");
                    String name = sc.nextLine();
                    i2 = teamController.checkTeam(teams, players, 2, name, match);
                } while (i2 == -1);
                if (i2 != -2) {
                    for (int i = 0; i <= teams.size() - 1; i++) {
                        int id = teams.get(i).getId();
                        if (id == i2) {
                            iE2 = i;
                            break;
                        }
                    }
                    scoreOne = menuController.verifyValue("Ingrese el número de goles del equipo local: ");
                    match.setScoreOne(scoreOne);
                    if (scoreOne != 0) {
                        for (int i = 1; i <= scoreOne; i++) {
                            do {
                                shirtN = menuController.verifyValue("Ingrese el dorsal del jugador que anotó el gol " + i);
                                notExists = playerController.searchPlayer(players, shirtN, i1);
                            } while (notExists);
                            int iP = playerController.getPlayer(players, shirtN, i1);
                            playerController.addGoals(players, iP);
                        }
                    }
                    scoreTwo = menuController.verifyValue("Ingrese el número de goles del equipo visitante: ");
                    match.setScoreTwo(scoreTwo);
                    if (scoreTwo != 0) {
                        for (int i = 1; i <= scoreTwo; i++) {
                            do {
                                shirtN = menuController.verifyValue("Ingrese el dorsal del jugador que anotó el gol " + i + ": ");
                                notExists = playerController.searchPlayer(players, shirtN, i2);
                            } while (notExists);
                            int iP = playerController.getPlayer(players, shirtN, i1);
                            playerController.addGoals(players, iP);
                        }
                    }
                    yellowCard = menuController.verifyValue("Ingrese el número de tarjetas amarillas: ");
                    match.setYellowCard(yellowCard);
                    if (yellowCard != 0) {
                        System.out.println("LOCAL: ");
                        System.out.println("ID: " + teams.get(iE1).getId() + " NOMBRE: " + teams.get(iE1).getName());
                        System.out.println("VISITANTE: ");
                        System.out.println("ID: " + teams.get(iE2).getId() + " NOMBRE: " + teams.get(iE2).getName());
                        do {
                            code = menuController.verifyValue("Ingrese el código del equipo que cometió la falta: ");
                        } while (code != i1 && code != i2);
                        for (int i = 1; i <= yellowCard; i++) {
                            do {
                                shirtN = menuController.verifyValue("Ingrese el dorsal del jugador que cometió la falta: ");
                                notExists = playerController.searchPlayer(players, shirtN, code);
                            } while (notExists);
                            int iP = playerController.getPlayer(players, shirtN, code);
                            playerController.addYellowCards(players, iP);
                        } 
                    }
                    redCard = menuController.verifyValue("Ingrese el número de tarjetas rojas: ");
                    match.setRedCard(redCard);
                    if (redCard != 0) {
                        System.out.println("LOCAL: ");
                        System.out.println("ID: " + teams.get(iE1).getId() + " NOMBRE: " + teams.get(iE1).getName());
                        System.out.println("VISITANTE: ");
                        System.out.println("ID: " + teams.get(iE2).getId() + " NOMBRE: " + teams.get(iE2).getName());
                        do {
                            code = menuController.verifyValue("Ingrese el código del equipo que cometió la falta: ");
                        } while (code != i1 && code != i2);
                        for (int i = 1; i <= redCard; i++) {
                            do {
                                shirtN = menuController.verifyValue("Ingrese el dorsal del jugador que cometió la falta: ");
                                notExists = playerController.searchPlayer(players, shirtN, code);
                            } while (notExists);
                            int iP = playerController.getPlayer(players, shirtN, code);
                            playerController.addRedCards(players, iP);
                        }
                    }
                    matches.add(match);
                    System.out.println("###");
                    System.out.println("PARTIDO REGISTRADO");
                    System.out.println("###");
                    calculatePoints(teams, scoreOne, scoreTwo);
                }
            }
        }
        return matches;
    }

    public void calculatePoints(ArrayList<Team> teams, int scoreOne, int scoreTwo) {
        int difGoals = scoreOne - scoreTwo;
        Team T1 = teams.get(iE1);
        Team T2 = teams.get(iE2);
        if (difGoals == 0) {
            T1.setPlayedMatches(T1.getPlayedMatches() + 1);
            T1.setTiedMatches(T1.getTiedMatches() + 1);
            T1.setTotalGoals(T1.getTotalGoals() + scoreOne);
            T1.setTotalPoints(T1.getTotalPoints() + 1);
            T2.setPlayedMatches(T2.getPlayedMatches() + 1);
            T2.setTiedMatches(T2.getTiedMatches() + 1);
            T2.setTotalGoals(T2.getTotalGoals() + scoreTwo);
            T2.setTotalPoints(T2.getTotalPoints() + 1);
        } else if (difGoals > 0) {
            T1.setPlayedMatches(T1.getPlayedMatches() + 1);
            T1.setWonMatches(T1.getWonMatches() + 1);
            T1.setTotalGoals(T1.getTotalGoals() + scoreOne);
            T1.setGoalsScored(T1.getGoalsScored() + difGoals);
            T1.setTotalPoints(T1.getTotalPoints() + 3);
            T2.setPlayedMatches(T2.getPlayedMatches() + 1);
            T2.setLostMatches(T2.getLostMatches() + 1);
            T2.setTotalGoals(T2.getTotalGoals() + scoreTwo);
            T2.setGoalsAgainst(T2.getGoalsAgainst() + difGoals);
        } else {
            T2.setPlayedMatches(T2.getPlayedMatches() + 1);
            T2.setWonMatches(T2.getWonMatches() + 1);
            T2.setTotalGoals(T2.getTotalGoals() + scoreTwo);
            T2.setGoalsScored(T2.getGoalsScored() + (-1)*difGoals);
            T2.setTotalPoints(T2.getTotalPoints() + 3);
            T1.setPlayedMatches(T1.getPlayedMatches() + 1);
            T1.setLostMatches(T1.getLostMatches() + 1);
            T1.setTotalGoals(T1.getTotalGoals() + scoreOne);
            T1.setGoalsAgainst(T1.getGoalsAgainst() + (-1)*difGoals);
        }
    }
}