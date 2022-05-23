package ro.arthursplaytime.gui.clienti;

import java.util.List;

public interface clientiService {
    void save(clienti client);
    List<clienti> getAll();
    clienti getByTelefon(String telefon);
}
