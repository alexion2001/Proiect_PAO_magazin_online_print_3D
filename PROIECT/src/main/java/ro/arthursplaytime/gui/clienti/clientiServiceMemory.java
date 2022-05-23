package ro.arthursplaytime.gui.clienti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class clientiServiceMemory implements clientiService {
    List<ro.arthursplaytime.gui.clienti.clienti> clienti = new ArrayList<>();


    @Override
    public void save(ro.arthursplaytime.gui.clienti.clienti client) {
        clienti.add(client);
    }

    @Override
    public ro.arthursplaytime.gui.clienti.clienti getByTelefon(String telefon) {
        List<ro.arthursplaytime.gui.clienti.clienti> clientTel = clienti.stream()
                .filter((client -> client.getTelefon().equals(telefon)))
                .collect(Collectors.toList());
        return clientTel.get(0);
    }

    @Override
    public List<ro.arthursplaytime.gui.clienti.clienti> getAll() {
        return clienti;
    }
}
