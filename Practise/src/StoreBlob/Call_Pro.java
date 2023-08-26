package StoreBlob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;



public class Call_Pro {
	public static void main(String...a) {
		System.out.println("before establishing connection");
		Connection connection =null;
		CallableStatement cs=null;
		try {
			connection=Conn.Sqlco();
	    if(connection!=null) {
	      cs=connection.prepareCall("{call P_GET_PRODUCT_DETAILS_BY_ID(?,?,?,?)}");
	    }
	    if(cs!=null) {
	       cs.setInt(1,1);
	    }
	    if(cs!=null) {
	    	cs.registerOutParameter(2, Types.VARCHAR);
	    	cs.registerOutParameter(3, Types.INTEGER);
	    	cs.registerOutParameter(4, Types.INTEGER);
	    }
	    if(cs!=null) {
	    	cs.execute();
	    System.out.println(cs.getString(2));	
	    System.out.println(cs.getInt(3));
	    System.out.println(cs.getInt(4));
	    }
	    
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
				e.printStackTrace();
		}
		finally {
			try {
				Conn.cloRes(connection, cs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}