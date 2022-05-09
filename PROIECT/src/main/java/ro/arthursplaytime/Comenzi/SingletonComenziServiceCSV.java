package ro.arthursplaytime.Comenzi;

import ro.arthursplaytime.Comenzi.Comenzi;
import ro.arthursplaytime.Comenzi.ComenziService;
import ro.arthursplaytime.Comenzi.ComenziServiceMemory;
import ro.arthursplaytime.Comenzi.SingletonComenziServiceCSV;
import ro.arthursplaytime.Produse.Produse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonComenziServiceCSV {

    private final File comenziFile;

    private static SingletonComenziServiceCSV singletonComenziServiceCSV = new SingletonComenziServiceCSV();
    public static SingletonComenziServiceCSV getInstance(){
        return singletonComenziServiceCSV;
    }


    public SingletonComenziServiceCSV() {

        this.comenziFile = new File("src/main/resources/Comenzi.csv");

        if(!comenziFile.exists()){
            try {
                comenziFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<Comenzi> comenzi) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try
        {

            fileWriter = new FileWriter(comenziFile,false);
            bufferedWriter = new BufferedWriter(fileWriter);

            StringBuilder comanda = new StringBuilder();
            for (int i = 0; i < comenzi.size(); i++) {
                comanda.append(formatForCSV(comenzi.get(i)));
            }

            bufferedWriter.write(String.valueOf(comanda));
            bufferedWriter.close();

        }catch (Exception e){

        } finally {

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public ComenziService getAllFromCSV() {
        ComenziService comenziService = new ComenziServiceMemory();
        try{
            FileReader fileReader = new FileReader(comenziFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.lines()
                    .forEach(line -> comenziService.save(getFromCSV(line)));

            return comenziService;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private Comenzi getFromCSV(String line){
        String[] values = line.split(",");

        List<Produse> produse = new ArrayList<>();

        //citesc valorile din csv, le transform in produse si le adaug la comanda
        for (int i = 3; i < values.length - 1; i = i + 5) {

            Produse produs = new Produse(Integer.parseInt(values[i]),values[i+1],values[i+2],Double.parseDouble(values[i+3]),Double.parseDouble(values[i+4]));
            produse.add(produs);
        }


        Comenzi comanda = new Comenzi(Integer.parseInt(values[0]),Integer.parseInt(values[1]),values[2],produse,values[values.length - 1]);
        return comanda;
    }


    private  String formatForCSV(Comenzi comanda){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(comanda.getId_client());
        stringBuilder.append(",");
        stringBuilder.append(comanda.getId_angajat());
        stringBuilder.append(",");
        stringBuilder.append(comanda.getData());

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < comanda.getProduse().size(); i++) {
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getId());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getNume());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getTip_filament());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getCost_productie());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getPret_vanzare());


        }

        stringBuilder.append(stringBuilder2);
        stringBuilder.append(",");
        stringBuilder.append(comanda.getStatus());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }

}
