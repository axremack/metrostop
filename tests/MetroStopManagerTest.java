import junit.framework.TestCase;
import metrostop.MetroStop;
import metrostop.MetroStopManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetroStopManagerTest extends TestCase {
    private List<MetroStop> listMetro = new ArrayList<>();

    private MetroStop m1 = new MetroStop(1975,2.33871281165883,48.8844176451841,"Abbesses","PARIS-18EME","metro");
    private MetroStop m2 = new MetroStop(1981,2.32674567371924,48.828398514348,"Aalésia","PARIS-14EME","metro");
    private MetroStop m3 = new MetroStop(1978,2.3949898158233,48.8561744489676,"Alexandre-Dumas","PARIS-11EME","metro");


    // Les deux méthodes suivantes servent à empêcher les effets de bord
    @Override
    protected void setUp () throws Exception {
        super.setUp ();
        listMetro = new ArrayList<>();

        listMetro.add(m1);
        listMetro.add(m2);
        listMetro.add(m3);
    }

    @Override
    protected void tearDown () throws Exception {
        super.tearDown ();
        listMetro = null ;
    }

    // Tests de l'affichage d'une liste de MetroStop


    // Tests des méthodes de tri
    @Test
    public void testSortById() {
        List<MetroStop> listTest = new ArrayList<>();

        // Ajout des MetroStop dans l'ordre croissant des identifiants
        listTest.add(m1);
        listTest.add(m3);
        listTest.add(m2);

        MetroStopManager.sortById(listMetro);
        assertEquals(listTest, listMetro);
    }

    @Test
    public void testSortByDistrict() {
        List<MetroStop> listTest = new ArrayList<>();

        // Ajout des MetroStop dans l'ordre alphabétique des arrondissements
        listTest.add(m3);
        listTest.add(m2);
        listTest.add(m1);

        MetroStopManager.sortByDistrict(listMetro);
        assertEquals(listTest, listMetro);
    }

    @Test
    public void testSortByName() {
        List<MetroStop> listTest = new ArrayList<>();

        // Ajout des MetroStop dans l'ordre alphabétique des noms
        listTest.add(m2);
        listTest.add(m1);
        listTest.add(m3);

        MetroStopManager.sortByName(listMetro);
        assertEquals(listTest, listMetro);
    }


}