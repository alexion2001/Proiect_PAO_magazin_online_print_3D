package ro.arthursplaytime.gui.comenzi;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class comenziServiceMemory implements comenziService {

    SortedMap<Integer, ro.arthursplaytime.gui.comenzi.comenzi> comenzi = new TreeMap<Integer, ro.arthursplaytime.gui.comenzi.comenzi>();

    @Override
    public List<ro.arthursplaytime.gui.comenzi.comenzi> getAll() {

        return comenzi.values().stream().toList();
    }

    @Override
    public void save(ro.arthursplaytime.gui.comenzi.comenzi comanda) {
        comenzi.put(comanda.getIdClient(), comanda);
    }

    @Override
    public List<ro.arthursplaytime.gui.comenzi.comenzi> getByIdClient(int id) {
        //int key = (int)mapElement.getKey();
        //String value = (String)mapElement.getValue();
        //for (Map.Entry<String, Integer> pair : map.entrySet()) {
        //    System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
        //}

//        List<Entry<Integer, comenzi>> comenziById = comenzi.values()
//                .filter((comanda -> comanda.getId_client() == id))
//                .collect(Collectors.toList());


        List<ro.arthursplaytime.gui.comenzi.comenzi> comenziById = new ArrayList<>();
        for (Map.Entry<Integer, ro.arthursplaytime.gui.comenzi.comenzi> pair : comenzi.entrySet()) {
            if(pair.getKey() == id){
                comenziById.add(pair.getValue());
            }

        }

        return comenziById;
    }

    @Override
    public List<ro.arthursplaytime.gui.comenzi.comenzi> getByData(String data) {
        List<ro.arthursplaytime.gui.comenzi.comenzi>  comenziByData = new ArrayList<>();
        for (Map.Entry<Integer, ro.arthursplaytime.gui.comenzi.comenzi> pair : comenzi.entrySet()) {
            if(pair.getValue().getData() == data){
                comenziByData.add(pair.getValue());
            }

        }
        return comenziByData;
    }

    @Override
    public void modificareStatus(int id_client, String data) {
        for (int i = 0; i < comenzi.size(); i++) {
            if (comenzi.get(i).getData().equals(data) && comenzi.get(i).getIdClient() == id_client)
                    comenzi.get(i).setStatus("trimisa");

        }
    }
}
