package parser;
import metrostop.MetroStop;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;


public class Parser {
    private Reader reader;
    private BufferedReader br;

    // Constructeurs
    public Parser(String filepath){
        try {
            this.reader = new FileReader(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        br = new BufferedReader(this.reader);
    }

    public Parser(Reader r){
        this.reader = r;
        br = new BufferedReader(this.reader);
    }

    // Méthodes
    public static boolean isInt(String s) {
        try {
            int n = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            double d = Double.parseDouble(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void parse(List<MetroStop> list_m) throws Exception {
        String line = br.readLine();

        while (line != null) {
            String[] attrs = line.split("#");
            if(attrs.length == 6) { // Vérification du nombre d'arguments
                if (attrs[5].equals("metro")) {
                    if(isInt(attrs[0]) && isDouble(attrs[1]) && isDouble(attrs[2])) { // Vérification du type des arguments
                        MetroStop m = new MetroStop(attrs);
                        list_m.add(m);
                    }
                }
            }
            line = br.readLine();
        }
        br.close();
    }
}
