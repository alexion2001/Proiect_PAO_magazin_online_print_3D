package ro.arthursplaytime.clienti;

public class clienti {
    private static int id_counter = 0;
    private int idClient;
    private  String nume;
    private  String prenume;
    private  String telefon;

    public clienti(String nume, String prenume, String telefon) {
        this.id_counter += 1;
        this.idClient = this.id_counter;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }

    public clienti(int id, String nume, String prenume, String telefon) {
        this.id_counter = id;
        this.idClient = this.id_counter;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }



    public int getIdClient() {
        return idClient;
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
                "idClient=" + idClient +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
