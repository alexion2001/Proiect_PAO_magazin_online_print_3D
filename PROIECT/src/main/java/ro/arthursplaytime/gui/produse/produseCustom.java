package ro.arthursplaytime.gui.produse;
import java.util.*;

public class produseCustom extends produse {

    private Hashtable<String, Double> dimensiuni = new Hashtable<String,Double>();

    public produseCustom(String nume, String tipfilament, Double costproductie, Double L, Double l, Double h){
        super(nume,tipfilament,costproductie);
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
