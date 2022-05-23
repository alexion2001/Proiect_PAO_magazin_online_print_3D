package ro.arthursplaytime.gui.comenzi;

import java.util.List;

public class comenziCustom extends comenzi {
    private String detaliiProduse;

    public comenziCustom(int idClient, int idAngajat, String data, List<ro.arthursplaytime.gui.produse.produse> produse, String detalii_produse) {
        super(idClient, idAngajat, data, produse);
        this.detaliiProduse = detalii_produse;
    }

    public String getDetaliiProduse() {
        return detaliiProduse;
    }

    public void setDetaliiProduse(String detalii_produse) {
        this.detaliiProduse = detalii_produse;
    }
}
