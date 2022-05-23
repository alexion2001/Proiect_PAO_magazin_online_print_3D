package ro.arthursplaytime.gui.tehnologii;

import java.util.List;

public interface tehnologiiService {

    void saveFilament(filament filament);
    void saveImprimanta(imprimante imprimante);

    void getByStatus();
    filament getByTip(String tip);

    void modificareStatus(String nume);

    List<imprimante> getAll();
}
