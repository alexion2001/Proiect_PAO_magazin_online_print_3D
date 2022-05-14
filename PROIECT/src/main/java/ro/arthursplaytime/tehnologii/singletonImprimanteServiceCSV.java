package ro.arthursplaytime.tehnologii;

import ro.arthursplaytime.clienti.singletonClientiServiceCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class singletonImprimanteServiceCSV {

    private final File imprimanteFile;


    static ro.arthursplaytime.tehnologii.singletonImprimanteServiceCSV singletonImprimanteServiceCSV = null;

    public static ro.arthursplaytime.tehnologii.singletonImprimanteServiceCSV getInstance(){
        if (singletonImprimanteServiceCSV == null)
            singletonImprimanteServiceCSV = new singletonImprimanteServiceCSV();
        return singletonImprimanteServiceCSV;
    }


    private singletonImprimanteServiceCSV() {

        this.imprimanteFile = new File("src/main/resources/Imprimante.csv");

        if(!imprimanteFile.exists()){
            try {
                imprimanteFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<imprimante> Imprimante) {
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

    public tehnologiiService getAllFromCSV() {
        tehnologiiService tehnologiiService = new tehnologiiServiceMemory();
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

    private imprimante getFromCSV(String line){
        String[] values = line.split(",");


        //completeaza in fct de constructor
        List<filament> filament = new ArrayList<>();
        for (int i = 1; i < values.length - 3; i = i + 3) {

            ro.arthursplaytime.tehnologii.filament fil = new filament(values[i],Integer.parseInt(values[i+1]),values[i+2]);
            filament.add(fil);
        }

        imprimante impr= new imprimante(values[0],filament,Double.parseDouble(values[2]),Double.parseDouble(values[values.length - 3]),Double.parseDouble(values[values.length - 2]),values[values.length - 1]);
        return impr;
    }



    private  String formatForCSV(imprimante impr){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(impr.getNume());

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < impr.getFilamenteCompatibile().size(); i++) {
            stringBuilder2.append(",");
            stringBuilder2.append(impr.getFilamenteCompatibile().get(i).getTip());
            stringBuilder2.append(",");
            stringBuilder2.append(impr.getFilamenteCompatibile().get(i).getTemperaturaTopire());
            stringBuilder2.append(",");
            stringBuilder2.append(impr.getFilamenteCompatibile().get(i).getCuloare());

        }

        stringBuilder.append(stringBuilder2);

        stringBuilder.append(impr.getDimensiunePat().get("lungime"));
        stringBuilder.append(",");
        stringBuilder.append(impr.getDimensiunePat().get("latime"));
        stringBuilder.append(",");
        stringBuilder.append(impr.getDimensiunePat().get("inaltime"));
        stringBuilder.append(",");
        stringBuilder.append(impr.getStatus());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }
}
