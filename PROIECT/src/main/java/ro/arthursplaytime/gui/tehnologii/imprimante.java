package ro.arthursplaytime.gui.tehnologii;
import java.util.*;

public class imprimante {
    private String nume;
    private String status;
    private List<filament> filamenteCompatibile = new ArrayList<>();
    private Hashtable<String, Double> dimensiunePat = new Hashtable<String,Double>();

    public imprimante(String nume, List<filament> filamenteCompatibile, Double L, Double l, Double h) {
        this.nume = nume;
        this.status = "disponibila";
        this.filamenteCompatibile = filamenteCompatibile;
        this.dimensiunePat.put("lungime",L);
        this.dimensiunePat.put("latime",l);
        this.dimensiunePat.put("inaltime",h);
    }
    public imprimante(String nume, List<filament> filamenteCompatibile, Double L, Double l, Double h, String status) {
        this.nume = nume;
        this.filamenteCompatibile = filamenteCompatibile;
        this. dimensiunePat.put("lungime",L);
        this. dimensiunePat.put("latime",l);
        this. dimensiunePat.put("inaltime",h);
        this.status = status;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<filament> getFilamenteCompatibile() {
        return filamenteCompatibile;
    }

    public void setFilamenteCompatibile(List<filament> filamenteCompatibile) {
        this.filamenteCompatibile = filamenteCompatibile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Hashtable<String, Double> getDimensiunePat() {
        return dimensiunePat;
    }

    public void setDimensiunePat(Hashtable<String, Double> dimensiunePat) {
        this.dimensiunePat = dimensiunePat;
    }

    @Override
    public String toString() {
        return "Imprimante{" +
                "nume='" + nume + '\'' +
                "status='" + status + '\'' +
                ", filamenteCompatibile=" + filamenteCompatibile +
                ", dimensiunePat=" + dimensiunePat +
                '}';
    }
}
