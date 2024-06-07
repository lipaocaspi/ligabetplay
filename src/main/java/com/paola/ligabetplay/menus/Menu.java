package com.paola.ligabetplay.menus;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.controllers.MenuController;
import com.paola.ligabetplay.models.Match;
import com.paola.ligabetplay.models.Team;

public class Menu {
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> matches = new ArrayList<>();

    static String mainMenuList = """
        1. Registrar Equipo
        2. Registrar Jugador
        3. Registrar Cuerpo Técnico
        4. Registrar Cuerpo Médico
        5. Registrar Partido
        6. Reportes
        7. Salir
        """;

    static String coachingStaffMenuList = """
        *******************************
            REGISTRO CUERPO TÉCNICO
        *******************************
        1. Registrar técnico
        2. Registrar asistente técnico
        3. Registrar preparador físico
        4. Salir al menú principal
        """;

    static String medicalStaffMenuList = """
        *******************************
            REGISTRO CUERPO MÉDICO
        *******************************
        1. Registrar fisioterapeuta
        2. Registrar médico
        3. Salir al menú principal
        """;

    static String reportsMenuList = """
        *******************************
                    REPORTES
        *******************************
        1. Jugador y los goles anotados
        2. Jugador y las tarjetas rojas recibidas
        3. Jugador y las tarjetas amarillas recibidas
        4. Listar jugadores por equipo
        5. Tabla de posiciones del torneo
        6. Cuerpo técnico
        7. Salir al menú principal
        """;
    
    static String title = """
        ********************************
                LIGA BETPLAY
        ********************************
        """;

    public void showMainMenu() {
        MenuController menuController = new MenuController();
        int choice;
        // Boolean equalMatches;
        do {
            System.out.println(title);
            System.out.println(mainMenuList);
            choice = menuController.verifyValue("Ingrese la opción: ");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    showCoachingStaffMenu();
                    break;
                case 4:
                    showMedicalStaffMenu();
                    break;
                case 5:
                    break;
                case 6:
                    showReportsMenu(teams, matches);
                    break;
                case 7:
                    System.out.println("****************************");
                    System.out.println("GRACIAS POR USAR EL SERVICIO");
                    System.out.println("****************************");
                    break;
                default:
                    System.out.println("---");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("---");
                    break;
            }
        } while (choice != 7);
    }

    public void showCoachingStaffMenu() {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        int choice;
        do {
            System.out.println(coachingStaffMenuList);
            choice = menuController.verifyValue("Ingrese la opción de registro: ");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("---");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("---");
                    break;
            }
        } while (choice != 4);
    }

    public void showMedicalStaffMenu() {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        int choice;
        do {
            System.out.println(medicalStaffMenuList);
            choice = menuController.verifyValue("Ingrese la opción de registro: ");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("---");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("---");
                    break;
            }
        } while (choice != 3);
    }

    public void showReportsMenu(ArrayList<Team> teams, ArrayList<Match> matches) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        int choice;
        do {
            System.out.println(reportsMenuList);
            choice = menuController.verifyValue("Ingrese la opción de reporte: ");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("---");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("---");
                    break;
            }
        } while (choice != 7);
    }
}