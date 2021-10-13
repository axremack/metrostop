package main;

import parser.MetroStop;
import parser.Parser;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String filepath = "resources/ratp_arret.csv";
        Parser p = new Parser(filepath);
        List<MetroStop> list = new ArrayList<>();
        p.parse(list);

        for (int i = 0; i < 20; i++) {
            System.out.println(list.get(i));
        }
    }
}
