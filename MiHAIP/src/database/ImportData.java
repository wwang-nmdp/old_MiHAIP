package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by wwang on 9/5/16.
 */
public class ImportData {
    public static void main(String[] args){
        DatabaseUtil.connectDatabase();
        DatabaseUtil.createSeqTable();
        Scanner sn = null;
        try {
             sn = new Scanner(new File("Homo_sapiens.GRCh38.cds.all.fa"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(sn != null){
            String id = "";
            String seq = "";
            while(sn.hasNext()){
                String line = sn.nextLine();
                if(line.startsWith(">")){
                    if(!id.isEmpty()){
                        DatabaseUtil.insertSeqData(id, seq);
                        seq = "";
                    }
                    int index = 1;
                    while(line.charAt(index) != ' '){
                        index ++;
                    }
                    id = line.substring(1, index);
                }else{
                    seq += line;
                }
            }

            //insert the last seq
            DatabaseUtil.insertSeqData(id, seq);
        }
        DatabaseUtil.cleanUp();
    }
}
