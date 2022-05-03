package ro.arthursplaytime.Comenzi;

import ro.arthursplaytime.Produse.Produse;

import java.util.ArrayList;
import java.util.List;

public class ComenziCustom extends Comenzi{
    private String detalii_produse;

    public ComenziCustom(int id_client, int id_angajat, String data, List<Produse> produse, String detalii_produse) {
        super(id_client, id_angajat, data, produse);
        this.detalii_produse = detalii_produse;
    }

    public String getDetalii_produse() {
        return detalii_produse;
    }

    public void setDetalii_produse(String detalii_produse) {
        this.detalii_produse = detalii_produse;
    }
}
