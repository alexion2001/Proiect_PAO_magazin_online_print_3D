package ro.arthursplaytime.gui.tehnologii;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class tehnologiiServiceMemory implements tehnologiiService {

    List<ro.arthursplaytime.gui.tehnologii.imprimante> imprimante = new ArrayList<>();
    Set<filament> filamente = new HashSet<filament>();


    @Override
    public void saveFilament(filament filament) {
        filamente.add(filament);
    }

    @Override
    public void saveImprimanta(ro.arthursplaytime.gui.tehnologii.imprimante imprimanta) {
        imprimante.add(imprimanta);
    }

    @Override
    public void getByStatus() {
        List<ro.arthursplaytime.gui.tehnologii.imprimante> imprimanteDisponibile = imprimante.stream()
                .filter((impr -> impr.getStatus().equals("disponibila")))
                .collect(Collectors.toList());

        System.out.println(imprimanteDisponibile);
    }

    @Override
    public filament getByTip(String tip) {
        List<filament> filById = filamente.stream()
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


    @Override
    public List<ro.arthursplaytime.gui.tehnologii.imprimante> getAll() {
        return imprimante;
    }


}
