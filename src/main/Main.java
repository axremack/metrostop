package main;

import metrostop.MetroStop;
import metrostop.MetroStopManager;
import parser.Parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.println("Quelle fonction éxecuter ?");
        System.out.println("\t1 - Afficher la liste des arrêts de métro.");
        System.out.println("\t2 - Trier la liste des arrêts de métro par identifiant.");
        System.out.println("\t3 - Trier la liste des arrêts de métro par arrondissement (puis nom).");
        System.out.println("\t4 - Arrêter le programme.");
    }

    public static void main(String[] args) throws Exception {
        String filepath = "resources/ratp_arret.csv";
        Parser p = new Parser(filepath);
        List<MetroStop> list = new ArrayList<>();
        p.parse(list);

        MetroStopManager manager = new MetroStopManager();
        Scanner sc = new Scanner(System.in);

        boolean fin = false;

        while (!fin) {
            printMenu();
            String rep = sc.nextLine();
            System.out.println();

            switch (rep) {
                // Affichage de la liste des arrêts de métro
                case "1":
                    manager.printMetroStopList(list);
                    System.out.println();
                    break;
                // Tri par identifiant puis affichage de la liste
                case "2":
                    manager.sortById(list);
                    manager.printMetroStopList(list);
                    break;
                // Tri par arrondissement (puis nom) puis affichage de la liste
                case "3":
                    manager.sortByDistrict(list);
                    manager.printMetroStopList(list);
                    break;
                // Terminer le programme
                default:
                    System.out.println("Adios");
                    fin = true;
                    break;
            }
        }
        sc.close();
    }
}
