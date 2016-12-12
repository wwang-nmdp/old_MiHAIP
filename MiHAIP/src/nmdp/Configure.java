package nmdp;

public class Configure {
	public static String inputD;
	public static String inputR;
	private static String pairID;
	private static String hla;
    public static String hla_a;
    public static String hla_b;
    public static String hla_c;
	public static String tool = "/home/wwang/Tools/";
    
    public static void setHLA(String hla) throws Exception{
    	String [] data = hla.split(",");
    	if(data.length != 3){
    		throw new Exception("HLA must include HLA-A, HLA-B and HLA-C");
    	}
    	for(String s : data){
    		if(s.charAt(0) == 'a' || s.charAt(0) == 'A' ){
    			hla_a = "HLA-" + s.toUpperCase();
    		}else if(s.charAt(0) == 'b' || s.charAt(0) == 'B'){
    			hla_b = "HLA-"+ s.toUpperCase();
    		}else{
    			hla_c = "HLA-"+ s.toUpperCase();
    		}
    	}
    }
    
    public static String removeComma(String s){
    	return s.replace(":", "");
    }
    
    public static String getPairID(){
    	return pairID;
    }
    
    public static void  setPairID(String id){
    	pairID = id;
    }
}
