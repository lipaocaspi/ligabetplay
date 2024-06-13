package com.paola.ligabetplay.menus;

public class Menu {
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
        1. Jugador con más goles anotados
        2. Jugador con más tarjetas rojas recibidas
        3. Jugador con más tarjetas amarillas recibidas
        4. Listar jugadores por equipo
        5. Tabla de posiciones del torneo
        6. Cuerpo técnico por equipo
        7. Salir al menú principal
        """;
    
    static String title = """
        ********************************
                LIGA BETPLAY
        ********************************
        """;

    public static String getMainMenuList() {
        return mainMenuList;
    }

    public static void setMainMenuList(String mainMenuList) {
        Menu.mainMenuList = mainMenuList;
    }

    public static String getCoachingStaffMenuList() {
        return coachingStaffMenuList;
    }

    public static void setCoachingStaffMenuList(String coachingStaffMenuList) {
        Menu.coachingStaffMenuList = coachingStaffMenuList;
    }

    public static String getMedicalStaffMenuList() {
        return medicalStaffMenuList;
    }

    public static void setMedicalStaffMenuList(String medicalStaffMenuList) {
        Menu.medicalStaffMenuList = medicalStaffMenuList;
    }

    public static String getReportsMenuList() {
        return reportsMenuList;
    }

    public static void setReportsMenuList(String reportsMenuList) {
        Menu.reportsMenuList = reportsMenuList;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Menu.title = title;
    }
}