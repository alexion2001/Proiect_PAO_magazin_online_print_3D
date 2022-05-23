package ro.arthursplaytime.gui.clienti;

import java.io.*;
import java.util.List;

public class singletonClientiServiceCSV {

    private final File clientiFile;
    static ro.arthursplaytime.gui.clienti.singletonClientiServiceCSV singletonClientiServiceCSV = null;

    public static ro.arthursplaytime.gui.clienti.singletonClientiServiceCSV getInstance(){
        if (singletonClientiServiceCSV == null)
           singletonClientiServiceCSV = new singletonClientiServiceCSV();
        return singletonClientiServiceCSV;
    }


    private singletonClientiServiceCSV() {

        this.clientiFile = new File("src/main/resources/clienti.csv");

        if(!clientiFile.exists()){
            try {
                clientiFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveInCSV(List<clienti> Clienti) {
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

    public clientiService getAllFromCSV() {
        clientiService ClientiService = new clientiServiceMemory();
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

    private clienti getFromCSV(String line){
        String[] values = line.split(",");
        clienti client = new clienti(Integer.parseInt(values[0]),values[1],values[2],values[3]);
        return client;
    }


    private  String formatForCSV(clienti client){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(client.getIdClient());
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
