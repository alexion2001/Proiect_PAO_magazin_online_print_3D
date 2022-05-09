package ro.arthursplaytime.Tehnologii;
import java.util.*;

public class Imprimante {
    private String nume;
    private String status;
    private List<Filament> filamente_compatibile = new ArrayList<>();
    private Hashtable<String, Double> dimensiune_pat = new Hashtable<String,Double>();

    public Imprimante(String nume, List<Filament> filamente_compatibile, Double L, Double l, Double h) {
        this.nume = nume;
        this.status = "disponibila";
        this.filamente_compatibile = filamente_compatibile;
        this.dimensiune_pat.put("lungime",L);
        this.dimensiune_pat.put("latime",l);
        this.dimensiune_pat.put("inaltime",h);
    }
    public Imprimante(String nume, List<Filament> filamente_compatibile, Double L, Double l, Double h, String status) {
        this.nume = nume;
        this.filamente_compatibile = filamente_compatibile;
        this. dimensiune_pat.put("lungime",L);
        this. dimensiune_pat.put("latime",l);
        this. dimensiune_pat.put("inaltime",h);
        this.status = status;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Filament> getFilamente_compatibile() {
        return filamente_compatibile;
    }

    public void setFilamente_compatibile(List<Filament> filamente_compatibile) {
        this.filamente_compatibile = filamente_compatibile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Hashtable<String, Double> getDimensiune_pat() {
        return dimensiune_pat;
    }

    public void setDimensiune_pat(Hashtable<String, Double> dimensiune_pat) {
        this.dimensiune_pat = dimensiune_pat;
    }

    @Override
    public String toString() {
        return "Imprimante{" +
                "nume='" + nume + '\'' +
                "status='" + status + '\'' +
                ", filamente_compatibile=" + filamente_compatibile +
                ", dimensiune_pat=" + dimensiune_pat +
                '}';
    }
}
