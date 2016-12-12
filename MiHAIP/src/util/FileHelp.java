package util;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

import nmdp.Configure;

/**
 * Created by wwang on 10/19/16.
 */
public class FileHelp {
    public static String getOutput() {
        return getRoot() + "./output/";
    }

    public static String getRoot() {
//        CodeSource codeSource = FileHelp.class.getProtectionDomain().getCodeSource();
//        File jarFile = new File(codeSource.getLocation().toURI().getPath());
//        String jarDir = jarFile.getParentFile().getPath();
        return "/home/wwang/MiHAIP/";
    }

    public static String getMetaFilePath()  {
        return getOutput() + "meta/";
    }

    public static String getChopFilePath() {
        return getRoot() + "Chopped/";
    }

    public static String getDNAfilePath() {
        return getOutput() + "DNA/";
    }

    public static String getProteinPath() {
        return getOutput() + "protein/";
    }
    
    public static void makeFolders(){
    	makeFolder(getOutput());
    	makeFolder(getMetaFilePath());
    	makeFolder(getChopFilePath());
    	makeFolder(getDNAfilePath());
    	makeFolder(getProteinPath());
    	makeFolder(getPredictPath());
    	makeFolder(getOutput() + "/annotated");
    	makeFolder(getOutput() + "/compared");
    	makeFolder(getOutput() + "/missense");
    	makeFolder(getOutput() + "/cleavaged");
    	makeFolder(getOutput() + "/chopMeta");
    	makeFolder(getOutput() + "/affinity");
    }

    private static void makeFolder(String name){
    	File folder = new File(name);
    	folder.mkdirs();
    }

    public static String getFnPath() throws URISyntaxException {
        return getRoot()+"./DtoR/msv/fn";
    }

    public static String getFpPath() throws URISyntaxException {
        return getRoot()+"./DtoR/msv/fp";
    }
    
    public static String getVcfevalPath(){
    	return getOutput() + "/compared/" +Configure.getPairID()+".out";
    }
    
    public static String getSnpeffInputFn(){
    	return getVcfevalPath() + "/fn.vcf.gz";
    }
    
    public static String getSnpeffInputFp(){
    	return getVcfevalPath() + "/fp.vcf.gz";
    }
    
    public static String getAnnotateOutputFn(){
    	return getOutput() + "/annotated/" + Configure.getPairID() + "_fn_ann.vcf";
    }
    
    public static String getAnnotateOutputFp(){
    	return getOutput() + "/annotated/" + Configure.getPairID() + "_fp_ann.vcf";
    }
    
    public static String getMissenseFn(){
    	return getOutput() + "/missense/" + Configure.getPairID() + "_fn_ann_msv.vcf";
    }
    public static String getMissenseFp(){
    	return getOutput() + "/missense/" + Configure.getPairID() + "_fp_ann_msv.vcf";
    }
    
    public static String getMergeOutput(){
    	return FileHelp.getProteinPath() + Configure.getPairID() + "_protien.fasta";
    }
    
    public static String getMetaData(){
    	return FileHelp.getMetaFilePath() + Configure.getPairID() + "_meta.txt";
    }
    
    public static String getCleavageFile(){
    	return getOutput() + "cleavaged/" + Configure.getPairID() + "_cleavaged.txt";
    }
    
    public static String getChopFile(){
    	return getOutput() + "chopped/" + Configure.getPairID() + "_chopped.txt";
    }
    
    public static String getChopMetaData(){
    	return getOutput() + "chopMeta/" + Configure.getPairID() + ".txt";
    }
    
    public static String getAffFile_A(){
    	return getOutput() + "affinity/" + Configure.getPairID() + "_"+ Configure.removeComma(Configure.hla_a) +"_aff.txt";
    }
    
    public static String getAffFile_B(){
    	return getOutput() + "affinity/" + Configure.getPairID() + "_"+ Configure.removeComma(Configure.hla_b) +"_aff.txt";
    }

    public static String getAffFile_C(){
    	return getOutput() + "affinity/" + Configure.getPairID() + "_"+ Configure.removeComma(Configure.hla_c) +"_aff.txt";

    }

	public static String getPredictPath() {
		return getOutput() + "predicted/";
	}
}
