package ro.arthursplaytime.Tehnologii;

public class Filament {
    private String tip;
    private int temperatura_topire;
    private String culoare;

    public Filament(String tip, int temperatura_topire, String culoare) {
        this.tip = tip;
        this.temperatura_topire = temperatura_topire;
        this.culoare = culoare;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getTemperatura_topire() {
        return temperatura_topire;
    }

    public void setTemperatura_topire(int temperatura_topire) {
        this.temperatura_topire = temperatura_topire;
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
                ", temperatura_topire=" + temperatura_topire +
                ", culoare='" + culoare + '\'' +
                '}';
    }
}
