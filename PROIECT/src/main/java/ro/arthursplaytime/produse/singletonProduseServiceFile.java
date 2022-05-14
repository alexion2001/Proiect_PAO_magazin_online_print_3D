package ro.arthursplaytime.produse;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class singletonProduseServiceFile implements produseService {

    private final File produseFile;

    private static ro.arthursplaytime.produse.singletonProduseServiceFile singletonProduseServiceFile = new singletonProduseServiceFile();
    public static ro.arthursplaytime.produse.singletonProduseServiceFile getInstance(){
        return singletonProduseServiceFile;
    }


    public singletonProduseServiceFile() {

        this.produseFile = new File("src/main/resources/produse.csv");

        if(!produseFile.exists()){
            try {
                produseFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(produse produs) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try
        {
            fileWriter = new FileWriter(produseFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(formatForCSV(produs));
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

    @Override
    public List<produse> getAll() {
        return null;
    }

    @Override
    public produse getById(int id) {
        try{
            FileReader fileReader = new FileReader(produseFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Optional<produse> produsOptional = bufferedReader.lines()
                    .map(line -> getFromCSV(line))
                    .filter(produs ->produs.getId() == id)
                    .findFirst();

            if(produsOptional.isPresent()){
                return  produsOptional.get();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void modificarePret(int id, double pret) {
        try{
            FileReader fileReader = new FileReader(produseFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Optional<produse> produsOptional = bufferedReader.lines()
                    .map(line -> getFromCSV(line))
                    .filter(produs ->produs.getId() == id)
                    .findFirst();

            if(produsOptional.isPresent()){
                produsOptional.get().setPretVanzare(pret);
                produseService produseService = ro.arthursplaytime.produse.singletonProduseServiceFile.getInstance();
                produseService.save(produsOptional.get());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void exceptieId(int id) {
        if (0 < id){
            throw new produseException();
        }
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
