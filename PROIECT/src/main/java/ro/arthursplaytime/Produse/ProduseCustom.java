package ro.arthursplaytime.Produse;
import java.util.*;

public class ProduseCustom extends Produse {

    private Hashtable<String, Double> dimensiuni = new Hashtable<String,Double>();

    public ProduseCustom(String nume,String tip_filament,Double cost_productie,Double L, Double l, Double h){
        super(nume,tip_filament,cost_productie);
        this.dimensiuni.put("lungime",L);
        this.dimensiuni.put("latime",l);
        this.dimensiuni.put("inaltime",h);
    }

    public Hashtable<String, Double> getDimensiuni() {
        return dimensiuni;
    }

    public void setDimensiuni(Hashtable<String, Double> dimensiuni) {
        this.dimensiuni = dimensiuni;
    }
}
