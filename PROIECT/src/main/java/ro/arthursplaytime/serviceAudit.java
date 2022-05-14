package ro.arthursplaytime;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class serviceAudit {

        private final File auditFile;

        private static ro.arthursplaytime.serviceAudit serviceAudit = new serviceAudit();
        public static ro.arthursplaytime.serviceAudit getInstance(){
            return serviceAudit;
        }


    public serviceAudit() {

            this.auditFile = new File("src/main/resources/audit.csv");

            if(!auditFile.exists()){
                try {
                    auditFile.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        public void save(String comanda) {
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;

            try
            {   Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(comanda);
                stringBuilder.append(",");
                stringBuilder.append(timestamp);
                stringBuilder.append("\n");

                fileWriter = new FileWriter(auditFile, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(String.valueOf(stringBuilder));
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
}
