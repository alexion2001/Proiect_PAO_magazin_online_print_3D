package ro.arthursplaytime.gui.angajati;

import java.util.ArrayList;
import java.util.List;

public class angajatiServiceMemory implements angajatiService {
    List<ro.arthursplaytime.gui.angajati.angajati> angajati = new ArrayList<>();


    @Override
    public void save(ro.arthursplaytime.gui.angajati.angajati angajat) {
        angajati.add(angajat);
    }
}
