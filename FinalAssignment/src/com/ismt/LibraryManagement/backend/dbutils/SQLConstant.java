/**
 * 
 */
package com.ismt.LibraryManagement.backend.dbutils;

/**
 * @author ZERO BYTE
 *
 */
public class SQLConstant {

	/****************
	 * Query related to new member and new book insert
	 ******************/

	// The following query will create the new member in database
	// table(tbl_user)
	public static final String NEWMEMBER = "INSERT INTO " + TableConstant.USER_TABLE + "(sid,name) VALUES(?,?)";

	// The following query is for inserting data in rbl_login
	public static final String NEWLOGIN = "INSERT INTO " + TableConstant.LOGIN_TABLE + "(mid,email,password"
			+ ") VALUES(?,?,?)";

	public static final String GETBYUSERNAME = "SELECT password,mid FROM " + TableConstant.LOGIN_TABLE
			+ " WHERE email=?";

	public static final String GETBYMID = "SELECT tu.mid,sid,name,email,password FROM " + TableConstant.USER_TABLE
			+ " tu join " + TableConstant.LOGIN_TABLE + " tl ON tu.mid=tl.mid where tu.mid=?";

	/************************************                          ************************************/

	/************************************                          ************************************/

	// The following query is for inserting books in database
	public static final String ADDBOOK = "INSERT INTO " + TableConstant.STORE_TABLE
			+ "(bookName,subject,author,publication,quantity) VALUES(?,?,?,?,?)";

	public static final String UPDATEBOOK = "UPDATE " + TableConstant.STORE_TABLE
			+ " SET bookname=?,subject=?,author=?,publication=?,quantity=? WHERE bid=?";

	public static final String DELETEBOOK = "DELETE FROM " + TableConstant.STORE_TABLE + " WHERE bid=?";

	/************************************                          ************************************/

	/************************************                          ************************************/

	// The following query is for book issue(to store book in student bucket
	// table)
	public static final String ISSUEBOOK = "INSERT INTO " + TableConstant.BUCKET_TABLE
			+ "(mid,bid,dueDate) VALUES(?,?,?)";

	public static final String UPDATESTORE = "UPDATE " + TableConstant.STORE_TABLE + " SET quantity=? WHERE bid=?";

	public static final String GETQUANTITY = "SELECT quantity FROM " + TableConstant.STORE_TABLE + " where bid=?";

	public static final String RETURNBOOK = "DELETE FROM " + TableConstant.BUCKET_TABLE + " WHERE bid=? and mid=?";
	/************************************                          ************************************/

	/************************************                          ************************************/
	public static final String GETALLBOOKS = "SELECT * FROM " + TableConstant.STORE_TABLE;

	public static final String GETBYBOOKID = "SELECT * FROM " + TableConstant.STORE_TABLE + " WHERE bid=?";

	public static final String GETBUCKETLIST = "SELECT bt.bid,st.bookName,st.subject,st.author,st.publication,bt.issueDate,bt.dueDate FROM "
			+ TableConstant.BUCKET_TABLE + " bt join " + TableConstant.STORE_TABLE + " st on bt.bid=st.bid WHERE mid=?";

}