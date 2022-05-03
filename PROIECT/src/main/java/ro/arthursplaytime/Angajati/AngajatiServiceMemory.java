package ro.arthursplaytime.Angajati;

import java.util.ArrayList;
import java.util.List;

public class AngajatiServiceMemory implements AngajatiService{
    List<Angajati> angajati = new ArrayList<>();


    @Override
    public void save(Angajati angajat) {
        angajati.add(angajat);
    }
}
