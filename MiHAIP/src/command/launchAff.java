package command;

import nmdp.Configure;
import util.Executor;
import util.FileHelp;

public class launchAff {
	public void run(){
		
		Executor executor = new Executor();
		//create command line
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("java -jar %s/aff.jar ", Configure.tool));
		sb.append(FileHelp.getChopMetaData());
		sb.append(" ");
		sb.append(FileHelp.getAffFile_A());
		
		executor.executeCommand(sb.toString());
		
		sb.setLength(0);
		sb.append(String.format("java -jar %s/aff.jar ", Configure.tool));
		sb.append(FileHelp.getChopMetaData());
		sb.append(" ");
		sb.append(FileHelp.getAffFile_B());
		
		executor.executeCommand(sb.toString());
		
		sb.setLength(0);
		sb.append(String.format("java -jar %s/aff.jar ", Configure.tool));
		sb.append(FileHelp.getChopMetaData());
		sb.append(" ");
		sb.append(FileHelp.getAffFile_C());
		
		executor.executeCommand(sb.toString());
		
		
		
	}
}
