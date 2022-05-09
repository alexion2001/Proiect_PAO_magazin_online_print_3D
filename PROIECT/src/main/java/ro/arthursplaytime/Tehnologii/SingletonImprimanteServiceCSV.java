package ro.arthursplaytime.Tehnologii;

import ro.arthursplaytime.Produse.Produse;
import ro.arthursplaytime.Tehnologii.Imprimante;
import ro.arthursplaytime.Tehnologii.TehnologiiService;
import ro.arthursplaytime.Tehnologii.TehnologiiServiceMemory;
import ro.arthursplaytime.Tehnologii.SingletonImprimanteServiceCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SingletonImprimanteServiceCSV {

    private final File imprimanteFile;

    private static SingletonImprimanteServiceCSV singletonImprimanteServiceCSV = new SingletonImprimanteServiceCSV();
    public static SingletonImprimanteServiceCSV getInstance(){
        return singletonImprimanteServiceCSV;
    }


    public SingletonImprimanteServiceCSV() {

        this.imprimanteFile = new File("src/main/resources/Imprimante.csv");

        if(!imprimanteFile.exists()){
            try {
                imprimanteFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<Imprimante> Imprimante) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try
        {
            fileWriter = new FileWriter(imprimanteFile,false);
            bufferedWriter = new BufferedWriter(fileWriter);

            StringBuilder produs = new StringBuilder();
            for (int i = 0; i < Imprimante.size(); i++) {
                produs.append(formatForCSV(Imprimante.get(i)));
            }

            bufferedWriter.write(produs.toString());
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

    public TehnologiiService getAllFromCSV() {
        TehnologiiService tehnologiiService = new TehnologiiServiceMemory();
        try{
            FileReader fileReader = new FileReader(imprimanteFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.lines()
                    .forEach(line -> tehnologiiService.saveImprimanta(getFromCSV(line)));

            return tehnologiiService;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private Imprimante getFromCSV(String line){
        String[] values = line.split(",");


        //completeaza in fct de constructor
        List<Filament> filament = new ArrayList<>();
        for (int i = 1; i < values.length - 3; i = i + 3) {

            Filament fil = new Filament(values[i],Integer.parseInt(values[i+1]),values[i+2]);
            filament.add(fil);
        }

        Imprimante impr= new Imprimante(values[0],filament,Double.parseDouble(values[2]),Double.parseDouble(values[values.length - 3]),Double.parseDouble(values[values.length - 2]),values[values.length - 1]);
        return impr;
    }



    private  String formatForCSV(Imprimante impr){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(impr.getNume());

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < impr.getFilamente_compatibile().size(); i++) {
            stringBuilder2.append(",");
            stringBuilder2.append(impr.getFilamente_compatibile().get(i).getTip());
            stringBuilder2.append(",");
            stringBuilder2.append(impr.getFilamente_compatibile().get(i).getTemperatura_topire());
            stringBuilder2.append(",");
            stringBuilder2.append(impr.getFilamente_compatibile().get(i).getCuloare());

        }

        stringBuilder.append(stringBuilder2);

        stringBuilder.append(impr.getDimensiune_pat().get("lungime"));
        stringBuilder.append(",");
        stringBuilder.append(impr.getDimensiune_pat().get("latime"));
        stringBuilder.append(",");
        stringBuilder.append(impr.getDimensiune_pat().get("inaltime"));
        stringBuilder.append(",");
        stringBuilder.append(impr.getStatus());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }
}
