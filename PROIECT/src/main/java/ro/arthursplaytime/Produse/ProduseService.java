package ro.arthursplaytime.Produse;

import java.util.List;

public interface ProduseService {

    void save(Produse produs);

    Produse getById(int id);
    void modificarePret(int id, double pret);

    void exceptieId(int id);

    public List<Produse> getAll();

}
