package ro.arthursplaytime.angajati;

import java.util.ArrayList;
import java.util.List;

public class angajatiServiceMemory implements angajatiService {
    List<ro.arthursplaytime.angajati.angajati> angajati = new ArrayList<>();


    @Override
    public void save(ro.arthursplaytime.angajati.angajati angajat) {
        angajati.add(angajat);
    }
}
