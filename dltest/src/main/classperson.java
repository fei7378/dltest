package main;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.person;

/**
 * Servlet implementation class classperson
 */
@WebServlet("/classperson")
public class classperson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Map> list;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public classperson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("HttpServletRequest", request);
		System.out.println(request);
		// 增加

		// String classar = request.getParameter("class");
		// int classnum = 0;
		// if (classar == null || classar.equals("")) {
		// classnum = 0;
		// } else {
		// classnum = Integer.parseInt(classar);
		// }
		//
		// String name = request.getParameter("name");
		//
		// String num = request.getParameter("num");
		// int number;
		// if (num == null || num.equals("")) {
		// number = 0;
		// } else {
		// number = Integer.parseInt(num);
		// }
		// // 删除行号
		// String ind = request.getParameter("index");
		// int index;
		// if (ind == null || ind.equals("")) {
		// index = 0;
		// } else {
		// index = Integer.parseInt(ind);
		// System.out.println("获取到行号为" + index);
		// }
		// System.out.println("index:" + index);
		// System.out.println("name:" + name);
		// System.out.println("number:" + number);
		// System.out.println("classnum:" + classnum);
		// // 增加函数
		// if (name != null && number != 0 && classnum != 0 && index == 0) {
		// person.add(name, number, classnum);
		// }
		// // 删除函数
		// if (name == null && number == 0 && classnum == 0 && index != 0) {
		// person.delete(index);
		// }
		// // 修改函数
		// if (name != null && number != 0 && classnum != 0 && index != 0) {
		// person.update(index, name, number, classnum);
		// }
		// // String flag = (String) request.getAttribute("flag");
		// // if (flag.equals("1")) {
		// //
		// // }
		list = person.lookForList(0);
		System.out.println("跳转");
		request.setAttribute("key_list", list);// 将list集合数据放入到request中共享

		request.getRequestDispatcher("test/userList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static void cleanlist() {// 清除列
		list = null;
	}
}
