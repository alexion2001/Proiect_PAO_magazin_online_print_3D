package ro.arthursplaytime.Produse;
import java.util.*;

public class ProduseStandard extends Produse {
    private Double volum;

    public ProduseStandard(String nume,String tip_filament,Double cost_productie,Double volum){
        super(nume,tip_filament,cost_productie);
        this.volum = volum;
    }

    public Double getVolum() {
        return volum;
    }

    public void setVolum(Double volum) {
        this.volum = volum;
    }


}
