package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

// servlet core
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
// backend for servlet
import javax.sql.DataSource;

import service.BigUniqueRng;

public class SqlQuery {

	private static BigUniqueRng ranNumSet = null;
	static {
		// generate a random number Set
		ranNumSet = new BigUniqueRng(100000, 99999999);
	}

	public static ArrayList<ArrayList<String>> queryAll() {
		return queryAll(100);
	}

	public static ArrayList<ArrayList<String>> queryAll(int showRows) { // 指定顯示幾筆 int queryRows
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<ArrayList<String>> resList = null;
		// sql query
		String sqlTotalColumn = "select count(column_name)as columnAmount from information_schema.columns where table_name='orders'";
		String sql = "SELECT * FROM [practice].[dbo].[orders] order by modifyTime desc OFFSET 0 ROWS\r\n"
				+ "FETCH NEXT ? ROWS ONLY";
		try {
			// 抓取JNDI(Java Naming and Directory Interface)的DataSource資源
			// 情境A：每次本方法被呼叫時，就去抓取這個DataSource
			InitialContext initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/practice");

			conn = ds.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sqlTotalColumn);
			rs = pstmt.executeQuery();
			rs.next();
			int totalColumns = rs.getInt(1);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, showRows);
			rs = pstmt.executeQuery();
			resList = new ArrayList<ArrayList<String>>();
			while (rs.next()) {
				ArrayList<String> temp = new ArrayList<>();
				for (int i = 1; i <= totalColumns; i++) { // 11
					temp.add(rs.getString(i));
				}
				resList.add(temp);
				temp = null;
			}
			return resList;
			/////////////////// 釋放資源///////////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn == null)
				return resList;
			try {
				if (conn.isClosed())
					return resList;
				conn.close();
				System.out.println("連線已關閉");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resList;
	}

