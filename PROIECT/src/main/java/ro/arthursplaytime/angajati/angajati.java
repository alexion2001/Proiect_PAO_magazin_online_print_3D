package ro.arthursplaytime.angajati;

public class angajati {
    private static int id_counter = 0;
    private int idAngajat;
    private  String nume;
    private  String prenume;
    private  int salariu;

    public angajati(String nume, String prenume, int salariu) {
        this.id_counter += 1;
        this.idAngajat = this.id_counter;
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
    }
}
