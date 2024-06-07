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

    public ArrayList<Player> registerPlayer(ArrayList<Player> players, int idTeam) {
        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        Boolean exists = true;
        if (players.isEmpty()) {
            int id = menuController.verifyValue("Ingrese el ID del jugador: ");
            player.setId(id);
        } else {
            do {
                int id = menuController.verifyValue("Ingrese el ID del jugador: ");
                for (int i = 0; i <= players.size() - 1; i++) {
                    Player p = players.get(i);
                    int idPlayer = p.getId();
                    if (idPlayer == id) {
                        System.out.println("---");
                        System.out.println("El ID ya se encuentra registrado");
                        System.out.println("---");
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
        System.out.println("Ingrese el nombre del jugador :");
        String name = sc.nextLine();
        int age = menuController.verifyValue("Ingrese la edad del jugador : ");
        System.out.println("Ingrese la nacionalidad del jugador: ");
        String nation = sc.nextLine();
        if (players.isEmpty()) {
            int shirtNumber = menuController.verifyValue("Ingrese el dorsal: ");
            player.setShirtNumber(shirtNumber);
        } else {
            do {
                int shirtNumber = menuController.verifyValue("Ingrese el dorsal: ");
                for (int i = 0; i <= players.size() - 1; i++) {
                    Player p = players.get(i);
                    int shirtPlayer = p.getShirtNumber();
                    if (shirtPlayer == shirtNumber) {
                        System.out.println("---");
                        System.out.println("El dorsal ya se encuentra registrado");
                        System.out.println("---");
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
        System.out.println("Ingrese la posición del jugador: ");
        String position = sc.nextLine();
        System.out.println("Ingrese la fecha de llegada del jugador: ");
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
        /* for (int i = 0; i <= players.size() - 1; i++) {
            System.out.println(players.get(i).getShirtNumber());
            System.out.println(players.get(i).getIdTeam());
        } */
        return players;
    }
}