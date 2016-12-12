package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import nmdp.Configure;
import util.Executor;
import util.FileHelp;

public class NetMHCpan {
	public void run(){
		//create command line
		StringBuilder sb = new StringBuilder();
		sb.append("#!/bin/bash\n");
		sb.append(String.format("%s/netMHCpan-3.0/netMHCpan -a ", Configure.tool));
		sb.append(Configure.hla_a);
		sb.append(" ");
		sb.append(FileHelp.getChopFile());
		sb.append(" > ");
		sb.append(FileHelp.getAffFile_A());
		sb.append(" &\n");
		
		sb.append(String.format("%s/netMHCpan-3.0/netMHCpan -a ", Configure.tool));
		sb.append(Configure.hla_b);
		sb.append(" ");
		sb.append(FileHelp.getChopFile());
		sb.append(" > ");
		sb.append(FileHelp.getAffFile_B());
		sb.append(" &\n");
		
		sb.append(String.format("%s/netMHCpan-3.0/netMHCpan -a ", Configure.tool));
		sb.append(Configure.hla_c);
		sb.append(" ");
		sb.append(FileHelp.getChopFile());
		sb.append(" > ");
		sb.append(FileHelp.getAffFile_C());
		sb.append(" &\nwait");
		
		System.out.println(sb.toString());
		
		try {
			 File tempScript = File.createTempFile("script", null);
	         Writer streamWriter;
			streamWriter = new OutputStreamWriter(new FileOutputStream(
			            tempScript));
			PrintWriter printWriter = new PrintWriter(streamWriter);
			printWriter.print(sb.toString());
			printWriter.close();
			CommandHelper.runBash(tempScript);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
