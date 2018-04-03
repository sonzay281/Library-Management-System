/**
 * 
 */
package com.ismt.LibraryManagement.backend.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ZERO BYTE
 *
 */
public class DBConnection {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private DBConstants dbconn = new DBConstants();

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(dbconn.DRIVER_NAME);
		conn = DriverManager.getConnection(dbconn.DB_URL, dbconn.DB_USERNAME, dbconn.DB_PASSWORD);
	}

	public PreparedStatement initStatement(String sql) throws SQLException {
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		return stmt;

	}

	public ResultSet query() throws SQLException {
		return stmt.executeQuery();
	}

	public int update() throws SQLException {
		return stmt.executeUpdate();
	}

	public int getInsertId() throws SQLException {
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	public void close() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
		conn = null;
		stmt = null;
	}
}
