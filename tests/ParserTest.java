import junit.framework.TestCase;
import org.junit.Test;

import parser.MetroStop;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class ParserTest extends TestCase {
    public String mockedFile = "tests/mockedFile.csv";
    public String emptyFile = "tests/emptyFile.csv";

    // Cases covered by testFile.csv :
    //      - Empty line
    //      - Bad separator
    //      - Stops that ar not "metro" type
    public String badFile = "tests/badFile.csv";

    public List<MetroStop> listMetro;

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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(listMetro, list);
    }

    // Tests des cas limites
    /*
    @Test
    public void testParseEmptyFile() {
        List<MetroStop> list = new ArrayList<>();
        Parser p = new Parser(emptyFile);
        try {
            p.parse(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(listMetro, list);
    }
    */

    /*
    @Test
    public void testParseBadFile() {
        List<MetroStop> list = new ArrayList<>();
        Parser p = new Parser(badFile);
        try {
            p.parse(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(listMetro, list);
    }
     */
}
