package br.com.cardif.databaseutils.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import br.com.cardif.databaseutils.DatabaseName;

public class DatabaseUtils {
	
	public static String searchOneLineOneColumn(String sql, DatabaseName base) throws Exception {
		try {
			Connection conn = getConnection(base);
			ResultSet rs = executeQuery(sql, conn);			
			String retorno = readOneLineOneColumn(rs);
			closeConnection(conn);
			
			return retorno;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static String [] searchOneLineTwoColumns(String sql, DatabaseName base) throws Exception {
		try {
			Connection conn = getConnection(base);
			ResultSet rs = executeQuery(sql, conn);			
			String [] retorno = readOneLineTwoColumn(rs);
			closeConnection(conn);
			
			return retorno;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private static Connection getConnection(DatabaseName base) throws Exception {
		
		try {
			String alias = null;
			String name = null;

			if (base == DatabaseName.CARDIF) {
				alias = String.valueOf(DatabaseName.CARDIF);
				name = DatabaseName.CARDIF.getName();
			} else if  (base == DatabaseName.GARANTIAS) {
				alias = String.valueOf(DatabaseName.GARANTIAS);
				name = DatabaseName.GARANTIAS.getName();
			} else if  (base == DatabaseName.LUIZA) {
				alias = String.valueOf(DatabaseName.LUIZA);
				name = DatabaseName.LUIZA.getName();
			} else {
				alias = String.valueOf(DatabaseName.BVP);
				name = DatabaseName.BVP.getName();
			}
			
			alias = alias.toLowerCase();
			
			Properties p = readProperties();
			String url = p.getProperty("url." + alias);
			String user = p.getProperty("usuario." + alias);
			String pass = p.getProperty("senha." + alias);
			
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	private static void closeConnection(Connection conn) throws SQLException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private static ResultSet executeQuery(String sql, Connection conn) throws Exception {
		try {
			Statement st = conn.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			throw new Exception(e);
		}
		
	}
	
	private static String readOneLineOneColumn(ResultSet rs) throws Exception {
		try {
			String result = null;
			while(rs.next()) {
				int r = rs.getInt(1);
				result = String.valueOf(r);
			}
			
			return result;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	private static String [] readOneLineTwoColumn(ResultSet rs) throws Exception {
		try {
			String [] result = null;
			while(rs.next()) {
				result = new String[2];
				
				int r = rs.getInt(1);
				result [0] = String.valueOf(r);
				result [1] = rs.getString(2);
			}
			
			return result;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	private static Properties readProperties() throws Exception {
		try {
			InputStream input = DatabaseUtils.class.getClassLoader().getResourceAsStream("connection.properties");
			
			Properties p = new Properties();
			p.load(input);
			
			return p;
		} catch (FileNotFoundException fe) {
			throw new Exception(fe);
		} catch (IOException ie) {
			throw new Exception(ie);
		}
	}
	
}
