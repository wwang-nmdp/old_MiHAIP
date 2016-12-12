package analysis;

import util.FileHelp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wwang on 10/23/16.
 */
public class ProcessAff {
    ArrayList<String> header = new ArrayList<>();
    Scanner sn;
    PrintWriter pw;
    public void run(File meta, File aff){
        try {
            sn = new Scanner(aff);
            File predictFile = new File(FileHelp.getPredictPath()+getFileName(aff)+".txt");
            pw = new PrintWriter(predictFile);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find aff file");
            e.printStackTrace();
            return;
        }
        loadMetaData(meta);
        for(int i = 0; i< header.size(); i++){
            pw.print(header.get(i));
            String data = findData();
            if(data.isEmpty()){
                break;
            }else {
                String[] dataList = data.split("\\s+");

                //print HLA
                pw.print(dataList[2]);
                pw.print(",");
                //print peptide
                pw.print(dataList[10]);
                pw.print(",");
                //print identifier
                pw.print(dataList[11]);
                pw.print(",");
                //print score
                pw.print(dataList[12]);
                pw.print(",");
                //print aff(nM)
                pw.print(dataList[13]);
                pw.print(",");
                //print rank
                pw.print(dataList[14]);
                pw.println(",");

            }
        }
        sn.close();
        pw.close();
        header.clear();
    }

    private String getFileName(File aff){
        String [] names = aff.getName().split("\\.");
        return names[0];

    }

    private String findData() {
        while(sn.hasNext()){
            String line = sn.nextLine();
            if(line.startsWith("  Pos          HLA")){
                break;
            }else {
                continue;
            }
        }
        if(sn.hasNext()){
            //jump the dash line
            sn.nextLine();
            return sn.nextLine();
        }else {
            return "";
        }
    }

    private void loadMetaData(File meta) {
        Scanner sn = null;
        try {
            sn = new Scanner(meta);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find meta file");
            e.printStackTrace();
            return;
        }
        if(sn != null){
            while(sn.hasNext()){
                header.add(sn.nextLine());
            }
            sn.close();
        }

    }
}
