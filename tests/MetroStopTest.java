import junit.framework.TestCase;
import org.junit.Test;
import metrostop.MetroStop;


public class MetroStopTest extends TestCase {
    private MetroStop m;

    // Les deux méthodes suivantes servent à empêcher les effets de bord
    @Override
    protected void setUp () throws Exception {
        super.setUp ();
        m = new MetroStop(1988,2.35637778086357, 48.8652929436681,"Arts-et-Métiers","PARIS-03EME","metro");
    }

    @Override
    protected void tearDown () throws Exception {
        super.tearDown ();
        m = null ;
    }

    // Tests des getters et des setters
    @Test
    public void testGetId() {
        int x = 1988;
        assertEquals(x, m.getId());
    }

    @Test
    public void testGetLatitude() {
        double x = 2.35637778086357;
        assertEquals(x, m.getLatitude());
    }

    @Test
    public void testGetLongitude() {
        double x = 48.8652929436681;
        assertEquals(x, m.getLongitude());
    }

    @Test
    public void testGetNom() {
        String x = "Arts-et-Métiers";
        assertEquals(x, m.getNom());
    }

    @Test
    public void testGetArrondissement() {
        String x = "PARIS-03EME";
        assertEquals(x, m.getArrondissement());
    }

    @Test
    public void testGetType() {
        String x = "metro";
        assertEquals(x, m.getType());
    }

    @Test
    public void testSetId() {
        int x = 225437;
        m.setId(x);
        assertEquals(x, m.getId());
    }

    @Test
    public void testSetLatitude() {
        double x = 2.28407447167184;
        m.setLatitude(x);
        assertEquals(x, m.getLatitude());
    }

    @Test
    public void testSetLongitude() {
        Double x = 48.9301634125573;
        m.setLongitude(x);
        assertEquals(x, m.getLongitude());
    }

    @Test
    public void testSetNom() {
        String x = "Asnieres-Gennevilliers Les Courtilles";
        m.setNom(x);
        assertEquals(x, m.getNom());
    }

    @Test
    public void testSetArrondissement() {
        String x = "ASNIERES-SUR-SEINE";
        m.setArrondissement(x);
        assertEquals(x, m.getArrondissement());
    }

    @Test
    public void testSetType() {
        String x = "bus";
        m.setType(x);
        assertEquals(x, m.getType());
    }

    // Tests des méthodes
    @Test
    public void testTestToString() {
        String x = "MetroStop n°1988 : latitude = 2.35637778086357, longitude = 48.8652929436681, nom = Arts-et-Métiers, arrondissement = PARIS-03EME, type = metro";
        assertEquals(x, m.toString());
    }
}

