package ro.arthursplaytime.comenzi;

import java.util.ArrayList;
import java.util.List;

public class comenzi {

    private int idClient;
    private int idAngajat;
    private String data;
    private List<ro.arthursplaytime.produse.produse> produse = new ArrayList<>();
    private String status;

    public comenzi(int idClient, int idAngajat, String data, List<ro.arthursplaytime.produse.produse> produse) {
        this.idClient = idClient;
        this.idAngajat = idAngajat;
        this.data = data;
        this.produse = produse;
        this.status = "nepreluata";
    }

    public comenzi(int idClient, int idAngajat, String data, List<ro.arthursplaytime.produse.produse> produse, String status) {
        this.idClient = idClient;
        this.idAngajat = idAngajat;
        this.data = data;
        this.produse = produse;
        this.status = status;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<ro.arthursplaytime.produse.produse> getProduse() {
        return produse;
    }

    public void setProduse(List<ro.arthursplaytime.produse.produse> produse) {
        this.produse = produse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "comenzi{" +
                "idClient=" + idClient +
                ", idAngajat=" + idAngajat +
                ", data='" + data + '\'' +
                ", produse=" + produse +
                ", status='" + status + '\'' +
                '}';
    }
}

