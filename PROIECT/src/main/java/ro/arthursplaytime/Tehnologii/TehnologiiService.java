package ro.arthursplaytime.Tehnologii;

import ro.arthursplaytime.Produse.Produse;

import java.util.List;

public interface TehnologiiService {

    void saveFilament(Filament filament);
    void saveImprimanta(Imprimante imprimante);

    void getByStatus();
    Filament getByTip(String tip);

    void modificareStatus(String nume);

    List<Imprimante> getAll();
}
