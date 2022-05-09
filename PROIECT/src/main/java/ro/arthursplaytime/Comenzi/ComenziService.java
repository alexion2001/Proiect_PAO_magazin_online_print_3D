package ro.arthursplaytime.Comenzi;

import ro.arthursplaytime.Produse.Produse;

import java.util.Collection;
import java.util.List;
import java.util.SortedMap;

public interface ComenziService {
    void save(Comenzi comanda);

    List<Comenzi> getByIdClient(int id);
    List<Comenzi> getByData(String data);

    void modificareStatus(int id_client,String data);

    public List<Comenzi> getAll();
}
