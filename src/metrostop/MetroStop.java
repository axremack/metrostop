package metrostop;

import java.util.Objects;

public class MetroStop {
    private int id;
    private double latitude;
    private double longitude;
    private String nom;
    private String arrondissement;
    private String type;

    // Constructeurs
    public MetroStop(int id, double latitude, double longitude, String nom, String arrondissement, String type) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.type = type;
    }

    public MetroStop(String[] list_args) {
        this.id = Integer.parseInt(list_args[0]);
        this.latitude = Double.parseDouble(list_args[1]);
        this.longitude = Double.parseDouble(list_args[2]);
        this.nom = list_args[3];
        this.arrondissement = list_args[4];
        this.type = list_args[5];
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        return "MetroStop n°" + id + " : latitude = " + latitude + ", longitude = " + longitude + ", nom = " + nom + ", arrondissement = " + arrondissement + ", type = " + type;
    }

    // Méthodes à redefinir obligatoirement pour les comparaisons...
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetroStop metroStop = (MetroStop) o;
        return id == metroStop.id && Double.compare(metroStop.latitude, latitude) == 0 && Double.compare(metroStop.longitude, longitude) == 0 && nom.equals(metroStop.nom) && arrondissement.equals(metroStop.arrondissement) && type.equals(metroStop.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, nom, arrondissement, type);
    }
}
