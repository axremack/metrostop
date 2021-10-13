package parser;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Parser {
    private Reader reader;
    private BufferedReader br;

    // Constructeur
    public Parser(String filepath){
        try {
            this.reader = new FileReader(filepath);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        br = new BufferedReader(this.reader);
    }

    // Méthodes
    public void parse(List<MetroStop> list_m) throws Exception {
        String line = br.readLine();

        while (line != null) {
            String[] attrs = line.split("#");
            if (attrs[5].equals("metro")) {
                MetroStop m = new MetroStop(attrs);
                list_m.add(m);
            }
            line = br.readLine();
        }
        br.close();
    }
}
