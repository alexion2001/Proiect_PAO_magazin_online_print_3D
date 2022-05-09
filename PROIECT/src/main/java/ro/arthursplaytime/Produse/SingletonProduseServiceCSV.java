package ro.arthursplaytime.Produse;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class SingletonProduseServiceCSV{

    private final File produseFile;

    private static SingletonProduseServiceCSV singletonProduseServiceCSV = new SingletonProduseServiceCSV();
    public static SingletonProduseServiceCSV getInstance(){
        return singletonProduseServiceCSV;
    }


    public SingletonProduseServiceCSV() {

        this.produseFile = new File("src/main/resources/produse.csv");

        if(!produseFile.exists()){
            try {
                produseFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<Produse> produse) {
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

    public ProduseService getAllFromCSV() {
        ProduseService produseService = new ProduseServiceMemory();
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

    private Produse getFromCSV(String line){
        String[] values = line.split(",");
        Produse produs = new Produse(Integer.parseInt(values[0]),values[1],values[4],Double.parseDouble(values[2]),Double.parseDouble(values[3]));
        return produs;
    }


    private  String formatForCSV(Produse produs){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(produs.getId());
        stringBuilder.append(",");
        stringBuilder.append(produs.getNume());
        stringBuilder.append(",");
        stringBuilder.append(produs.getCost_productie());
        stringBuilder.append(",");
        stringBuilder.append(produs.getPret_vanzare());
        stringBuilder.append(",");
        stringBuilder.append(produs.getTip_filament());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }

}
