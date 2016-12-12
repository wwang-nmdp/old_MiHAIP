package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import nmdp.Configure;
import util.Executor;
import util.FileHelp;

public class Cleavage {
	public void run(){
		//create command line
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s/netchop-3.1/bin/netChop -s ", Configure.tool));
		sb.append(FileHelp.getMergeOutput());
		try {
			CommandHelper.runAndSave(sb.toString(), FileHelp.getCleavageFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
