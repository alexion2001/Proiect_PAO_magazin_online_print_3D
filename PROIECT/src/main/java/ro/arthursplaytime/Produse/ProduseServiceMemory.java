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
    public void exceptieId(int id) {
        if (produse.size() < id){
            throw new ProduseException();
        }
    }

    @Override
    public Produse getById(int id) {
        exceptieId(id);

        List<Produse> produseById = produse.stream()
                .filter((produs -> produs.getId() == id))
                .collect(Collectors.toList());

        return produseById.get(0);
    }

    @Override
    public List<Produse> getAll() {
            return produse;
    }

    @Override
    public void modificarePret(int id, double pret) {
        exceptieId(id);
        for (int i = 0; i < produse.size(); i++) {
            if (produse.get(i).getId() == id)
           produse.get(i).setPret_vanzare(pret);
        }
    }


}
