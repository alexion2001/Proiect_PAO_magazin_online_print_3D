package ro.arthursplaytime.produse;

import java.util.List;

public interface produseService {

    void save(produse produs);

    produse getById(int id);
    void modificarePret(int id, double pret);

    void exceptieId(int id);

    public List<produse> getAll();

}
