package ro.arthursplaytime.Produse;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class SingletonProduseServiceFile implements ProduseService{

    private final File produseFile;

    private static SingletonProduseServiceFile singletonProduseServiceFile = new SingletonProduseServiceFile();
    public static SingletonProduseServiceFile getInstance(){
        return singletonProduseServiceFile;
    }


    public SingletonProduseServiceFile() {

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
    public void save(Produse produs) {
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
    public List<Produse> getAll() {
        return null;
    }

    @Override
    public Produse getById(int id) {
        try{
            FileReader fileReader = new FileReader(produseFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Optional<Produse> produsOptional = bufferedReader.lines()
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

            Optional<Produse> produsOptional = bufferedReader.lines()
                    .map(line -> getFromCSV(line))
                    .filter(produs ->produs.getId() == id)
                    .findFirst();

            if(produsOptional.isPresent()){
                produsOptional.get().setPret_vanzare(pret);
                ProduseService produseService = SingletonProduseServiceFile.getInstance();
                produseService.save(produsOptional.get());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void exceptieId(int id) {
        if (0 < id){
            throw new ProduseException();
        }
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
