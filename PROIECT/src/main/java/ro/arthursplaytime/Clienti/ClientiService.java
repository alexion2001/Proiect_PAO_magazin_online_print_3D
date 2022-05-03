package ro.arthursplaytime.Clienti;

import ro.arthursplaytime.Produse.Produse;

public interface ClientiService {
    void save(Clienti client);

    Clienti getByTelefon(String telefon);
}
