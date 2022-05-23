package ro.arthursplaytime.gui.produse;

import java.io.*;
import java.util.List;

public class singletonProduseServiceCSV {

    private final File produseFile;

    static ro.arthursplaytime.gui.produse.singletonProduseServiceCSV singletonProduseServiceCSV = null;

    public static ro.arthursplaytime.gui.produse.singletonProduseServiceCSV getInstance(){
        if (singletonProduseServiceCSV == null)
            singletonProduseServiceCSV = new singletonProduseServiceCSV();
        return singletonProduseServiceCSV;
    }


    private singletonProduseServiceCSV() {

        this.produseFile = new File("src/main/resources/produse.csv");

        if(!produseFile.exists()){
            try {
                produseFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<produse> produse) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try
        {
            fileWriter = new FileWriter(produseFile,false);
            bufferedWriter = new BufferedWriter(fileWriter);

            StringBuilder produs = new StringBuilder();
            for (int i = 0; i < produse.size(); i++) {
                produs.append(formatForCSV(produse.get(i)));
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

    public produseService getAllFromCSV() {
        produseService produseService = new produseServiceMemory();
        try{
            FileReader fileReader = new FileReader(produseFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.lines()
                    .forEach(line -> produseService.save(getFromCSV(line)));

            return produseService;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private produse getFromCSV(String line){
        String[] values = line.split(",");
        produse produs = new produse(Integer.parseInt(values[0]),values[1],values[4],Double.parseDouble(values[2]),Double.parseDouble(values[3]));
        return produs;
    }


    private  String formatForCSV(produse produs){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(produs.getId());
        stringBuilder.append(",");
        stringBuilder.append(produs.getNume());
        stringBuilder.append(",");
        stringBuilder.append(produs.getCostProductie());
        stringBuilder.append(",");
        stringBuilder.append(produs.getPretVanzare());
        stringBuilder.append(",");
        stringBuilder.append(produs.getTipFilament());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }

}
