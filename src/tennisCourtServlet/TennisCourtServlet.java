package tennisCourtServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tennisCourtServie.NameSearch;

/**
 * Servlet implementation class TennisCourtServler
 */
@WebServlet("/TennisCourt")
public class TennisCourtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/confirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchBtn = request.getParameter("btn");
		String jsp;

		try{
			if(searchBtn != null && searchBtn.equals("NameSearch")){
				NameSearch names = new NameSearch();
				names.execute(request);
				jsp = "/confirm.jsp";
			}else if(searchBtn == null){
				NameSearch names = new NameSearch();
				names.execute(request);
				jsp = "/confirm.jsp";
			}else{
				request.setAttribute("errorMessage", "不正アクセスです");
				request.setAttribute("backAddress", "TennisCourt");
				jsp = "/error.jsp";
			}
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "JDBCのエラーです");
			request.setAttribute("backAddress", "TennisCourt");
			jsp = "/error.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "エラーが発生しました");
			request.setAttribute("backAddress", "TennisCourt");
			jsp = "/error.jsp";
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}
