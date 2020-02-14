package br.com.cardif.databaseutils.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import br.com.cardif.databaseutils.DatabaseName;

public class DatabaseUtils {
	
	public static String searchOneLineOneColumn(String sql, DatabaseName base) throws Exception {
		try {			
			return searchOneLineOneColumn(sql, null, null, base);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static String searchOneLineOneColumn(String sql, String certificate, String mp, DatabaseName base) throws Exception {
		try {
			Connection conn = getConnection(base);
			sql = appendCertificateMasterPolicy(sql, certificate, mp);
			ResultSet rs = executeQuery(sql, conn);
			String retorno = readOneLineOneColumn(rs);
			closeConnection(conn);
			
			return retorno;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static String [] searchOneLineNColumns(String sql, DatabaseName base) throws Exception {
		try {
			return searchOneLineNColumns(sql, null, null, base);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static String [] searchOneLineNColumns(String sql, String certificate, String mp, DatabaseName base) throws Exception {
		try {
			Connection conn = getConnection(base);
			ResultSet rs = executeQuery(sql, conn);			
			String [] retorno = readOneLineNColumn(rs);
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
	
	private static String [] readOneLineNColumn(ResultSet rs) throws Exception {
		try {
			String [] result = null;
			Object obj = null;
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while(rs.next()) {
				result = new String[columnCount];
				
				for (int i = 0; i < columnCount; i++) {
					obj = rs.getObject(i + 1);
					result [i] = readColumn(obj);
				}
			}
			
			return result;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	private static String readColumn(Object obj) {
		if (obj instanceof String) {
			return (String) obj;
		} else { // inteiro
			return String.valueOf(obj);
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
	
	private static String appendCertificateMasterPolicy(String sql, String certificate, String mp) {
		if (certificate != null) {
			sql += " and pc.policy_no = " + certificate;
		} else if (mp != null) {
			sql += " and mp.mp_no = " + mp;
		}
		
		return sql;
	}
	
}
