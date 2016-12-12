package nmdp;




import org.xml.sax.SAXException;

import command.Chop;
import command.Cleavage;
import command.Compare;
import command.Filter;
import command.Merge;
import command.NetMHCpan;
import command.SnpEff;
import command.launchAff;
import command.test;
import util.FileHelp;

import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.HashMap;

public class Launcher {
    private static final String INPUT_D = "-d";
    private static final String INPUT_R = "-r";
    private static final String PID = "-pid";
    private static final String HLA ="-hla";
    private static final String TOOL_FOLDER = "-t";
   
   
    private static HashMap<String, String> paranMpa = new HashMap<>();

    public static void main(String[] args) throws URISyntaxException {
        
        try{
            getParameters(args);
        }catch (IndexOutOfBoundsException e){
            System.out.println("parameter is missing. program stopped");
            return;
        }
        
        Configure.inputD = paranMpa.get(INPUT_D);
        Configure.inputR = paranMpa.get(INPUT_R);
        Configure.setPairID(paranMpa.get(PID));
        if(paranMpa.containsKey(TOOL_FOLDER)){
        	 Configure.tool = paranMpa.get(TOOL_FOLDER);
        }
      
        try {
			Configure.setHLA(paranMpa.get(HLA));
		} catch (Exception e) {
			System.out.println("HLA is not set up properly.");
			return;
		}
        new Compare().run();
        new SnpEff().run();
        new Filter().run();
        new Merge().run();
        new Cleavage().run();
        new Chop().run();
        new NetMHCpan().run();
        new launchAff().run();
    }



    private static void getParameters(String[] args) {
        //get input d
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(INPUT_D)) {
                paranMpa.put(INPUT_D, args[i+1]);
                break;
            }
        }
        //get input r
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(INPUT_R)) {
                paranMpa.put(INPUT_R, args[i+1]);
                break;
            }
        }

        //get pid
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(PID)) {
                paranMpa.put(PID, args[i+1]);
                break;
            }
        }
        
      //get hla
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(HLA)) {
                paranMpa.put(HLA, args[i+1]);
                break;
            }
        }
        
      //get tool folder 
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(TOOL_FOLDER)) {
                paranMpa.put(TOOL_FOLDER, args[i+1]);
                break;
            }
        }
        
    }

}
