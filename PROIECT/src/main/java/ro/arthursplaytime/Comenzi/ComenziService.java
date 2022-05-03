package ro.arthursplaytime.Comenzi;

import java.util.List;

public interface ComenziService {
    void save(Comenzi comanda);

    List<Comenzi> getByIdClient(int id);
    List<Comenzi> getByData(String data);

    void modificareStatus(int id_client,String data);
}
