package ro.arthursplaytime.Comenzi;
import java.util.*;

import ro.arthursplaytime.Clienti.Clienti;
import ro.arthursplaytime.Produse.Produse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComenziServiceMemory implements ComenziService {

    SortedMap<Integer,Comenzi> comenzi = new TreeMap<Integer, Comenzi>();


    @Override
    public void save(Comenzi comanda) {
        comenzi.put(comanda.getId_client(), comanda);
    }

    @Override
    public List<Comenzi> getByIdClient(int id) {
        //int key = (int)mapElement.getKey();
        //String value = (String)mapElement.getValue();
        //for (Map.Entry<String, Integer> pair : map.entrySet()) {
        //    System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
        //}

//        List<Entry<Integer, Comenzi>> comenziById = comenzi.values()
//                .filter((comanda -> comanda.getId_client() == id))
//                .collect(Collectors.toList());


        List<Comenzi> comenziById = new ArrayList<>();
        for (Map.Entry<Integer,Comenzi> pair : comenzi.entrySet()) {
            if(pair.getKey() == id){
                comenziById.add(pair.getValue());
            }

        }

        return comenziById;
    }

    @Override
    public List<Comenzi> getByData(String data) {
        List<Comenzi>  comenziByData = new ArrayList<>();
        for (Map.Entry<Integer,Comenzi> pair : comenzi.entrySet()) {
            if(pair.getValue().getData() == data){
                comenziByData.add(pair.getValue());
            }

        }
        return comenziByData;
    }

    @Override
    public void modificareStatus(int id_client, String data) {
        for (int i = 0; i < comenzi.size(); i++) {
            if (comenzi.get(i).getData().equals(data) && comenzi.get(i).getId_client() == id_client)
                    comenzi.get(i).setStatus("trimisa");

        }
    }
}