	public static ArrayList<ArrayList<String>> storeOrderdataToSql(HttpServletRequest req) { // return stored data
		// need to set utf-8 decode here?
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<ArrayList<String>> resList = null;
		// sql query
		String sqlTotalColumn = "select count(column_name)as columnAmount from information_schema.columns where table_name='orders'";
		String sql = "INSERT into orders ( item1Amount, item2Amount, item3Amount, item4Amount, item5Amount, item6Amount, \r\n"
				+ "    item7Amount, item8Amount, item9Amount, email, id ) VALUES ( ?,?,?,?,?,?,?,?,?,?,? )";
		String sqlQueryInserted = "SELECT * from orders where id = ?";
		try {
			// 抓取JNDI(Java Naming and Directory Interface)的DataSource資源
			// 情境A：每次本方法被呼叫時，就去抓取這個DataSource
			InitialContext initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/practice");

			conn = ds.getConnection();
			// 取得總欄數
			PreparedStatement pstmt = conn.prepareStatement(sqlTotalColumn);
			rs = pstmt.executeQuery();
			rs.next();
			int totalColumns = rs.getInt(1);
			// 執行新增orderData至sql
			pstmt = conn.prepareStatement(sql);
			// insert ? 1-9
			for (int i = 1; i <= 9; i++) {
				if ("".equals(req.getParameter(String.format("item_%d", i)))
						|| req.getParameter(String.format("item_%d", i)) == null) {
					pstmt.setInt(i, 0);
				} else {
					pstmt.setInt(i, Integer.valueOf(req.getParameter(String.format("item_%d", i))));
				}
			}
			pstmt.setString(10, req.getParameter("email"));
			// 上面都沒問題了才抽號碼牌
			int ranNum = ranNumSet.next();
			pstmt.setInt(11, ranNum);
			resList = new ArrayList<ArrayList<String>>();
			int CreateCount = pstmt.executeUpdate();
			if (CreateCount > 0) {
				pstmt = conn.prepareStatement(sqlQueryInserted);
				pstmt.setInt(1, ranNum);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ArrayList<String> temp = new ArrayList<>();
					for (int i = 1; i <= totalColumns; i++) { // 11
						temp.add(rs.getString(i));
					}
					resList.add(temp);
					temp = null;
				}
				return resList;
			} else {
				return null;
			}
/////////////////// 釋放資源///////////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn == null)
				return resList;
			try {
				if (conn.isClosed())
					return resList;
				conn.close();
				System.out.println("連線已關閉");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resList;
	}

	public static ArrayList<ArrayList<String>> updateOrderdataById(HttpServletRequest req, int inputID, String email) { // return
																														// updated
																														// data(mark
																														// the
																														// edited
		// value?)
		// need to set utf-8 decode here?
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<ArrayList<String>> resList = null;
		// sql query
		String sqlTotalColumn = "select count(column_name) as columnAmount from information_schema.columns where table_name='orders'";
		String sql = "UPDATE orders set item1Amount=?, item2Amount=?, item3Amount=?, item4Amount=?, item5Amount=?, item6Amount=?, \r\n"
				+ "    item7Amount=?, item8Amount=?, item9Amount=? where id=? and email=?";
		String sqlQueryInserted = "SELECT * from orders where id = ?";
		try {
			// 抓取JNDI(Java Naming and Directory Interface)的DataSource資源
			// 情境A：每次本方法被呼叫時，就去抓取這個DataSource
			InitialContext initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/practice");

			conn = ds.getConnection();
			// 取得總欄數
			PreparedStatement pstmt = conn.prepareStatement(sqlTotalColumn);
			rs = pstmt.executeQuery();
			rs.next();
			int totalColumns = rs.getInt(1);
			// 執行新增orderData至sql
			pstmt = conn.prepareStatement(sql);
			// insert ? 1-9
			for (int i = 1; i <= 9; i++) {
				if ("".equals(req.getParameter(String.format("item_%d", i)))
						|| req.getParameter(String.format("item_%d", i)) == null) {
					pstmt.setInt(i, 0);
				} else {
					pstmt.setInt(i, Integer.valueOf(req.getParameter(String.format("item_%d", i))));
				}
			}
			pstmt.setInt(10, inputID);
			if (email.equals("") || email == null) {
				pstmt.setNull(11, Types.VARCHAR);
			} else {
				pstmt.setString(11, email);
			}
			resList = new ArrayList<ArrayList<String>>();
			int UpdateCount = pstmt.executeUpdate();
			if (UpdateCount > 0) {
				pstmt = conn.prepareStatement(sqlQueryInserted);
				pstmt.setInt(1, inputID);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ArrayList<String> temp = new ArrayList<>();
					for (int i = 1; i <= totalColumns; i++) { // 11
						temp.add(rs.getString(i));
					}
					resList.add(temp);
					temp = null;
				}
				return resList;
			} else {
				return null;
			}
			/////////////////// 釋放資源///////////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn == null)
				return resList;
			try {
				if (conn.isClosed())
					return resList;
				conn.close();
				System.out.println("連線已關閉");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resList;
	}

	public static ArrayList<ArrayList<String>> queryOrderdataById(HttpServletRequest req, int inputID, String email) { // return
																														// data
		// by id
		// need to set utf-8 decode here?
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<ArrayList<String>> resList = null;
		// sql query
		String sqlTotalColumn = "select count(column_name)as columnAmount from information_schema.columns where table_name='orders'";
		String sqlQueryInserted = "SELECT * from orders where id = ? and email = ?";
		try {
			// 抓取JNDI(Java Naming and Directory Interface)的DataSource資源
			// 情境A：每次本方法被呼叫時，就去抓取這個DataSource
			InitialContext initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/practice");

			conn = ds.getConnection();
			// 取得總欄數
			PreparedStatement pstmt = conn.prepareStatement(sqlTotalColumn);
			rs = pstmt.executeQuery();
			rs.next();
			int totalColumns = rs.getInt(1);
			resList = new ArrayList<ArrayList<String>>();
			pstmt = conn.prepareStatement(sqlQueryInserted);
			pstmt.setInt(1, inputID);
			if (email.equals("") || email == null) {
				pstmt.setNull(2, Types.VARCHAR);
			} else {
				pstmt.setString(2, email);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> temp = new ArrayList<>();
				for (int i = 1; i <= totalColumns; i++) { // 11
					temp.add(rs.getString(i));
				}
				resList.add(temp);
				temp = null;
			}
			return resList;
/////////////////// 釋放資源///////////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn == null)
				return resList;
			try {
				if (conn.isClosed())
					return resList;
				conn.close();
				System.out.println("連線已關閉");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resList;
	}

	public static ArrayList<ArrayList<String>> deleteOrderdataById(HttpServletRequest req, int inputID, String email) { // return
																														// updated
																														// data(mark
																														// the
																														// edited
		// value?)
// need to set utf-8 decode here?
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<ArrayList<String>> resList = null;
// sql query
		String sqlTotalColumn = "select count(column_name) as columnAmount from information_schema.columns where table_name='orders'";
		String sql = "UPDATE orders set diliverStatus=-1 where id=? and email=?";
		String sqlQueryInserted = "SELECT * from orders where id = ?";
		try {
// 抓取JNDI(Java Naming and Directory Interface)的DataSource資源
// 情境A：每次本方法被呼叫時，就去抓取這個DataSource
			InitialContext initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/practice");

			conn = ds.getConnection();
// 取得總欄數
			PreparedStatement pstmt = conn.prepareStatement(sqlTotalColumn);
			rs = pstmt.executeQuery();
			rs.next();
			int totalColumns = rs.getInt(1);
// 執行新增orderData至sql
			pstmt = conn.prepareStatement(sql);
// insert ? 1-9
//			for (int i = 1; i <= 9; i++) {
//				if ("".equals(req.getParameter(String.format("item_%d", i)))
//						|| req.getParameter(String.format("item_%d", i)) == null) {
//					pstmt.setInt(i, 0);
//				} else {
//					pstmt.setInt(i, Integer.valueOf(req.getParameter(String.format("item_%d", i))));
//				}
//			}
			pstmt.setInt(1, inputID);
			if (email.equals("") || email == null) {
				pstmt.setNull(2, Types.VARCHAR);
			} else {
				pstmt.setString(2, email);
			}
			resList = new ArrayList<ArrayList<String>>();
			int UpdateCount = pstmt.executeUpdate();
			if (UpdateCount > 0) {
				pstmt = conn.prepareStatement(sqlQueryInserted);
				pstmt.setInt(1, inputID);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ArrayList<String> temp = new ArrayList<>();
					for (int i = 1; i <= totalColumns; i++) { // 11
						temp.add(rs.getString(i));
					}
					resList.add(temp);
					temp = null;
				}
				return resList;
			} else {
				return null;
			}
/////////////////// 釋放資源///////////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn == null)
				return resList;
			try {
				if (conn.isClosed())
					return resList;
				conn.close();
				System.out.println("連線已關閉");
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resList;
	}
}
