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
                i1 = teamController.checkTeam(teams, 1, name, match);
            } while (i1 == -1);
            do {
                System.out.println("---");
                System.out.println("Ingrese el nombre del equipo visitante: ");
                System.out.println("---");
                String name = sc.nextLine();
                i2 = teamController.checkTeam(teams, 2, name, match);
            } while (i2 == -1);
            scoreOne = menuController.verifyValue("Ingrese el número de goles del equipo local: ");
            match.setScoreOne(scoreOne);
            if (scoreOne != 0) {
                for (int i = 1; i <= scoreOne; i++) {
                    do {
                        int shirtN = menuController.verifyValue("Ingrese el dorsal del jugador que anotó el gol " + i);
                        notExists = playerController.searchPlayer(players, shirtN, i1);
                    } while (notExists);
                    // FUNCION QUE ACTUALIZA LOS GOLES DEL JUGADOR
                }
            }
            scoreTwo = menuController.verifyValue("Ingrese el número de goles del equipo visitante: ");
            match.setScoreTwo(scoreTwo);
            if (scoreTwo != 0) {
                for (int i = 1; i <= scoreTwo; i++) {
                    do {
                        int shirtN = menuController.verifyValue("Ingrese el dorsal del jugador que anotó el gol " + i);
                        notExists = playerController.searchPlayer(players, shirtN, i2);
                    } while (notExists);
                    // FUNCION QUE ACTUALIZA LOS GOLES DEL JUGADOR
                }
            }
            yellowCard = menuController.verifyValue("Ingrese el número de tarjetas amarillas: ");
            match.setYellowCard(yellowCard);
            redCard = menuController.verifyValue("Ingrese el número de tarjetas rojas: ");
            match.setRedCard(redCard);
            matches.add(match);
            /* System.out.println(match.getTeamOne());
            System.out.println(match.getTeamTwo());
            System.out.println(match.getScoreOne());
            System.out.println(match.getScoreTwo());
            System.out.println(match.getYellowCard());
            System.out.println(match.getRedCard()); */
            System.out.println("###");
            System.out.println("PARTIDO REGISTRADO");
            System.out.println("###");
            // calcularPuntos(i1, i2);
        }
        return matches;
    }
}