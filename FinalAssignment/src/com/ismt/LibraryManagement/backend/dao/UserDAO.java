/**
 * 
 */
package com.ismt.LibraryManagement.backend.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ismt.LibraryManagement.backend.entity.User;

/**
 * @author ZERO BYTE
 *
 */
public interface UserDAO {
	int createAccount(User u) throws ClassNotFoundException, SQLException, IOException;

	List<User> getByUserName(User u) throws ClassNotFoundException, SQLException;

	List<User> getAllBooks() throws ClassNotFoundException, SQLException;

	List<User> getBucketList(User u) throws ClassNotFoundException, SQLException;

	int newBook(User u) throws ClassNotFoundException, SQLException, IOException;

	int updateBook(User u) throws ClassNotFoundException, SQLException, IOException;

	int deleteBook(User u) throws ClassNotFoundException, SQLException, IOException;

	List<User> searchBook(User u) throws ClassNotFoundException, SQLException, IOException;

	List<User> searchMember(User u) throws ClassNotFoundException, SQLException, IOException;

	int borrowBook(User u) throws ClassNotFoundException, SQLException, IOException;

	int returnBook(User u) throws ClassNotFoundException, SQLException, IOException;
}
