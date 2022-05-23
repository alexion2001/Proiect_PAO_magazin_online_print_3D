package ro.arthursplaytime.gui.comenzi;

import ro.arthursplaytime.gui.produse.produse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class singletonComenziServiceCSV {

    private final File comenziFile;

    static ro.arthursplaytime.gui.comenzi.singletonComenziServiceCSV singletonComenziServiceCSV = null;

    public static ro.arthursplaytime.gui.comenzi.singletonComenziServiceCSV getInstance(){
        if (singletonComenziServiceCSV == null)
            singletonComenziServiceCSV = new singletonComenziServiceCSV();
        return singletonComenziServiceCSV;
    }


    private singletonComenziServiceCSV() {

        this.comenziFile = new File("src/main/resources/comenzi.csv");

        if(!comenziFile.exists()){
            try {
                comenziFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<comenzi> comenzi) {
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

    public comenziService getAllFromCSV() {
        comenziService comenziService = new comenziServiceMemory();
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

    private comenzi getFromCSV(String line){
        String[] values = line.split(",");

        List<produse> produse = new ArrayList<>();

        //citesc valorile din csv, le transform in produse si le adaug la comanda
        for (int i = 3; i < values.length - 1; i = i + 5) {

            ro.arthursplaytime.gui.produse.produse produs = new produse(Integer.parseInt(values[i]),values[i+1],values[i+2],Double.parseDouble(values[i+3]),Double.parseDouble(values[i+4]));
            produse.add(produs);
        }


        comenzi comanda = new comenzi(Integer.parseInt(values[0]),Integer.parseInt(values[1]),values[2],produse,values[values.length - 1]);
        return comanda;
    }


    private  String formatForCSV(comenzi comanda){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(comanda.getIdClient());
        stringBuilder.append(",");
        stringBuilder.append(comanda.getIdAngajat());
        stringBuilder.append(",");
        stringBuilder.append(comanda.getData());

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < comanda.getProduse().size(); i++) {
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getId());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getNume());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getTipFilament());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getCostProductie());
            stringBuilder2.append(",");
            stringBuilder2.append(comanda.getProduse().get(i).getPretVanzare());


        }

        stringBuilder.append(stringBuilder2);
        stringBuilder.append(",");
        stringBuilder.append(comanda.getStatus());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }

}
