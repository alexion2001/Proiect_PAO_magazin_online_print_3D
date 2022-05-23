package ro.arthursplaytime.gui.produse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class produseServiceMemory implements produseService {

    List<ro.arthursplaytime.gui.produse.produse> produse = new ArrayList<>();

    @Override
    public void save(ro.arthursplaytime.gui.produse.produse produs) {
        produse.add(produs);
    }

    @Override
    public void exceptieId(int id) {
        if (produse.size() < id){
            throw new produseException();
        }
    }

    @Override
    public ro.arthursplaytime.gui.produse.produse getById(int id) {
        exceptieId(id);

        List<ro.arthursplaytime.gui.produse.produse> produseById = produse.stream()
                .filter((produs -> produs.getId() == id))
                .collect(Collectors.toList());

        return produseById.get(0);
    }

    @Override
    public List<ro.arthursplaytime.gui.produse.produse> getAll() {
            return produse;
    }

    @Override
    public void modificarePret(int id, double pret) {
        exceptieId(id);
        for (int i = 0; i < produse.size(); i++) {
            if (produse.get(i).getId() == id)
           produse.get(i).setPretVanzare(pret);
        }
    }


}
