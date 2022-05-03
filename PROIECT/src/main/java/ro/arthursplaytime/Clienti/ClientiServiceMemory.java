package ro.arthursplaytime.Clienti;

import ro.arthursplaytime.Produse.Produse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientiServiceMemory implements ClientiService{
    List<Clienti> clienti = new ArrayList<>();


    @Override
    public void save(Clienti client) {
        clienti.add(client);
    }

    @Override
    public Clienti getByTelefon(String telefon) {
        List<Clienti> clientTel = clienti.stream()
                .filter((client -> client.getTelefon().equals(telefon)))
                .collect(Collectors.toList());
        return clientTel.get(0);
    }
}
