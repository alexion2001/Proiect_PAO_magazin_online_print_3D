package ro.arthursplaytime.gui.comenzi;

import java.util.List;

public interface comenziService {
    void save(comenzi comanda);

    List<comenzi> getByIdClient(int id);
    List<comenzi> getByData(String data);

    void modificareStatus(int idClient,String data);

    public List<comenzi> getAll();
}
