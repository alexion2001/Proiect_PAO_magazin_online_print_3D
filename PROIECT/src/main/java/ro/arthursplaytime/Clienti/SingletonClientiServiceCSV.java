package ro.arthursplaytime.Clienti;

import ro.arthursplaytime.Clienti.Clienti;
import ro.arthursplaytime.Clienti.ClientiService;
import ro.arthursplaytime.Clienti.ClientiServiceMemory;
import ro.arthursplaytime.Clienti.SingletonClientiServiceCSV;

import java.io.*;
import java.util.List;

public class SingletonClientiServiceCSV {

    private final File clientiFile;

    private static SingletonClientiServiceCSV singletonClientiServiceCSV = new SingletonClientiServiceCSV();
    public static SingletonClientiServiceCSV getInstance(){
        return singletonClientiServiceCSV;
    }


    public SingletonClientiServiceCSV() {

        this.clientiFile = new File("src/main/resources/clienti.csv");

        if(!clientiFile.exists()){
            try {
                clientiFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<Clienti> Clienti) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try
        {
            fileWriter = new FileWriter(clientiFile,false);
            bufferedWriter = new BufferedWriter(fileWriter);

            StringBuilder produs = new StringBuilder();
            for (int i = 0; i < Clienti.size(); i++) {
                produs.append(formatForCSV(Clienti.get(i)));
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

    public ClientiService getAllFromCSV() {
        ClientiService ClientiService = new ClientiServiceMemory();
        try{
            FileReader fileReader = new FileReader(clientiFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.lines()
                    .forEach(line -> ClientiService.save(getFromCSV(line)));

            return ClientiService;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private Clienti getFromCSV(String line){
        String[] values = line.split(",");
        Clienti client = new Clienti(Integer.parseInt(values[0]),values[1],values[2],values[3]);
        return client;
    }


    private  String formatForCSV(Clienti client){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(client.getId_client());
        stringBuilder.append(",");
        stringBuilder.append(client.getNume());
        stringBuilder.append(",");
        stringBuilder.append(client.getPrenume());
        stringBuilder.append(",");
        stringBuilder.append(client.getTelefon());
        stringBuilder.append("\n");

        return  stringBuilder.toString();


    }
}
