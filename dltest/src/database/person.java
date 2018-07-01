package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class person {
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// ?useUnicode=true&characterEncoding=utf-8&useSSL=false
	// 在数据库名后添加以上代码可防止连接警告
	// static final String DB_URL =
	// "jdbc:mysql://localhost:3306/data_name?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	static final String DB_URL = "jdbc:mysql://localhost:3306/class?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	// static final String DB_URL = "jdbc:mysql:/home/fei/data_name.sql";
	// 数据库的用户名与密码，需要根据自己的设置
	final static String USER = "root";
	final static String PASS = "fei7378";

	// public static void main(String[] args) {
	// base1();
	// }
	// 向数据库增加账户

	public static void add(String name, int number, int classnum) {
		Connection conn = null;
		Statement stmt = null;
		int id1 = 0;
		int id = 0;
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
			sql = "SELECT id,name, number,class FROM person";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				id = rs.getInt("id");
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
			sql = "insert into person(id,name,number,class) values(" + (id + 1) + ",'" + name + "'," + number + ","
					+ classnum + ")";
			// sql = "update table_name set url='" + newurl + "' where url ='" + oldurl +
			// "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
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

	// 查看数据库中的所有
	public static List<Map> lookForList(int classnum1) {// 输入班级号 若为0则是学生界面
		List<Map> list = new ArrayList<Map>();// 创建list集合用于存入map的键值对集合
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
			sql = "SELECT id,name, number,class FROM person";

			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索

				int classnum = rs.getInt("class");
				if (classnum1 == 0) {
					String name = rs.getString("name");
					int number = rs.getInt("number");
					int id = rs.getInt("id");
					Map map = new HashMap();
					map.put("id", id); // 用键值对存入到map集合中
					map.put("name", name);
					map.put("number", number);
					map.put("classnum", classnum);
					list.add(map);// 在将map集合对象存入list集合
					System.out.println("放入集合");
					for (Map map_1 : list) {
						System.out.println(map_1);
					} // 在打印台遍历出数据查看是否有错误

					// 输出数据
					System.out.print("ID: " + id);
					System.out.print(",姓名: " + name);
					System.out.print(",学号: " + number);
					System.out.print(",班级: " + classnum);
					System.out.print("\n");
				} else if (classnum1 == classnum) {
					String name = rs.getString("name");
					int number = rs.getInt("number");
					int id = rs.getInt("id");
					Map map = new HashMap();
					map.put("id", id); // 用键值对存入到map集合中
					map.put("name", name);
					map.put("number", number);
					map.put("classnum", classnum);
					list.add(map);// 在将map集合对象存入list集合
					System.out.println("放入集合");
					for (Map map_1 : list) {
						System.out.println(map_1);
					} // 在打印台遍历出数据查看是否有错误

					// 输出数据
					System.out.print("ID: " + id);
					System.out.print(",姓名: " + name);
					System.out.print(",学号: " + number);
					System.out.print(",班级: " + classnum);
					System.out.print("\n");
				}
				//
				// else if (idnum == id) {
				// String name = rs.getString("name");
				// int number = rs.getInt("number");
				// Map map = new HashMap();
				// map.put("id", id); // 用键值对存入到map集合中
				// map.put("name", name);
				// map.put("number", number);
				// list.add(map);// 在将map集合对象存入list集合
				// System.out.println("放入集合");
				// for (Map map_1 : list) {
				// System.out.println(map_1);
				// } // 在打印台遍历出数据查看是否有错误
				//
				// // 输出数据
				// System.out.print("ID: " + id);
				// System.out.print(",姓名: " + name);
				// System.out.print(",学号: " + number);
				// System.out.print("\n");
				// }
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
		return list;

	}

	// 删除
	public static void delete(int index) {
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
			// sql = "SELECT id,UserName, Password FROM person";
			// ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			// while (rs.next()) {
			// 通过字段检索
			// int id = rs.getInt("id");
			// // 查询最大id号
			// if (id > id1) {
			// id1 = id;
			// }
			// String name = rs.getString("UserName");
			// setUrl(rs.getString("Password"));
			//
			// // 输出数据
			// System.out.print("ID: " + id);
			// System.out.print(",账号: " + name);
			// System.out.print(",密码: " + getUrl());
			// System.out.print("\n");
			// }
			sql = "DELETE FROM person WHERE id=" + index;
			// sql = "update table_name set url='" + newurl + "' where url ='" + oldurl +
			// "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			// // 完成后关闭
			// rs.close();
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

	// 修改
	public static void update(int id, String name, int number, int classnum) {
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
			sql = "SELECT id,name, number,class FROM person";

			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			int id1 = 0;

			String name1 = null;
			int number1 = 0;
			int classnum1 = 0;
			while (rs.next()) {
				// 通过字段检索

				id1 = rs.getInt("id");
				if (id == id1) {
					name1 = rs.getString("name");
					number1 = rs.getInt("number");
					classnum1 = rs.getInt("class");

					// 输出数据
					System.out.print("ID: " + id);
					System.out.print(",姓名: " + name);
					System.out.print(",学号: " + number);
					System.out.print(",班级: " + classnum);
					System.out.print("\n");
					break;
				}
			}
			if (name.equals("0")) {
				name = name1;
			}
			if (number == 0) {
				number = number1;
			}
			if (classnum == 0) {
				classnum = classnum1;
			}
			if (id == id1) {
				sql = "update person set name='" + name + "',number=" + number + ",classnum=" + classnum
						+ " where id = " + id;
				// sql = "update table_name set url='" + newurl + "' where url ='" + oldurl +
				// "'";
				System.out.println(sql);
				stmt.executeUpdate(sql);
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
}