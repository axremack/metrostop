package parser;

public class MetroStop {
    private int id;
    private double longitude;
    private double latitude;
    private String nom;
    private String arrondissement;
    private String type;


    // Constructeurs
    public MetroStop(int id, double longitude, double latitude, String nom, String arrondissement, String type) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.type = type;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getNom() {
        return nom;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Méthodes
    @Override
    public String toString() {
        return "MetroStop n°" + id + ": longitude = " + longitude + ", latitude = " + latitude + ", nom = " + nom + ", arrondissement = " + arrondissement + ", type = " + type;
    }

}
