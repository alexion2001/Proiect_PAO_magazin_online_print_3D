package ro.arthursplaytime.gui.tehnologii;

public class filament {
    private String tip;
    private int temperaturaTopire;
    private String culoare;

    public filament(String tip, int temperaturaTopire, String culoare) {
        this.tip = tip;
        this.temperaturaTopire = temperaturaTopire;
        this.culoare = culoare;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getTemperaturaTopire() {
        return temperaturaTopire;
    }

    public void setTemperaturaTopire(int temperaturaTopire) {
        this.temperaturaTopire = temperaturaTopire;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Filament{" +
                "tip='" + tip + '\'' +
                ", temperaturaTopire=" + temperaturaTopire +
                ", culoare='" + culoare + '\'' +
                '}';
    }
}
