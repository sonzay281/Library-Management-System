package com.ismt.LibraryManagement.backend.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ismt.LibraryManagement.backend.dao.UserDAO;
import com.ismt.LibraryManagement.backend.dbutils.DBConnection;
import com.ismt.LibraryManagement.backend.dbutils.SQLConstant;
import com.ismt.LibraryManagement.backend.entity.User;

public class UserDAOImpl implements UserDAO {
	private DBConnection db = new DBConnection();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private int result = 0;

	@Override
	public int createAccount(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		PreparedStatement stmt = db.initStatement(SQLConstant.NEWMEMBER);
		stmt.setInt(1, u.getSid());
		stmt.setString(2, u.getStudentName());
		result = db.update();
		int mid = db.getInsertId();
		if (result > 0) {
			stmt = db.initStatement(SQLConstant.NEWLOGIN);
			stmt.setInt(1, mid);
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			result = db.update();
			result = mid;
		} else {
			result = 0;
		}

		return result;

	}

	@Override
	public List<User> getByUserName(User u) throws ClassNotFoundException, SQLException {
		List<User> usrList = new ArrayList<>();

		db.connect();
		stmt = db.initStatement(SQLConstant.GETBYUSERNAME);
		stmt.setString(1, u.getEmail());
		rs = db.query();
		while (rs.next()) {
			u.setPassword(rs.getString("password"));
			u.setMid(rs.getInt("mid"));
			usrList.add(u);
		}
		db.close();
		return usrList;
	}

	@Override
	public List<User> getAllBooks() throws ClassNotFoundException, SQLException {

		List<User> bookList = new ArrayList<>();
		db.connect();
		stmt = db.initStatement(SQLConstant.GETALLBOOKS);
		rs = db.query();
		while (rs.next()) {
			User u = new User();

			u.setBid(rs.getInt("bid"));
			u.setBookName(rs.getString("bookName"));
			u.setSubject(rs.getString("subject"));
			u.setAuthor(rs.getString("author"));
			u.setAddedDate(rs.getDate("addedDate"));
			u.setPublication(rs.getString("publication"));
			u.setQuantity(rs.getInt("quantity"));
			bookList.add(u);
		}
		return bookList;
	}

	@Override
	public List<User> getBucketList(User u) throws ClassNotFoundException, SQLException {
		List<User> bookList = new ArrayList<>();
		db.connect();
		stmt = db.initStatement(SQLConstant.GETBUCKETLIST);
		stmt.setInt(1, u.getMid());
		rs = db.query();
		while (rs.next()) {
			User a=new User();
			a.setBid(rs.getInt("bid"));
			a.setBookName(rs.getString("bookName"));
			a.setSubject(rs.getString("subject"));
			a.setAuthor(rs.getString("author"));
			a.setIssueDate(rs.getDate("issueDate"));
			a.setPublication(rs.getString("publication"));
			a.setDueDate(rs.getDate("dueDate"));
			bookList.add(a);
		}
		return bookList;

	}

	@Override
	public int newBook(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		stmt = db.initStatement(SQLConstant.ADDBOOK);
		stmt.setString(1, u.getBookName());
		stmt.setString(2, u.getSubject());
		stmt.setString(3, u.getAuthor());
		stmt.setString(4, u.getPublication());
		stmt.setInt(5, u.getQuantity());

		result = db.update();
		if (result > 0) {
			result = db.getInsertId();
		}
		db.close();
		return result;
	}

	@Override
	public int updateBook(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		stmt = db.initStatement(SQLConstant.UPDATEBOOK);
		stmt.setString(1, u.getBookName());
		stmt.setString(2, u.getSubject());
		stmt.setString(3, u.getAuthor());
		stmt.setString(4, u.getPublication());
		stmt.setInt(5, u.getQuantity());
		stmt.setInt(6, u.getBid());
		result = db.update();
		db.close();
		return result;
	}

	@Override
	public int deleteBook(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		stmt = db.initStatement(SQLConstant.DELETEBOOK);
		stmt.setInt(1, u.getBid());
		int result = db.update();
		db.close();
		return result;
	}

	@Override
	public List<User> searchBook(User u) throws ClassNotFoundException, SQLException, IOException {
		List<User> bookList = new ArrayList<>();
		db.connect();
		stmt = db.initStatement(SQLConstant.GETBYBOOKID);
		stmt.setInt(1, u.getBid());
		System.out.println(u.getBid());
		rs = db.query();
		while (rs.next()) {

			u.setBid(rs.getInt("bid"));
			u.setSubject(rs.getString("subject"));
			u.setAddedDate(rs.getDate("addedDate"));
			u.setBookName(rs.getString("bookName"));
			u.setPublication(rs.getString("publication"));
			u.setAuthor(rs.getString("author"));
			u.setQuantity(rs.getInt("quantity"));
			bookList.add(u);
		}
		db.close();

		return bookList;
	}

	@Override
	public int borrowBook(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		// Extracting the quantity from book store
		stmt = db.initStatement(SQLConstant.GETQUANTITY);
		stmt.setInt(1, u.getBid());
		rs = db.query();
		if (rs.next()) {
			u.setQuantity(rs.getInt("quantity"));
		}
		int newQty = u.getQuantity() - 1;
		if (newQty <= 0) {
			return 0;
		} else {
			stmt = db.initStatement(SQLConstant.UPDATESTORE);
			stmt.setInt(1, newQty);
			stmt.setInt(2, u.getBid());
			int result = db.update();
			if (result > 0) {
				stmt = db.initStatement(SQLConstant.ISSUEBOOK);
				stmt.setInt(1, u.getMid());
				stmt.setInt(2, u.getBid());
				stmt.setDate(3, new java.sql.Date(u.getDueDate().getTime()));
				result = db.update();
			}
			db.close();
			return result;
		}

	}

	@Override
	public List<User> searchMember(User u) throws ClassNotFoundException, SQLException, IOException {
		List<User> memberList = new ArrayList<>();
		db.connect();
		stmt = db.initStatement(SQLConstant.GETBYMID);
		stmt.setInt(1, u.getMid());
		System.out.println(u.getMid());
		rs = db.query();
		while (rs.next()) {
			u.setMid(rs.getInt("mid"));
			u.setSid(rs.getInt("sid"));
			u.setStudentName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			memberList.add(u);
		}
		db.close();

		return memberList;
	}

	@Override
	public int returnBook(User u) throws ClassNotFoundException, SQLException, IOException {
		db.connect();
		// Extracting the quantity from book store
		stmt = db.initStatement(SQLConstant.GETQUANTITY);
		stmt.setInt(1, u.getBid());
		rs = db.query();
		if (rs.next()) {
			u.setQuantity(rs.getInt("quantity"));
		}
		int newQty = u.getQuantity() + 1;
		stmt = db.initStatement(SQLConstant.UPDATESTORE);
		stmt.setInt(1, newQty);
		stmt.setInt(2, u.getBid());
		int result = db.update();
		if (result > 0) {
			stmt = db.initStatement(SQLConstant.RETURNBOOK);
			stmt.setInt(1, u.getBid());
			stmt.setInt(2, u.getMid());
			result = db.update();
		}
		db.close();
		return result;

	}

}
