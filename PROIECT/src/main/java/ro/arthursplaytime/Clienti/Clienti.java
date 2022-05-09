package ro.arthursplaytime.Clienti;

public class Clienti {
    private static int id_counter = 0;
    private int id_client;
    private  String nume;
    private  String prenume;
    private  String telefon;

    public Clienti(String nume,String prenume, String telefon) {
        this.id_counter += 1;
        this.id_client = this.id_counter;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }

    public Clienti(int id,String nume,String prenume, String telefon) {
        this.id_counter = id;
        this.id_client = this.id_counter;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }



    public int getId_client() {
        return id_client;
    }

    public String getPrenume() {

        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Clienti{" +
                "id_client=" + id_client +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
