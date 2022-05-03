package ro.arthursplaytime.Tehnologii;

import ro.arthursplaytime.Produse.Produse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class TehnologiiServiceMemory implements TehnologiiService{

    List<Imprimante> imprimante = new ArrayList<>();
    Set<Filament> filamente = new HashSet<Filament>();


    @Override
    public void saveFilament(Filament filament) {
        filamente.add(filament);
    }

    @Override
    public void saveImprimanta(Imprimante imprimanta) {
        imprimante.add(imprimanta);
    }

    @Override
    public void getByStatus() {
        List<Imprimante> imprimanteDisponibile = imprimante.stream()
                .filter((impr -> impr.getStatus().equals("disponibila")))
                .collect(Collectors.toList());

        System.out.println(imprimanteDisponibile);
    }

    @Override
    public Filament getByTip(String tip) {
        List<Filament> filById = filamente.stream()
                .filter((fil -> fil.getTip().equals(tip)))
                .collect(Collectors.toList());

        return filById.get(0);
    }

    @Override
    public void modificareStatus(String nume) {
        for (int i = 0; i < imprimante.size(); i++) {
            if (imprimante.get(i).getNume().equals(nume))
                if (imprimante.get(i).getStatus().equals("ocupata")){
                    imprimante.get(i).setStatus("disponibila");
                }
            else {
                    imprimante.get(i).setStatus("ocupata");
                }
        }
    }


}
