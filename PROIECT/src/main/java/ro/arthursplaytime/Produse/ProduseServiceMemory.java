package ro.arthursplaytime.Produse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProduseServiceMemory implements ProduseService {

    List<Produse> produse = new ArrayList<>();

    @Override
    public void save(Produse produs) {
        produse.add(produs);
    }

    @Override
    public Produse getById(int id) {
        List<Produse> produseById = produse.stream()
                .filter((produs -> produs.getId() == id))
                .collect(Collectors.toList());

        return produseById.get(0);
    }

    @Override
    public void modificarePret(int id, double pret) {
        for (int i = 0; i < produse.size(); i++) {
            if (produse.get(i).getId() == id)
           produse.get(i).setPret_vanzare(pret);
        }
    }
}
