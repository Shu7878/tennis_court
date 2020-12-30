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

import tennisCourtServie.InsertCourt;

/**
 * Servlet implementation class InsertCourtServlet
 */
@WebServlet("/InsertCourt")
public class InsertCourtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "選手情報を入力してください");

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/insert.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String insertBtn = request.getParameter("btn");
		String jsp;

		try{
			//選手登録の場合
			if(insertBtn != null && insertBtn.equals("InsertCourt")){
				InsertCourt insert = new InsertCourt();
				insert.execute(request);
				jsp = "/insert.jsp";
			}else{
				request.setAttribute("errorMessage", "不正アクセスです");
				request.setAttribute("backAddress", "insert");
				jsp = "/error.jsp";
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "IDと金額には数値を入力して下さい");
			request.setAttribute("backAddress", "insert");
			jsp = "/error.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "JDBCのエラーです");
			request.setAttribute("backAddress", "insert");
			jsp = "/error.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMessage", "エラーが発生しました");
			request.setAttribute("backAddress", "insert");
			jsp = "/error.jsp";
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}
