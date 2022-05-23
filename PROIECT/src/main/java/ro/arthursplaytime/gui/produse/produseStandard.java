package ro.arthursplaytime.gui.produse;

public class produseStandard extends produse {
    private Double volum;

    public produseStandard(String nume, String tipFilament, Double costProductie, Double volum){
        super(nume,tipFilament,costProductie);
        this.volum = volum;
    }

    public Double getVolum() {
        return volum;
    }

    public void setVolum(Double volum) {
        this.volum = volum;
    }


}
