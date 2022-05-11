package ro.arthursplaytime.Produse;
import java.io.Serializable;
import java.util.*;;


public class Produse implements Serializable {
    private static int id_counter = 0;
    private int id;
    private String nume;
    private String tip_filament;
    private Double cost_productie;
    private Double pret_vanzare;


    public Produse(String nume,String tip_filament,Double cost_productie){
        this.id = this.id_counter + 1;
        this.id_counter += 1;
        this.nume = nume;
        this.tip_filament = tip_filament;
        this.cost_productie = cost_productie;
        this.pret_vanzare = this.cost_productie * 1.5;
    }

    public Produse(String nume,String tip_filament,Double cost_productie,Double pret_vanzare){
        this.id = this.id_counter + 1;
        this.id_counter += 1;
        this.nume = nume;
        this.tip_filament = tip_filament;
        this.cost_productie = cost_productie;
        this.pret_vanzare = pret_vanzare;
    }

    public Produse(int id,String nume,String tip_filament,Double cost_productie,Double pret_vanzare){
        this.id = id;
        this.id_counter += 1;
        this.nume = nume;
        this.tip_filament = tip_filament;
        this.cost_productie = cost_productie;
        this.pret_vanzare = pret_vanzare;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getTip_filament() {
        return tip_filament;
    }

    public Double getCost_productie() {
        return cost_productie;
    }

    public Double getPret_vanzare() {
        return pret_vanzare;
    }

    public static void setId_counter(int id_counter) {
        Produse.id_counter = id_counter;
    }

    public void setTip_filament(String tip_filament) {
        this.tip_filament = tip_filament;
    }

    public void setCost_productie(Double cost_productie) {
        this.cost_productie = cost_productie;
    }

    public void setPret_vanzare(Double pret_vanzare) {
        this.pret_vanzare = pret_vanzare;
    }

    @Override
    public String toString() {
        return "Produse{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", tip_filament='" + tip_filament + '\'' +
                ", cost_productie=" + cost_productie +
                ", pret_vanzare=" + pret_vanzare +
                '}';
    }


}



