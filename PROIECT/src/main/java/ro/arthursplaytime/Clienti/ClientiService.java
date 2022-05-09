package ro.arthursplaytime.Clienti;

import ro.arthursplaytime.Produse.Produse;

import java.util.List;

public interface ClientiService {
    void save(Clienti client);
    List<Clienti> getAll();
    Clienti getByTelefon(String telefon);
}
