package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Match;
import com.paola.ligabetplay.models.Player;
import com.paola.ligabetplay.models.Team;

public class PlayerController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Match> matchs = new ArrayList<>();

    public ArrayList<Player> registerPlayer(int idTeam) {
        InputController inputController = new InputController();
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        Boolean exists = true;
        if (players.isEmpty()) {
            int id = inputController.verifyValue("Ingrese el ID del jugador: ");
            player.setId(id);
        } else {
            do {
                int id = inputController.verifyValue("Ingrese el ID del jugador: ");
                for (int i = 0; i <= players.size() - 1; i++) {
                    Player p = players.get(i);
                    int idPlayer = p.getId();
                    if (idPlayer == id) {
                        System.out.println("***");
                        System.out.println("El ID ya se encuentra registrado");
                        System.out.println("***");
                        exists = true;
                        break;
                    } else if (i == players.size() - 1) {
                        player.setId(id);
                        exists = false;
                        break;
                    }
                }
            } while (exists);
        }
        System.out.println("---");
        System.out.println("Ingrese el nombre del jugador:");
        System.out.println("---");
        String name = sc.nextLine();
        int age = inputController.verifyValue("Ingrese la edad del jugador: ");
        System.out.println("---");
        System.out.println("Ingrese la nacionalidad del jugador: ");
        System.out.println("---");
        String nation = sc.nextLine();
        if (players.isEmpty()) {
            int shirtNumber = inputController.verifyValue("Ingrese el dorsal: ");
            player.setShirtNumber(shirtNumber);
        } else {
            do {
                int shirtNumber = inputController.verifyValue("Ingrese el dorsal: ");
                for (int i = 0; i <= players.size() - 1; i++) {
                    Player p = players.get(i);
                    int shirtPlayer = p.getShirtNumber();
                    int idT = p.getIdTeam();
                    if (shirtPlayer == shirtNumber && idT == idTeam) {
                        System.out.println("***");
                        System.out.println("El dorsal ya se encuentra registrado");
                        System.out.println("***");
                        exists = true;
                        break;
                    } else if (i == players.size() - 1) {
                        player.setShirtNumber(shirtNumber);
                        exists = false;
                        break;
                    }
                }
            } while (exists);
        }
        System.out.println("---");
        System.out.println("Ingrese la posición del jugador: ");
        System.out.println("---");
        String position = sc.nextLine();
        System.out.println("---");
        System.out.println("Ingrese la fecha de llegada del jugador: ");
        System.out.println("---");
        String arrival = sc.nextLine();
        player.setName(name);
        player.setAge(age);
        player.setNationality(nation);
        player.setIdTeam(idTeam);
        player.setRole(position);
        player.setDateOfArrival(arrival);
        player.setGoalsScored(0);
        player.setYellowCards(0);
        player.setRedCards(0);
        players.add(player);
        System.out.println("###");
        System.out.println("JUGADOR REGISTRADO");
        System.out.println("###");
        return players;
    }

    public Boolean searchPlayer(ArrayList<Player> players, int shirt, int idTeam) {
        Boolean result = true;
        for (int i = 0; i <= players.size() - 1; i++) {
            Player p = players.get(i);
            int id = p.getIdTeam();
            int shirtN = p.getShirtNumber();
            if (idTeam == id && shirt == shirtN) {
                result = false;
                break;
            }
            else if (i == teams.size() - 1) {
                System.out.println("***");
                System.out.println("No se encontró jugador con ese dorsal");
                System.out.println("***");
            }
        }
		return result;
    }

    public int getPlayer(ArrayList<Player> players, int shirt, int idTeam) {
        int in = 0;
        for (int i = 0; i <= players.size() - 1; i++) {
            int idT = players.get(i).getIdTeam();
            int shirtN = players.get(i).getShirtNumber();
            if (idTeam == idT && shirt == shirtN) {
                in = i;
                break;
            }
        }
        return in;
    }

    public void addGoals(ArrayList<Player> players, int iP) {
        players.get(iP).setGoalsScored(players.get(iP).getGoalsScored() + 1);
    }

    public void addYellowCards(ArrayList<Player> players, int iP) {
        players.get(iP).setYellowCards(players.get(iP).getYellowCards() + 1);
    }

    public void addRedCards(ArrayList<Player> players, int iP) {
        players.get(iP).setRedCards(players.get(iP).getRedCards() + 1);
    }

    public void maxScoredGoals(ArrayList<Player> players) {
        String playerName = "";
        int refNumber = 0;
        for (int i = 0; i <= players.size() - 1; i++) {
            int scoredGoals = players.get(i).getGoalsScored();
            if (scoredGoals > refNumber) {
                refNumber = scoredGoals;
                playerName = players.get(i).getName();
            }
        }
        System.out.println("---");
        System.out.println("Jugador con más goles anotados: " + playerName);
        System.out.println("---");
    }

    public void maxRedCards(ArrayList<Player> players) {
        String playerName = "";
        int refNumber = 0;
        for (int i = 0; i <= players.size() - 1; i++) {
            int redCards = players.get(i).getRedCards();
            if (redCards > refNumber) {
                refNumber = redCards;
                playerName = players.get(i).getName();
            }
        }
        System.out.println("---");
        System.out.println("Jugador con más tarjetas rojas: " + playerName);
        System.out.println("---");
    }

    public void maxYellowCards(ArrayList<Player> players) {
        String playerName = "";
        int refNumber = 0;
        for (int i = 0; i <= players.size() - 1; i++) {
            int yellowCards = players.get(i).getYellowCards();
            if (yellowCards > refNumber) {
                refNumber = yellowCards;
                playerName = players.get(i).getName();
            }
        }
        System.out.println("---");
        System.out.println("Jugador con más tarjetas amarillas: " + playerName);
        System.out.println("---");
    }
}
