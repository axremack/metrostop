import junit.framework.TestCase;
import org.junit.Test;

import metrostop.MetroStop;
import parser.Parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class ParserTest extends TestCase {
    private String mockedFile = "tests/mockedFile.csv";
    private String emptyFile = "tests/emptyFile.csv";
    private String diverseTypesFile = "tests/diverseTypesFile.csv";
    private List<MetroStop> listMetro;

    // Les deux méthodes suivantes servent à empêcher les effets de bord
    @Override
    protected void setUp () throws Exception {
        super.setUp ();
        listMetro = new ArrayList<>();

        MetroStop m1 = new MetroStop(1975,2.33871281165883,48.8844176451841,"Abbesses","PARIS-18EME","metro");
        MetroStop m2 = new MetroStop(1981,2.32674567371924,48.828398514348,"Alésia","PARIS-14EME","metro");
        MetroStop m3 = new MetroStop(1978,2.3949898158233,48.8561744489676,"Alexandre-Dumas","PARIS-11EME","metro");

        listMetro.add(m1);
        listMetro.add(m2);
        listMetro.add(m3);
    }

    @Override
    protected void tearDown () throws Exception {
        super.tearDown ();
        listMetro = null ;
    }

    // Test de la méthode de parsing
    @Test
    public void testParse() {
        List<MetroStop> list = new ArrayList<>();
        Parser p = new Parser(mockedFile);

        try {
            p.parse(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(listMetro, list);
    }

    // Tests des cas limites
    @Test
    public void testParseEmptyFile() {
        List<MetroStop> list = new ArrayList<>();
        Parser p = new Parser(emptyFile);

        try {
            p.parse(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(list.isEmpty()); // La liste de MetroStop est vide
    }

    @Test
    // Si les séparateurs de données sur la ligne ne sont pas les bons, elle n'est pas traitée
    public void testLineSeparator() {
        List<MetroStop> list = new ArrayList<>();
        Reader r = new StringReader("1975;2.33871281165883;48.8844176451841;Abbesses;PARIS-18EME;metro");
        Parser p = new Parser(r);

        try {
            p.parse(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(list.isEmpty()); // La liste de MetroStop est vide
    }

    @Test
    // Si le type de données sur la ligne n'est par correcte, elle n'est pas traitée
    public void testLineDataType() {
        List<MetroStop> list = new ArrayList<>();
        Reader r = new StringReader("identifiant#2.33871281165883#48.8844176451841#Abbesses#PARIS-18EME#metro");
        Parser p = new Parser(r);

        try {
            p.parse(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(list.isEmpty()); // La liste de MetroStop est vide
    }

    @Test
    // Si la ligne n'a pas le bon nombre de données, elle n'est pas traitée
    public void testLineDataNumber() {
        List<MetroStop> list = new ArrayList<>();
        Reader r = new StringReader("1975#2.33871281165883#48.8844176451841#Abbesses#PARIS-18EME");
        Parser p = new Parser(r);

        try {
            p.parse(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(list.isEmpty()); // La liste de MetroStop est vide
    }

    @Test
    // Seuls les arrêts de metro sont pris en compte
    public void testOnlyMetro(){
        List<MetroStop> list = new ArrayList<>();
        Parser p = new Parser(diverseTypesFile);

        try {
            p.parse(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(1, list.size()); // La liste de MetroStop n'a qu'un seul élément
        assertEquals("metro", list.get(0).getType()); // L'unique élément de la liste est bien un arrêt de metro
    }
}
