package database;


import java.sql.*;


public class DatabaseUtil
{
	static final String DATA_BASE_NAME = "cds";
	static final String TABLE_NAME = "cds_sequence";

	static final String ID = "ID";
	static final String TANSCRIPT_ID = "TRANSCRIPT_ID";
	static final String SEQUENCE = "SEQ";




	static Connection connection;

	public static void connectDatabase(){
		connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection= DriverManager.getConnection("jdbc:sqlite:"+DATA_BASE_NAME+".db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	public static void createSeqTable(){
		try {
			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
					+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ TANSCRIPT_ID+" CHAR(50) NOT NULL,"
					+SEQUENCE+" TEXT NOT NULL,"
					+"UNIQUE ("+TANSCRIPT_ID+ ")"
					+");";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Create cds table successfully");
	}

	public static void insertSeqData(String id, String seq)  {
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("connection is broken. fail to insert " + id);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO "+ TABLE_NAME);
		sb.append("(");
		sb.append(TANSCRIPT_ID + ",");
		sb.append(SEQUENCE + ")");
		sb.append("VALUES (");
		sb.append(wrapString(id)+ ",");
		sb.append(wrapString(seq));
		sb.append(");");
		try {
			stmt.executeUpdate(sb.toString());
			stmt.close();
		} catch (SQLException e) {
			System.out.println("fail to insert duplicate data" + id);
		}

	}

	public static String getSequence(String id){
		Statement stmt = null;
		String seq = "";
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("connection is broken. fail to insert " + id);
		}
		String sql = "SELECT " +SEQUENCE + " FROM " + TABLE_NAME +" WHERE " + TANSCRIPT_ID + " = "+ wrapString(id);
		try {
			ResultSet rs = connection.createStatement().executeQuery(sql);
			if(rs.next()){
				seq = rs.getString(SEQUENCE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  seq;
	}

	public static void cleanUp(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection closed.");
	}

	private static  String wrapString(String str){
		return "'" +str+ "'";
	}
}
