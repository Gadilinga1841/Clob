package StoreBlob;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conn {
	
	public static Connection Sqlco() throws IOException,SQLException {
		
		Properties ps=null;
		FileInputStream fi=null;
		Connection con=null;
	
			fi=new FileInputStream("D:\\Java_apps\\Practise\\src\\StoreBlob\\logindts.txt");
			ps=new Properties();
			ps.load(fi);
			if(ps!=null) {
			con=DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("username"),ps.getProperty("pass"));
			}
		
		
		return con;
		
		
	}
	public static void cloRes(Connection c,Statement s) throws SQLException{
		
		
		if(s!=null) {
			s.close();
		}
		if(c!=null) {
			c.close();
		}
		
		
	}
	

}
