import junit.framework.TestCase;
import metrostop.MetroStop;
import metrostop.MetroStopManager;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class MetroStopManagerTest extends TestCase {
    private List<MetroStop> listMetro = new ArrayList<>();
    private MetroStopManager manager = new MetroStopManager();

    private MetroStop m1 = new MetroStop(1975,2.33871281165883,48.8844176451841,"Abbesses","PARIS-18EME","metro");
    private MetroStop m2 = new MetroStop(1981,2.32674567371924,48.828398514348,"Alésia","PARIS-14EME","metro");
    private MetroStop m3 = new MetroStop(1978,2.3949898158233,48.8561744489676,"Alexandre-Dumas","PARIS-11EME","metro");
    private MetroStop m4 = new MetroStop(1976,2.33871281165883,48.8844176451841,"Aaa","PARIS-18EME","metro");

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    // Les deux méthodes suivantes servent à empêcher les effets de bord
    @Override
    protected void setUp () throws Exception {
        super.setUp ();
        System.setOut(new PrintStream(outContent));
        listMetro = new ArrayList<>();

        listMetro.add(m1);
        listMetro.add(m2);
        listMetro.add(m3);
        listMetro.add(m4);
    }

    @Override
    protected void tearDown () throws Exception {
        super.tearDown ();
        System.setOut(originalOut);
        listMetro = null ;
    }

    // Test de l'affichage d'une liste de MetroStop
    @Test
    public void testPrint() {
        manager.printMetroStopList(listMetro);
        assertEquals("MetroStop n°1975 : latitude = 2.33871281165883, longitude = 48.8844176451841, nom = Abbesses, arrondissement = PARIS-18EME, type = metro\n" +
                        "MetroStop n°1981 : latitude = 2.32674567371924, longitude = 48.828398514348, nom = Alésia, arrondissement = PARIS-14EME, type = metro\n" +
                        "MetroStop n°1978 : latitude = 2.3949898158233, longitude = 48.8561744489676, nom = Alexandre-Dumas, arrondissement = PARIS-11EME, type = metro\n" +
                        "MetroStop n°1976 : latitude = 2.33871281165883, longitude = 48.8844176451841, nom = Aaa, arrondissement = PARIS-18EME, type = metro\n",
                        outContent.toString());
    }

    // Tests des méthodes de tri
    @Test
    public void testSortById() {
        List<MetroStop> listTest = new ArrayList<>();

        // Ajout des MetroStop dans l'ordre croissant des identifiants
        listTest.add(m1);
        listTest.add(m4);
        listTest.add(m3);
        listTest.add(m2);

        manager.sortById(listMetro);
        assertEquals(listTest, listMetro);
    }

    @Test
    public void testSortByDistrict() {
        List<MetroStop> listTest = new ArrayList<>();

        // Ajout des MetroStop dans l'ordre alphabétique des arrondissements puis par nom d'arrêt
        listTest.add(m3);
        listTest.add(m2);
        listTest.add(m4);
        listTest.add(m1);

        manager.sortByDistrict(listMetro);
        assertEquals(listTest, listMetro);
    }
}