package ro.arthursplaytime.Produse;

public interface ProduseService {

    void save(Produse produs);

    Produse getById(int id);
    void modificarePret(int id, double pret);

    void exceptieId(int id);

}
