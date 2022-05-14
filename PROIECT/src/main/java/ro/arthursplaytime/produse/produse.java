package ro.arthursplaytime.produse;
import java.io.Serializable;
;


public class produse implements Serializable {
    private static int idCounter = 0;
    private int id;
    private String nume;
    private String tipFilament;
    private Double costProductie;
    private Double pretVanzare;


    public produse(String nume, String tipFilament, Double costProductie){
        this.id = this.idCounter + 1;
        this.idCounter += 1;
        this.nume = nume;
        this.tipFilament = tipFilament;
        this.costProductie = costProductie;
        this.pretVanzare = this.costProductie * 1.5;
    }

    public produse(String nume, String tipFilament, Double costProductie, Double pretVanzare){
        this.id = this.idCounter + 1;
        this.idCounter += 1;
        this.nume = nume;
        this.tipFilament = tipFilament;
        this.costProductie = costProductie;
        this.pretVanzare = pretVanzare;
    }

    public produse(int id, String nume, String tipFilament, Double costProductie, Double pretVanzare){
        this.id = id;
        this.idCounter += 1;
        this.nume = nume;
        this.tipFilament = tipFilament;
        this.costProductie = costProductie;
        this.pretVanzare = pretVanzare;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getTipFilament() {
        return tipFilament;
    }

    public Double getCostProductie() {
        return costProductie;
    }

    public Double getPretVanzare() {
        return pretVanzare;
    }


    public void setTipFilament(String tipFilament) {
        this.tipFilament = tipFilament;
    }

    public void setCostProductie(Double costProductie) {
        this.costProductie = costProductie;
    }

    public void setPretVanzare(Double pretVanzare) {
        this.pretVanzare = pretVanzare;
    }

    @Override
    public String toString() {
        return "produse{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", tipFilament='" + tipFilament + '\'' +
                ", costProductie=" + costProductie +
                ", pretVanzare=" + pretVanzare +
                '}';
    }


}



