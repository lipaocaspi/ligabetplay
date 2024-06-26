package com.paola.ligabetplay.controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.paola.ligabetplay.menus.Menu;
import com.paola.ligabetplay.models.Match;
import com.paola.ligabetplay.models.Medic;
import com.paola.ligabetplay.models.Player;
import com.paola.ligabetplay.models.Team;
import com.paola.ligabetplay.models.Tech;

public class MenuController {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> matches = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Tech> techs = new ArrayList<>();
    ArrayList<Medic> medics = new ArrayList<>();
   
    public void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        InputController inputController = new InputController();
        TeamController teamController = new TeamController();
        PlayerController playerController = new PlayerController();
        MatchController matchController = new MatchController();
        int choice;
        do {
            System.out.println(Menu.getTitle());
            System.out.println(Menu.getMainMenuList());
            choice = inputController.verifyValue("Ingrese la opción: ");
            switch (choice) {
                case 1:
                    teams = teamController.registerTeam();
                    break;
                case 2:
                    int idTeam;
                    Boolean notExists = true;
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        do {
                            idTeam = inputController.verifyValue("Ingrese el código del equipo al que pertenece el jugador: ");
                            notExists = teamController.searchTeam(teams, idTeam);
                        } while (notExists);
                        players = playerController.registerPlayer(idTeam);
                    }
                    break;
                case 3:
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        showCoachingStaffMenu();
                    }
                    break;
                case 4:
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        showMedicalStaffMenu();
                    }
                    break;
                case 5:
                    matches = matchController.registerMatch(players, teams);
                    break;
                case 6:
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        showReportsMenu(teams, matches);
                    }
                    break;
                case 7:
                    System.out.println("****************************");
                    System.out.println("GRACIAS POR USAR EL SERVICIO");
                    System.out.println("****************************");
                    break;
                default:
                    System.out.println("***");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("***");
                    break;
            }
        } while (choice != 7);
    }

    public void showCoachingStaffMenu() {
        Scanner sc = new Scanner(System.in);
        InputController inputController = new InputController();
        TeamController teamController = new TeamController();
        TechController techController = new TechController();
        int choice;
        int idTeam;
        Boolean notExists;
        do {
            System.out.println(Menu.getCoachingStaffMenuList());
            choice = inputController.verifyValue("Ingrese la opción de registro: ");
            switch (choice) {
                case 1:
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        do {
                            idTeam = inputController.verifyValue("Ingrese el código del equipo al que pertenece: ");
                            notExists = teamController.searchTeam(teams, idTeam);
                        } while (notExists);
                        if (techs.isEmpty()) {
                            techs = techController.registerTech("Técnico", idTeam);
                        } else {
                            for (int i = 0; i <= techs.size() - 1; i++) {
                                int id = techs.get(i).getIdTeam();
                                String type = techs.get(i).getTechType();
                                if (type.equals("Técnico") && id == idTeam) {
                                    System.out.println("***");
                                    System.out.println("Ya hay un técnico registrado en este equipo");
                                    System.out.println("***");
                                    break;
                                } else {
                                    techs = techController.registerTech("Técnico", idTeam);
                                }
                            }
                        }
                    }
                break;
                case 2:
                    notExists = true;
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        do {
                            idTeam = inputController.verifyValue("Ingrese el código del equipo al que pertenece: ");
                            notExists = teamController.searchTeam(teams, idTeam);
                        } while (notExists);
                        techs = techController.registerTech("Asistente Técnico", idTeam);
                    }
                    break;
                case 3:
                    notExists = true;
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        do {
                            idTeam = inputController.verifyValue("Ingrese el código del equipo al que pertenece: ");
                            notExists = teamController.searchTeam(teams, idTeam);
                        } while (notExists);
                        techs = techController.registerTech("Preparador Físico", idTeam);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("***");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("***");
                    break;
            }
        } while (choice != 4);
    }

    public void showMedicalStaffMenu() {
        Scanner sc = new Scanner(System.in);
        InputController inputController = new InputController();
        TeamController teamController = new TeamController();
        MedicController medicController = new MedicController();
        int choice;
        int idTeam;
        Boolean notExists;
        do {
            System.out.println(Menu.getMedicalStaffMenuList());
            choice = inputController.verifyValue("Ingrese la opción de registro: ");
            switch (choice) {
                case 1:
                    notExists = true;
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        do {
                            idTeam = inputController.verifyValue("Ingrese el código del equipo al que pertenece: ");
                            notExists = teamController.searchTeam(teams, idTeam);
                        } while (notExists);
                        medics = medicController.registerMedic("Fisoterapeuta", idTeam);
                    }
                    break;
                case 2:
                    notExists = true;
                    if (teams.isEmpty()) {
                        System.out.println("***");
                        System.out.println("No existen equipos registrados");
                        System.out.println("***");
                    } else {
                        do {
                            idTeam = inputController.verifyValue("Ingrese el código del equipo al que pertenece: ");
                            notExists = teamController.searchTeam(teams, idTeam);
                        } while (notExists);
                        medics = medicController.registerMedic("Médico", idTeam);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("***");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("***");
                    break;
            }
        } while (choice != 3);
    }

    public void showReportsMenu(ArrayList<Team> teams, ArrayList<Match> matches) {
        Scanner sc = new Scanner(System.in);
        InputController inputController = new InputController();
        TeamController teamController = new TeamController();
        PlayerController playerController = new PlayerController();
        int choice;
        int idTeam;
        Boolean notExists;
        do {
            System.out.println(Menu.getReportsMenuList());
            choice = inputController.verifyValue("Ingrese la opción de reporte: ");
            switch (choice) {
                case 1:
                    playerController.maxScoredGoals(players);
                    break;
                case 2:
                    playerController.maxRedCards(players);
                    break;
                case 3:
                    playerController.maxYellowCards(players);
                    break;
                case 4:
                    do {
                        idTeam = inputController.verifyValue("Ingrese el código del equipo: ");
                        notExists = teamController.searchTeam(teams, idTeam);
                    } while (notExists);
                    for (int i = 0; i <= players.size() - 1; i++) {
                        int idT = players.get(i).getIdTeam();
                        if (idT == idTeam) {
                            System.out.println("NOMBRE: " + players.get(i).getName() + " DORSAL: " + players.get(i).getShirtNumber() + " POSICIÓN: " + players.get(i).getRole());
                        }
                    }
                    break;
                case 5:
                    teamController.showTable(teams);
                    break;
                case 6:
                    do {
                        idTeam = inputController.verifyValue("Ingrese el código del equipo: ");
                        notExists = teamController.searchTeam(teams, idTeam);
                    } while (notExists);
                    for (int i = 0; i <= techs.size() - 1; i++) {
                        int idT = techs.get(i).getIdTeam();
                        if (idT == idTeam) {
                            System.out.println("NOMBRE: " + techs.get(i).getName() + " ROL: " + techs.get(i).getTechType());
                        }
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("***");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("***");
                    break;
            }
        } while (choice != 7);
    }
}