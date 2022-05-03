package ro.arthursplaytime.Angajati;

public class Angajati {
    private static int id_counter = 0;
    private int id_angajat;
    private  String nume;
    private  String prenume;
    private  int salariu;

    public Angajati(String nume,String prenume, int salariu) {
        this.id_counter += 1;
        this.id_angajat = this.id_counter;
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
    }
}
