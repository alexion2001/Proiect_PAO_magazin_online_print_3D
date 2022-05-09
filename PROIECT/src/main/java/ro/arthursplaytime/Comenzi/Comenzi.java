package ro.arthursplaytime.Comenzi;

import ro.arthursplaytime.Produse.Produse;

import java.util.ArrayList;
import java.util.List;

public class Comenzi {

    private int id_client;
    private int id_angajat;
    private String data;
    private List<Produse> produse = new ArrayList<>();
    private String status;

    public Comenzi(int id_client, int id_angajat, String data, List<Produse> produse) {
        this.id_client = id_client;
        this.id_angajat = id_angajat;
        this.data = data;
        this.produse = produse;
        this.status = "nepreluata";
    }

    public Comenzi(int id_client, int id_angajat, String data, List<Produse> produse,String status) {
        this.id_client = id_client;
        this.id_angajat = id_angajat;
        this.data = data;
        this.produse = produse;
        this.status = status;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_angajat() {
        return id_angajat;
    }

    public void setId_angajat(int id_angajat) {
        this.id_angajat = id_angajat;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Produse> getProduse() {
        return produse;
    }

    public void setProduse(List<Produse> produse) {
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
        return "Comenzi{" +
                "id_client=" + id_client +
                ", id_angajat=" + id_angajat +
                ", data='" + data + '\'' +
                ", produse=" + produse +
                ", status='" + status + '\'' +
                '}';
    }
}

