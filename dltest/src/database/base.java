package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class base {

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// ?useUnicode=true&characterEncoding=utf-8&useSSL=false
	// 在数据库名后添加以上代码可防止连接警告
	// static final String DB_URL =
	// "jdbc:mysql://localhost:3306/data_name?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	static final String DB_URL = "jdbc:mysql://localhost:3306/dl?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	// static final String DB_URL = "jdbc:mysql:/home/fei/data_name.sql";
	// 数据库的用户名与密码，需要根据自己的设置
	final static String USER = "root";
	final static String PASS = "fei7378";
	private static String pass = "返回值失败";

	// public static void main(String[] args) {
	// base1();
	// }
	// 向数据库增加账户
	public static void add(String UserName, String Password) {
		Connection conn = null;
		Statement stmt = null;
		int id1 = 0;
		try {
			// 注册 JDBC 驱动 --不进行注册本地可运行这个方法但不能在tomcat中运行
			Class.forName("com.mysql.jdbc.Driver");
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;

			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			sql = "SELECT id,UserName, Password FROM pass";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("id");
				// 查询最大id号
				if (id > id1) {
					id1 = id;
				}
				// String name = rs.getString("UserName");
				// setUrl(rs.getString("Password"));
				//
				// // 输出数据
				// System.out.print("ID: " + id);
				// System.out.print(",账号: " + name);
				// System.out.print(",密码: " + getUrl());
				// System.out.print("\n");
			}
			sql = "insert into pass(id,UserName,Password) values(" + (id1 + 1) + ",'" + UserName + "','" + Password
					+ "')";
			// sql = "update table_name set url='" + newurl + "' where url ='" + oldurl +
			// "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			// // 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");

	}

	// 查看数据库中的所有密码
	public static void look() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动 --不进行注册本地可运行这个方法但不能在tomcat中运行
			Class.forName("com.mysql.jdbc.Driver");
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id,UserName, Password FROM pass";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("id");
				String name = rs.getString("UserName");
				setpass(rs.getString("Password"));

				// 输出数据
				System.out.print("ID: " + id);
				System.out.print(",账号: " + name);
				System.out.print(",密码: " + getpass());
				System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");

	}

	// 查询是否存在用户名
	public static boolean findName(String newname) {
		boolean fd = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动 --不进行注册本地可运行这个方法但不能在tomcat中运行
			Class.forName("com.mysql.jdbc.Driver");
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id,UserName, Password FROM pass";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("id");
				String name = rs.getString("UserName");
				if (name.equals(newname)) {
					fd = true;
					break;
				}
				// setUrl(rs.getString("Password"));

				// 输出数据
				// System.out.print("ID: " + id);
				// System.out.print(",账号: " + name);
				// System.out.print(",密码: " + getUrl());
				// System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return fd;
	}

	// 判断登录
	public static boolean findNametopass(String oldname, String oldpass) {
		boolean np = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动 --不进行注册本地可运行这个方法但不能在tomcat中运行
			Class.forName("com.mysql.jdbc.Driver");
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id,UserName, Password FROM pass";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("id");
				String name = rs.getString("UserName");
				setpass(rs.getString("Password"));
				if (name.equals(oldname) && getpass().equals(oldpass)) {
					np = true;
					break;
				}
				// setUrl(rs.getString("Password"));

				// 输出数据
				// System.out.print("ID: " + id);
				// System.out.print(",账号: " + name);
				// System.out.print(",密码: " + getUrl());
				// System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return np;
	}

	public static String getpass() {
		return pass;
	}

	public static void setpass(String pass) {
		base.pass = pass;
	}
}