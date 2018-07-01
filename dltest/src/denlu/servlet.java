package denlu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.base;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// public servlet() {
	// super();
	// // TODO Auto-generated constructor stub
	// }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("UserName");
		String password = request.getParameter("password");

		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// try {
		// response.getWriter().write("text123");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// String test = request;
		String nameold = (String) request.getAttribute("name");
		if (name != null && password != null) {
			System.out.println("登录用户名" + name + "\r登录密码" + password);
			if (base.findNametopass(name, password)) {
				// 进入主界面
				request.setAttribute("name", name);
				request.getSession().setAttribute("name", name);
				System.out.println(request);
				request.getRequestDispatcher("/index").forward(request, response);

			} else {
				// 用户名或密码错误
				request.getRequestDispatcher("login/login1.html").forward(request, response);
			}
		} else if (nameold != null) {
			// if (nameold.equals(name)) {
			request.getSession().setAttribute("name", name);
			request.getRequestDispatcher("/index").forward(request, response);
			// }
		}

		// 未输入或第一次登录
		request.getRequestDispatcher("login/login.html").forward(request, response);
		// request.getRequestDispatcher("/index").forward(request, response);
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
