package denlu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.base;

/**
 * Servlet implementation class zhuce
 */
@WebServlet("/zhuce")
public class zhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public zhuce() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("UserName");
		String password = request.getParameter("password");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (name != null && password != null) {
			System.out.println("注册用户名" + name + "\r注册密码" + password);
			if (base.findName(name)) {
				// 已存在用户
				request.getRequestDispatcher("zhuce/zhuce1.html").forward(request, response);
			} else {
				// 注册成功
				base.add(name, password);
				base.look();
				request.setAttribute("name", name);
				System.out.println(request);
				request.getRequestDispatcher("login/login2.html").forward(request, response);
			}
		}
		// 未输入或第一次登录
		request.getRequestDispatcher("zhuce/zhuce.html").forward(request, response);
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

}
